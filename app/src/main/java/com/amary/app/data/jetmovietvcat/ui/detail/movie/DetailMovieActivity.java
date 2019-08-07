package com.amary.app.data.jetmovietvcat.ui.detail.movie;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import com.amary.app.data.jetmovietvcat.R;
import com.amary.app.data.jetmovietvcat.data.source.local.entity.MovieEntity;
import com.amary.app.data.jetmovietvcat.utils.DataDummy;
import com.amary.app.data.jetmovietvcat.utils.GlideApp;
import com.amary.app.data.jetmovietvcat.viewmodel.ViewModelFactory;
import com.bumptech.glide.request.RequestOptions;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    public static final String TITLE_MOVIE = "title_movie";

    private TextView txtDetailDateMovie;
    private TextView txtDetailRateMovie;
    private TextView txtDetailSynopsisMovie;
    private ImageView imgDetailPosterMovie;
    private ImageView imgDetailBgMovie;
    private ProgressBar pbLoadingDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DetailMovieViewModel viewModel = obtainViewModel(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        txtDetailDateMovie = findViewById(R.id.txt_detail_movie_date);
        txtDetailRateMovie = findViewById(R.id.txt_detail_movie_rate);
        txtDetailSynopsisMovie = findViewById(R.id.txt_detail_movie_sinopsis);
        imgDetailPosterMovie = findViewById(R.id.img_detail_movie_poster);
        imgDetailBgMovie = findViewById(R.id.img_detail_movie_bg);
        pbLoadingDetail = findViewById(R.id.pb_loading_detail);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String movieId = extras.getString(EXTRA_MOVIE);
            String movieTitle = extras.getString(TITLE_MOVIE);
            if (movieId != null) {
                viewModel.setMovieId(movieId);
                getSupportActionBar().setTitle(movieTitle);
            }
        }

        viewModel.getMovies().observe(this, movieEntity -> {
            if (movieEntity != null){
                populateMovie(movieEntity);
                pbLoadingDetail.setVisibility(View.GONE);
            }
        });

    }

    @NonNull
    private static DetailMovieViewModel obtainViewModel(AppCompatActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(DetailMovieViewModel.class);
    }

    private void populateMovie(MovieEntity movieEntity) {
            txtDetailDateMovie.setText(movieEntity.getMovieDate());
            txtDetailRateMovie.setText(movieEntity.getMovieRate());
            txtDetailSynopsisMovie.setText(movieEntity.getMovieSynopsis());

            GlideApp.with(getApplicationContext())
                    .load(movieEntity.getImgMoviePoster())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(imgDetailPosterMovie);

            GlideApp.with(getApplicationContext())
                    .load(movieEntity.getImgMovieBg())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(imgDetailBgMovie);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
