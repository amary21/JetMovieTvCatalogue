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
import com.amary.app.data.jetmovietvcat.utils.GlideApp;
import com.amary.app.data.jetmovietvcat.viewmodel.ViewModelFactory;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    public static final String TITLE_MOVIE = "title_movie";

    @BindView(R.id.txt_detail_movie_date)
    TextView txtDetailDateMovie;
    @BindView(R.id.txt_detail_movie_rate)
    TextView txtDetailRateMovie;
    @BindView(R.id.txt_detail_movie_sinopsis)
    TextView txtDetailSynopsisMovie;
    @BindView(R.id.img_detail_movie_poster)
    ImageView imgDetailPosterMovie;
    @BindView(R.id.img_detail_movie_bg)
    ImageView imgDetailBgMovie;
    @BindView(R.id.pb_loading_detail)
    ProgressBar pbLoadingDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DetailMovieViewModel viewModel = obtainViewModel(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }



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
