package edu.luc.etl.cs313.android.simplestopwatch.android;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;

import org.junit.Rule;
import org.junit.runner.RunWith;

import edu.luc.etl.cs313.android.simplestopwatch.test.android.AbstractStopwatchActivityTest;

/**
 * Concrete Android test subclass. Has to inherit from framework class
 * and uses delegation to concrete subclass of abstract test superclass.
 * IMPORTANT: project must export JUnit 4 to make it available on the
 * device.
 *
 * Uses ActivityScenarioRule instead of the deprecated ActivityTestRule.
 * Since the abstract test superclass calls getActivity() repeatedly (including
 * from within runOnUiThread lambdas), getActivity() re-resolves the current
 * Activity reference via ActivityScenario.onActivity() each time, per the
 * recommended migration pattern for callers that need direct Activity access.
 *
 * @author laufer
 * @see "https://developer.android.com/training/testing/ui-testing/"
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class StopwatchActivityTest extends AbstractStopwatchActivityTest {

    @Rule
    public final ActivityScenarioRule<StopwatchAdapter> activityRule =
            new ActivityScenarioRule<>(StopwatchAdapter.class);

    @Override
    protected StopwatchAdapter getActivity() {
        final StopwatchAdapter[] holder = new StopwatchAdapter[1];
        activityRule.getScenario().onActivity(activity -> holder[0] = activity);
        return holder[0];
    }
}
