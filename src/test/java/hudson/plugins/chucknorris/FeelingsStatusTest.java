package hudson.plugins.sadpepe-ci;

import junit.framework.TestCase;

public class FeelingsStatusTest extends TestCase {

	private FeelingsStatus action;

	public void setUp() {
		action = new FeelingsStatus(Style.CRY_PEPE,
				"Support pepe economy, pls don't steal.");
	}

	public void testAccessors() {
		assertEquals(Style.CRY_PEPE, action.getStyle());
		assertEquals("Support pepe economy, pls don't steal.", action
				.getSadQuote());
		assertEquals("Sad Pepe", action.getDisplayName());
		assertNull(action.getIconFileName());
		assertEquals("sadpepe", action.getUrlName());
	}
}
