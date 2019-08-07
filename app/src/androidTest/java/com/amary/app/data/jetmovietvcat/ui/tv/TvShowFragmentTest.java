package com.amary.app.data.jetmovietvcat.ui.tv;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.amary.app.data.jetmovietvcat.R;
import com.amary.app.data.jetmovietvcat.testing.SingleFragmentActivity;
import com.amary.app.data.jetmovietvcat.utils.EspressoIdlingResource;
import com.amary.app.data.jetmovietvcat.utils.RecyclerViewItemCountAssertion;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class TvShowFragmentTest {

    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityTestRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private TvShowFragment tvShowFragment = new TvShowFragment();

    @Before
    public void setUp(){
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
        activityTestRule.getActivity().setFragment(tvShowFragment);
    }

    @After
    public void tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadTvShows(){
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.rv_tvs)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tvs)).check(new RecyclerViewItemCountAssertion(10));
    }

    @Test
    public void clickMovie(){
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.rv_tvs)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tvs)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }
}