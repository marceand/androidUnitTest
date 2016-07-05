package com.marceme.androidunittest;

import android.os.Build;
import android.os.SystemClock;
import android.view.inputmethod.EditorInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

/**
 * Created by Marcel on 7/5/2016.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class MainActivityTest {

    MainActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void messageEditorUpdatesDisplayText() throws Exception{

        // Arrange
        String expectedString = "testingWithRobolectric";
        activity.editor.setText(expectedString);

        // Act
        activity.send.performClick();

        // Assert
        String actualString = activity.display.getText().toString();
        assertEquals(expectedString, actualString);
    }

}