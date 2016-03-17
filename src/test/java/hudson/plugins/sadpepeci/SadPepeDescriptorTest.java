package hudson.plugins.sadpepeci;

import static org.mockito.Mockito.mock;
import hudson.model.AbstractProject;
import junit.framework.TestCase;

public class SadPepeDescriptorTest extends TestCase {

	private SadPepeDescriptor descriptor;

	public void setUp() {
		descriptor = new SadPepeDescriptor();
	}

	public void testGetDisplayName() {
		assertEquals("Activate Sad Pepe", descriptor.getDisplayName());
	}

	public void testIsApplicableGivesTrue() {
		assertTrue(descriptor.isApplicable(mock(AbstractProject.class)
				.getClass()));
	}
}
