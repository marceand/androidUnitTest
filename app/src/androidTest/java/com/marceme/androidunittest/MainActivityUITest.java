package com.marceme.androidunittest;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by Marcel on 7/7/2016.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void messageEditorUpdatesDisplayText() throws Exception{

        // Arrange
        String expectedString = "testingWithRobolectric";
        onView(withId(R.id.messageEditor)).perform(typeText(expectedString));

        // Act
        onView(withId(R.id.sendButton)).perform(click());

        // Assert
        onView(withId(R.id.displayText)).check(matches(withText(expectedString)));
    }

}