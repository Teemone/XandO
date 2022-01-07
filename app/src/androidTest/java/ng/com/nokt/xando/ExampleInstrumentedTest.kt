package ng.com.nokt.xando

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule


@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get: Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("ng.com.nokt.xando", appContext.packageName)
    }

    @Test
    fun click_random_button(){
        onView(withId(R.id.btn1)).
                perform(click())
    }

    @Test
    fun check_button_text_displayed_matches_intended(){
        onView(withId(R.id.btn1)).
                perform(click())
        onView(withId(R.id.btn1)).
                check(matches(withText("X")))
    }

    @Test
    fun player_one_win_and_play_again(){
//        Player one's turn
        onView(withId(R.id.btn1)).
                perform(click())
//        Player two's turn

        onView(withId(R.id.btn2)).
                perform(click())
//        Player one's turn

        onView(withId(R.id.btn4)).
                perform(click())
//        Player two's turn

        onView(withId(R.id.btn3)).
                perform(click())
//        Player one's turn

        onView(withId(R.id.btn7)).
                perform(click())

//        Click the YES! button to play again
        onView(withText("YES!")).
            inRoot(isDialog())
            .perform(click())

    }

    @Test
    fun player_two_win_and_play_again(){
//        Player one's turn
        onView(withId(R.id.btn5)).
        perform(click())
//        Player two's turn

        onView(withId(R.id.btn1)).
        perform(click())
//        Player one's turn

        onView(withId(R.id.btn2)).
        perform(click())
//        Player two's turn

        onView(withId(R.id.btn4)).
        perform(click())
//        Player one's turn

        onView(withId(R.id.btn3)).
        perform(click())

//        Player two's turn

        onView(withId(R.id.btn7)).
        perform(click())

//        Click the YES! button to play again
        onView(withText("YES!")).
        inRoot(isDialog())
            .perform(click())

    }

    @Test
    fun game_over(){
//        Player one's turn
        onView(withId(R.id.btn1)).
        perform(click())

//        Player two's turn
        onView(withId(R.id.btn2)).
        perform(click())

//        Player one's turn
        onView(withId(R.id.btn3)).
        perform(click())

//        Player two's turn
        onView(withId(R.id.btn7)).
        perform(click())

//        Player one's turn
        onView(withId(R.id.btn8)).
        perform(click())

//        Player two's turn
        onView(withId(R.id.btn9)).
        perform(click())

//        Player one's turn
        onView(withId(R.id.btn4)).
        perform(click())

//        Player two's turn
        onView(withId(R.id.btn5)).
        perform(click())

//        Player one's turn
        onView(withId(R.id.btn6)).
        perform(click())

//        Click the NO button to end the activity
        onView(withText("NO")).
        inRoot(isDialog())
            .perform(click())

    }


}