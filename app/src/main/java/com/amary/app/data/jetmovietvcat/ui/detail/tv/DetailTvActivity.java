package com.amary.app.data.jetmovietvcat.ui.detail.tv;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import com.amary.app.data.jetmovietvcat.R;
import com.amary.app.data.jetmovietvcat.data.TvShowEntity;
import com.amary.app.data.jetmovietvcat.utils.DataDummy;
import com.amary.app.data.jetmovietvcat.utils.GlideApp;
import com.bumptech.glide.request.RequestOptions;

public class DetailTvActivity extends AppCompatActivity {

    public static final String EXTRA_TV = "extra_tv";

    private TextView txtDetailDateTvShow;
    private TextView txtDetailRateTvShow;
    private TextView txtDetailSynopsisTvShow;
    private ImageView imgDetailPosterTvShow;
    private ImageView imgDetailBgTvShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DetailTvViewModel viewModel = ViewModelProviders.of(this).get(DetailTvViewModel.class);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        txtDetailDateTvShow = findViewById(R.id.txt_detail_tvshow_date);
        txtDetailRateTvShow = findViewById(R.id.txt_detail_tvshow_rate);
        txtDetailSynopsisTvShow = findViewById(R.id.txt_detail_tvshow_sinopsis);
        imgDetailPosterTvShow = findViewById(R.id.img_detail_tvshow_poster);
        imgDetailBgTvShow = findViewById(R.id.img_detail_tvshow_bg);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String tvId = extras.getString(EXTRA_TV);
            if (tvId != null) {
                viewModel.setTvId(tvId);
            }
        }
        if (viewModel.getTvShow() != null) {
            populateTv(viewModel.getTvId());
        }

    }

    private void populateTv(String tvId) {
        TvShowEntity tvShowEntity = DataDummy.getTvShowEntity(tvId);

        if (getSupportActionBar() != null && tvShowEntity != null) {
            getSupportActionBar().setTitle(tvShowEntity.getTvTitle());

            txtDetailDateTvShow.setText(tvShowEntity.getTvDate());
            txtDetailRateTvShow.setText(tvShowEntity.getTvRate());
            txtDetailSynopsisTvShow.setText(tvShowEntity.getTvSynopsis());

            GlideApp.with(getApplicationContext())
                    .load(tvShowEntity.getImgTvPoster())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(imgDetailPosterTvShow);

            GlideApp.with(getApplicationContext())
                    .load(tvShowEntity.getImgTvBg())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(imgDetailBgTvShow);
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
