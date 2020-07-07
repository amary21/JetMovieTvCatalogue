package com.amary.app.data.jetmovietvcat.ui.detail.tv;

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
import com.amary.app.data.jetmovietvcat.data.source.local.entity.TvShowEntity;
import com.amary.app.data.jetmovietvcat.utils.GlideApp;
import com.amary.app.data.jetmovietvcat.viewmodel.ViewModelFactory;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailTvActivity extends AppCompatActivity {

    public static final String EXTRA_TV = "extra_tv";
    public static final String TITLE_TV = "title_tv";

    @BindView(R.id.txt_detail_tvshow_date)
    TextView txtDetailDateTvShow;
    @BindView(R.id.txt_detail_tvshow_rate)
    TextView txtDetailRateTvShow;
    @BindView(R.id.txt_detail_tvshow_sinopsis)
    TextView txtDetailSynopsisTvShow;
    @BindView(R.id.img_detail_tvshow_poster)
    ImageView imgDetailPosterTvShow;
    @BindView(R.id.img_detail_tvshow_bg)
    ImageView imgDetailBgTvShow;
    @BindView(R.id.pb_loading_detail)
    ProgressBar pbLoadingDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DetailTvViewModel viewModel = obtainViewModel(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String tvId = extras.getString(EXTRA_TV);
            String tvTitle = extras.getString(TITLE_TV);
            if (tvId != null) {
                viewModel.setTvId(tvId);
                getSupportActionBar().setTitle(tvTitle);
            }
        }

        viewModel.getTvShow().observe(this, tvShowEntity -> {
            if (tvShowEntity != null){
                populateTv(tvShowEntity);
                pbLoadingDetail.setVisibility(View.GONE);
            }
        });

    }

    @NonNull
    private static DetailTvViewModel obtainViewModel(AppCompatActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity,factory).get(DetailTvViewModel.class);
    }

    private void populateTv(TvShowEntity tvShowEntity) {
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
