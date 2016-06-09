package com.example.wda.github;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    ActivityController<MainActivity> activityController;

    @Before
    public void prepareForTest(){
        activityController= Robolectric.buildActivity(MainActivity.class);
    }

    @Test
    public void activityCreated() throws Exception{
        assertNotNull(activityController.create().get());
    }

    @Test
    public void activityStarted() throws Exception{
        assertNotNull(activityController.create().start().get());
    }

    @Test
    public void activityResumed() throws Exception{
        assertNotNull(activityController.create().start().resume().visible().get());
    }
}