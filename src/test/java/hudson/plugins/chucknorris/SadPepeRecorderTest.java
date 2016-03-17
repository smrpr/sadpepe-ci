package hudson.plugins.sadpepe-ci;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.Build;
import hudson.model.BuildListener;
import hudson.model.Result;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class SadPepeRecorderTest extends TestCase {

	private SadQuoteGenerator mockGenerator;
	private SadPepeRecorder recorder;

	@Override
	public void setUp() {
		mockGenerator = mock(SadQuoteGenerator.class);
		recorder = new SadPepeRecorder(mockGenerator);
	}

	public void testGetProjectActionWithNoLastBuildGivesNullAction() {
		AbstractProject mockProject = mock(AbstractProject.class);
		when(mockProject.getLastBuild()).thenReturn(null);
		assertNull(recorder.getProjectAction(mockProject));
	}

	public void testGetProjectActionHavingLastBuildGivesFeelingsStatus() {
		AbstractProject mockProject = mock(AbstractProject.class);
		Build mockBuild = mock(Build.class);

		when(mockProject.getLastBuild()).thenReturn(mockBuild);
		when(mockBuild.getResult()).thenReturn(Result.SUCCESS);
		when(mockGenerator.random()).thenReturn(
				"Nobody cares");

		Action action = recorder.getProjectAction(mockProject);

		assertTrue(action instanceof FeelingsStatus);
		assertEquals(Style.SMUG_PEPE, ((FeelingsStatus) action).getStyle());
		assertNotNull(((FeelingsStatus) action).getSadQuote());
	}

	public void testPerformWithFailureResultAddsFeelingsStatusWithCryPepeStyleAndExpectedFact()
			throws Exception {
		List<Action> actions = new ArrayList<Action>();
		AbstractBuild mockBuild = mock(AbstractBuild.class);
		when(mockBuild.getResult()).thenReturn(Result.FAILURE);
		when(mockBuild.getActions()).thenReturn(actions);

		when(mockGenerator.random()).thenReturn(
				"Nobody cares");

		assertEquals(0, actions.size());

		recorder.perform(mockBuild, mock(Launcher.class),
				mock(BuildListener.class));

		assertEquals(1, actions.size());
		assertTrue(actions.get(0) instanceof FeelingsStatus);
		assertEquals(Style.CRY_PEPE, ((FeelingsStatus) actions.get(0))
				.getStyle());
		assertEquals("Nobody cares",
				((FeelingsStatus) actions.get(0)).getSadQuote());
	}
}
