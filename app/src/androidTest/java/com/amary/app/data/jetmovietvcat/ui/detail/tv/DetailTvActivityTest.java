package com.amary.app.data.jetmovietvcat.ui.detail.tv;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.amary.app.data.jetmovietvcat.R;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.TvShowEntity;
import com.amary.app.data.jetmovietvcat.utils.EspressoIdlingResource;
import com.amary.app.data.jetmovietvcat.utils.FakeDataDummy;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class DetailTvActivityTest {

    private TvShowEntity dummyTvShows = FakeDataDummy.generateDummyTvShows().get(0);

    @Rule
    public ActivityTestRule<DetailTvActivity> activityTestRule = new ActivityTestRule<DetailTvActivity>(DetailTvActivity.class){
        @Override
        protected Intent getActivityIntent(){
            Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent intent = new Intent(context, DetailTvActivity.class);
            intent.putExtra(DetailTvActivity.EXTRA_TV, dummyTvShows.getTvId());

            return intent;
        }
    };

    @Before
    public void setUp(){
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }


    @After
    public void tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadMovie(){
        onView(withId(R.id.txt_detail_tvshow_date)).check(matches(isDisplayed()));
        onView(withId(R.id.txt_detail_tvshow_date)).check(matches(withText(dummyTvShows.getTvDate())));
        onView(withId(R.id.txt_detail_tvshow_rate)).check(matches(isDisplayed()));
        onView(withId(R.id.txt_detail_tvshow_rate)).check(matches(withText(dummyTvShows.getTvRate())));
    }

}