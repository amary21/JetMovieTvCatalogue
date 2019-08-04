package com.amary.app.data.jetmovietvcat.ui.detail.movie;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import com.amary.app.data.jetmovietvcat.R;
import com.amary.app.data.jetmovietvcat.data.local.MovieEntity;
import com.amary.app.data.jetmovietvcat.utils.DataDummy;
import com.amary.app.data.jetmovietvcat.utils.GlideApp;
import com.bumptech.glide.request.RequestOptions;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

    private TextView txtDetailDateMovie;
    private TextView txtDetailRateMovie;
    private TextView txtDetailSynopsisMovie;
    private ImageView imgDetailPosterMovie;
    private ImageView imgDetailBgMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DetailMovieViewModel viewModel = ViewModelProviders.of(this).get(DetailMovieViewModel.class);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        txtDetailDateMovie = findViewById(R.id.txt_detail_movie_date);
        txtDetailRateMovie = findViewById(R.id.txt_detail_movie_rate);
        txtDetailSynopsisMovie = findViewById(R.id.txt_detail_movie_sinopsis);
        imgDetailPosterMovie = findViewById(R.id.img_detail_movie_poster);
        imgDetailBgMovie = findViewById(R.id.img_detail_movie_bg);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String movieId = extras.getString(EXTRA_MOVIE);
            if (movieId != null) {
                viewModel.setMovieId(movieId);
            }
        }

        if (viewModel.getMovies() != null) {
            populateMovie(viewModel.getMovieId());
        }


    }

    private void populateMovie(String movieId) {
        MovieEntity movieEntity = DataDummy.getMovieEntity(movieId);

        if (getSupportActionBar() != null && movieEntity != null) {
            getSupportActionBar().setTitle(movieEntity.getMovieTitle());

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
