package com.bijaya1.bookstore

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.bijaya1.weekfiveassignmentone.LoginActivity
import com.bijaya1.weekfiveassignmentone.MainActivity
import com.bijaya1.weekfiveassignmentone.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@LargeTest
@RunWith(JUnit4::class)
class TestLogin {
    @get:Rule
    val uiTestRule = ActivityScenarioRule(LoginActivity::class.java);
    @Test
    fun testLogin() {
        onView(withId(R.id.etUsername))
            .perform(clearText())
            .perform(typeText("ooooo"));
        Thread.sleep(1500);
        onView(withId(R.id.etPassword))
            .perform(clearText())
            .perform(typeText("ppppp"));
        Thread.sleep(1500);
        closeSoftKeyboard();
        onView(withId(R.id.btnLogin))
            .perform(click());
        Thread.sleep(2000);

    }

}