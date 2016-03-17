/**
 * Copyright (c) 2016 Samuel Parra
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package hudson.plugins.sadpepeci;

import java.util.Random;

/**
 * {@link SadQuoteGenerator} provides sad quotes.
 * @author smrpr
 */
public class SadQuoteGenerator {

    private static final String[] FACTS = {
            "Support pepe economy, pls don't steal.",
            "1998 is as far away as 2034",
            "We all are fragile.",
            "Nobody cares",
            "No dreams. Only tears now.",
            "Born too late to explore the Earth. Born to soon to explore the galaxy."};

    /**
     * Random instance.
     */
    private static final Random RANDOM = new Random();

    /**
     * Retrieves a random quote.
     * @return a random quote
     */
    public String random() {
        return FACTS[RANDOM.nextInt(FACTS.length)];
    }
}
