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

import hudson.model.Result;

/**
 * This class provides various Pepe's styles.
 * @author smrpr
 */
public enum Style {

    /**
     * A smug Pepe.
     */
    SMUG_PEPE,
    /**
     * A quite nervous Pepe.
     */
    SWEATY_PEPE,
    /**
     * A Pepe crying in pain.
     */
    CRY_PEPE;

    /**
     * Gets the style corresponding to the build result.
     * @param result
     *            the build result
     * @return the style
     */
    public static final Style get(final Result result) {
        Style style;
        if (Result.FAILURE.equals(result)) {
            style = CRY_PEPE;
        } else if (Result.SUCCESS.equals(result)) {
            style = SMUG_PEPE;
        } else {
            style = SWEATY_PEPE;
        }
        return style;
    }
}
