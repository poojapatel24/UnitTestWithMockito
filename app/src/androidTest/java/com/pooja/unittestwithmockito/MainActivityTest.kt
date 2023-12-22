package com.pooja.unittestwithmockito

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{
    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val intentsTestRule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun loginSuccess(){

        // Type valid credentials and click the login button
        Espresso.onView(withId(R.id.etEmail)).perform(ViewActions.typeText("mona@gmail.com"))
        Espresso.onView(withId(R.id.etPassword)).perform(ViewActions.typeText("123456"))
        Espresso.onView(withId(R.id.btnLogin)).perform(ViewActions.click())
        //SystemClock.sleep(2000)
        // Check if the next screen is displayed (replace with appropriate view id or text)
        // onView(withText("Successfully Login")).inRoot(ToastMatcher()).check(matches(isDisplayed()))
        // Assert that the NextActivity is launched
       // Intents.intended(hasComponent(HomeActivity::class.java.name))

    }

    @Test
    fun loginFailure() {
        // Type invalid credentials and click the login button
        Espresso.onView(withId(R.id.etEmail)).perform(ViewActions.typeText(" "))
        Espresso.onView(withId(R.id.etPassword)).perform(ViewActions.typeText(" "))
        Espresso.onView(withId(R.id.btnLogin)).perform(ViewActions.click())

        // Check if the error message is displayed (replace with appropriate view id or text)
        // onView(withText("Invalid credentials")).inRoot(ToastMatcher()).check(matches(isDisplayed()))
    }

}