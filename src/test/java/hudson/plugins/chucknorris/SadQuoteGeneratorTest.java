package hudson.plugins.sadpepe-ci;

import junit.framework.TestCase;

public class SadQuoteGeneratorTest extends TestCase {

	private SadQuoteGenerator generator;

	public void setUp() {
		generator = new SadQuoteGenerator();
	}

	public void testRandomGivesAtLeast2SadQuotes() {
		String lastSadQuote = null;
		for (int i = 0; i < 1000000; i++) {
			String currSadQuote = generator.random();
			if (lastSadQuote != null && !lastSadQuote.equals(currSadQuote)) {
				return;
			}
			lastSadQuote = currSadQuote;
		}
		fail("Random should give at least 2 different sad quotes in 1000000 tries.");
	}
}
