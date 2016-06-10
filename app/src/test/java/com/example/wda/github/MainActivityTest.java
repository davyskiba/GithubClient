package com.example.wda.github;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    public void activtyHasButtonWithLoginText(){
        MainActivity activity = getVisibleActivty();
        Button button= (Button) activity.findViewById(R.id.login_button);

        assertEquals(View.VISIBLE,button.getVisibility());
        assertEquals("Login",button.getText());
    }

    @Test
    public void activtyHasLoginEditTextWithLoginHint(){
        MainActivity activity = getVisibleActivty();
        EditText editText= (EditText) activity.findViewById(R.id.login_input );

        assertEquals(View.VISIBLE,editText.getVisibility());
        assertEquals("login",editText.getHint());
    }

    @Test
    public void activityHasPasswordEditTestWithPasswordHint(){
        MainActivity activity=getVisibleActivty();
        EditText editText= (EditText) activity.findViewById(R.id.password_input);

        assertEquals(View.VISIBLE,editText.getVisibility());
        assertEquals("password",editText.getHint());
    }

    private MainActivity getVisibleActivty() {
        return activityController.create().start().resume().visible().get();
    }
}