package hudson.plugins.sadpepeci;

import hudson.model.Result;
import junit.framework.TestCase;

public class StyleTest extends TestCase {

	public void testGetWithFailureResultGivesCryPepeStyle() {
		assertEquals(Style.CRY_PEPE, Style.get(Result.FAILURE));
	}

	public void testGetWithSuccessResultGivesSmugPepeStyle() {
		assertEquals(Style.SMUG_PEPE, Style.get(Result.SUCCESS));
	}

	public void testGetWithAbortedResultGivesSweatyPepeStyle() {
		assertEquals(Style.SWEATY_PEPE, Style.get(Result.ABORTED));
	}

	public void testGetWithNotBuiltResultGivesSweatyPepeStyle() {
		assertEquals(Style.SWEATY_PEPE, Style.get(Result.NOT_BUILT));
	}

	public void testGetWithUnstableResultGivesSweatyPepeStyle() {
		assertEquals(Style.SWEATY_PEPE, Style.get(Result.UNSTABLE));
	}
}
