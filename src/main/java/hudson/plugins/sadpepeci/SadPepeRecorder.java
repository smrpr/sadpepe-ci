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

import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.BuildListener;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Recorder;

import java.io.IOException;
import java.util.logging.Logger;

import org.kohsuke.stapler.DataBoundConstructor;

/**
 * This class associates a FeelingsStatus to a job or a build. For more info
 * @author smrpr
 */
public class SadPepeRecorder extends Recorder {

    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger
            .getLogger(SadPepeRecorder.class.getName());

    /**
     * SadQuote generator.
     */
    private SadQuoteGenerator sadQuoteGenerator;

    /**
     * Constructs a {@link SadPepeRecorder} with default
     * {@link SadQuoteGenerator}.
     */
    @DataBoundConstructor
    public SadPepeRecorder() {
        this(new SadQuoteGenerator());
    }

    /**
     * Constructs a {@link SadPepeRecorder} with specified
     * {@link SadQuoteGenerator}.
     * @param sadQuoteGenerator
     *            the sadquote generator
     */
    public SadPepeRecorder(final SadQuoteGenerator sadQuoteGenerator) {
        this.sadQuoteGenerator = sadQuoteGenerator;
        LOGGER.info("Sad Pepe is activated");
    }

    /**
     * Gets the FeelingsStatus as the project action. This is applicable for
     * each job and only when there's at least one build in the job.
     * @param project
     *            the project
     * @return the project action
     */
    @Override
    public final Action getProjectAction(final AbstractProject<?, ?> project) {
        Action action = null;
        if (project.getLastBuild() != null) {
            Style style = Style.get(project.getLastBuild().getResult());
            String sadquote = sadQuoteGenerator.random();
            action = new FeelingsStatus(style, sadquote);
        }
        return action;
    }

    /**
     * Adds FeelingsStatus to the build actions. This is applicable for each
     * build.
     * @param build
     *            the build
     * @param launcher
     *            the launcher
     * @param listener
     *            the listener
     * @return true
     * @throws InterruptedException
     *             when there's an interruption
     * @throws IOException
     *             when there's an IO error
     */
    @Override
    public final boolean perform(final AbstractBuild<?, ?> build,
            final Launcher launcher, final BuildListener listener)
            throws InterruptedException, IOException {
        Style style = Style.get(build.getResult());
        String sadquote = sadQuoteGenerator.random();
        build.getActions().add(new FeelingsStatus(style, sadquote));
        return true;
    }

    /**
     * Gets the required monitor service.
     * @return the BuildStepMonitor
     */
    public final BuildStepMonitor getRequiredMonitorService() {
        return BuildStepMonitor.NONE;
    }
}
