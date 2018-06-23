package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.udacity.gradle.builditbigger.backend.myApi.model.JokeContainer;
import com.zflabs.jokedisplayer.DisplayJokeActivity;
import com.zflabs.jokeprovider.Joke;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

        @Rule
        public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

        @Rule
        public IntentsTestRule<DisplayJokeActivity> mActivityRule = new IntentsTestRule<>(
                DisplayJokeActivity.class);

        @Test
        public void checkNutellaClickable() throws Exception {
            onView(withId(R.id.joke_button)).perform(click());
            intended(allOf(
                    hasExtra(Intent.EXTRA_TEXT, "I used to like my neighbors, until they put a password on their Wi-Fi."),
                    hasComponent(DisplayJokeActivity.class.getName()),
                    toPackage("com.udacity.gradle.builditbigger")
            ));
        }
    }
