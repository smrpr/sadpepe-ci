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
package hudson.plugins.sadpepe-ci;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import hudson.model.Action;

/**
 * {@link FeelingsStatus} keeps the style and sadquote associated with the action.
 * @author smrpr
 */
public final class FeelingsStatus implements Action {

    /**
     * The style - for backward compatibility to version 0.2.
     */
    private Style style;
    
    /**
     * The style.
     */
    private Style mStyle;

    /**
     * The sadquote - for backward compatibility to version 0.2.
     */
    private String sadquote;
    
    /**
     * The sadquote.
     */
    private String mSadQuote;

    /**
     * Constructs a FeelingsStatus with specified style and sadquote.
     * @param style
     *            the style
     * @param sadquote
     *            the sadquote
     */
    public FeelingsStatus(final Style style, final String sadquote) {
        super();
        this.mStyle = style;
        this.mSadQuote = sadquote;
    }

    /**
     * Gets the action display name.
     * @return the display name
     */
    public String getDisplayName() {
        return "Sad Pepe";
    }

    /**
     * This action doesn't provide any icon file.
     * @return null
     */
    public String getIconFileName() {
        return null;
    }

    /**
     * Gets the URL name for this action.
     * @return the URL name
     */
    public String getUrlName() {
        return "sadpepe";
    }

    /**
     * Gets the Sad Pepe style.
     * @return the style
     */
    @SuppressFBWarnings(value = "UWF_UNWRITTEN_FIELD", justification = "that field could have been deserialized from old <= 0.2")
    public Style getStyle() {
        Style theStyle;
        if (mStyle != null) {
            theStyle = mStyle;
        } else {
            theStyle = style;
        }
        return theStyle;
    }

    /**
     * Gets the sad quote.
     * @return the quote
     */
    @SuppressFBWarnings(value = "UWF_UNWRITTEN_FIELD", justification = "that field could have been deserialized from old <= 0.2")
    public String getSadQuote() {
        String theSadQuote;
        if (mSadQuote != null) {
            theSadQuote = mSadQuote;
        } else {
            theSadQuote = sadquote;
        }
        return theSadQuote;
    }
}
