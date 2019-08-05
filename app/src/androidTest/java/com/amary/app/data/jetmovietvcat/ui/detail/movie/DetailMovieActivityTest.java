package com.amary.app.data.jetmovietvcat.ui.detail.movie;

import android.content.Context;
import android.content.Intent;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.amary.app.data.jetmovietvcat.R;
import com.amary.app.data.jetmovietvcat.data.local.MovieEntity;
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

public class DetailMovieActivityTest {

    private MovieEntity dummyMovie = FakeDataDummy.generateDummyMovies().get(0);

    @Rule
    public ActivityTestRule<DetailMovieActivity> activityTestRule = new ActivityTestRule<DetailMovieActivity>(DetailMovieActivity.class){
        @Override
        protected Intent getActivityIntent(){
            Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent intent = new Intent(context, DetailMovieActivity.class);
            intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, dummyMovie.getMovieId());

            return intent;
        }
    };

    @Before
    public void setUp(){}


    @After
    public void tearDown(){

    }

    @Test
    public void loadMovie(){
        onView(withId(R.id.txt_detail_movie_date)).check(matches(isDisplayed()));
        onView(withId(R.id.txt_detail_movie_date)).check(matches(withText(dummyMovie.getMovieDate())));
        onView(withId(R.id.txt_detail_movie_rate)).check(matches(isDisplayed()));
        onView(withId(R.id.txt_detail_movie_rate)).check(matches(withText(dummyMovie.getMovieRate())));
    }
}