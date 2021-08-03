package com.amai.ar.thegame

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class TheGameActivityTest {

    private val mGenerated = "ABC"

    @get : Rule
    public var mActivityTestRule = ActivityTestRule(
        TheGameActivity::class.java
    )


    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {
    }

    @Test
    fun testUserInputScenario() {
        // perform button A click
        Espresso.onView(withId(R.id.buttonA)).perform(click())

        // perform button B click
        Espresso.onView(withId(R.id.buttonB)).perform(click())
        // perform button C click
        Espresso.onView(withId(R.id.buttonC)).perform(click())
        // checking the text in the textview
        Espresso.onView(withId(R.id.textView_guess)).check(matches(withText(mGenerated)))
    }

}