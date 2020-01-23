package com.jlmcdeveloper.exemplomvp;

import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.filters.LargeTest;

import com.jlmcdeveloper.exemplomvp.ui.listcar.ViewHolder;
import com.jlmcdeveloper.exemplomvp.ui.main.MainActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class CrudCarInstrumentedTest {

    private static final String NAME_CAR = "Carro Teste";
    private static final String YEAR_CAR = "1995";

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);



    @Test
    public void addCar(){
        onView(withId(R.id.btnAddCar)).perform(click());

        onView(withId(R.id.ed_name)).perform(typeText(NAME_CAR), closeSoftKeyboard());

        onView(withId(R.id.ed_year)).perform(typeText(YEAR_CAR), closeSoftKeyboard());

        onView(withId(R.id.btn_add_car)).perform(click());
    }


    @Test
    public void validateCarAddition(){
        onView(withId(R.id.btnListCar)).perform(click());

        onView(withId(R.id.rc_view))
                .perform(RecyclerViewActions.scrollToHolder(isCarAddInListView(NAME_CAR)));

        onView(ViewMatchers.withText(YEAR_CAR)).check(matches(isDisplayed()));
    }


    @Test
    public void deleteCar(){
        onView(withId(R.id.btnListCar)).perform(click());

        onView(withId(R.id.rc_view)).perform(
                RecyclerViewActions.actionOnHolderItem(isCarAddInListView(NAME_CAR),
                        MyViewAction.clickChildViewWithId(R.id.btn_remove_car)));

    }





    private Matcher<ViewHolder> isCarAddInListView(final String carName){

        return new TypeSafeMatcher<ViewHolder>() {
            @Override
            protected boolean matchesSafely(ViewHolder item) {

                return carName.contains(item.getTextViewName().getText());
            }

            @Override
            public void describeTo(Description description) {

            }

        };
    }

    //=============== Action click button ===============
    public static class MyViewAction {

        public static ViewAction clickChildViewWithId(final int id) {
            return new ViewAction() {
                @Override
                public Matcher<View> getConstraints() {
                    return null;
                }

                @Override
                public String getDescription() {
                    return "Click on a child view with specified id.";
                }

                @Override
                public void perform(UiController uiController, View view) {
                    View v = view.findViewById(id);
                    v.performClick();
                }
            };
        }

    }
}
