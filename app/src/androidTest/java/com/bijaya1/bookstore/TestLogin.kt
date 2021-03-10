package com.bijaya1.bookstore

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
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
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun  checkArithmetic() {
        Espresso.onView(withId(R.id.etUsername))
            .perform(ViewActions.typeText("1"))

        Thread.sleep(1000)

        Espresso.onView(withId(R.id.etPassword))
            .perform(ViewActions.typeText("2"))

        Espresso.closeSoftKeyboard()

        Espresso.onView(withId(R.id.btnLogin))
            .perform(ViewActions.click())
    }

}