package com.amary.app.data.jetmovietvcat.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.amary.app.data.jetmovietvcat.data.source.JetMovieTvRepository;
import com.amary.app.data.jetmovietvcat.di.Injection;
import com.amary.app.data.jetmovietvcat.ui.detail.movie.DetailMovieViewModel;
import com.amary.app.data.jetmovietvcat.ui.detail.tv.DetailTvViewModel;
import com.amary.app.data.jetmovietvcat.ui.movie.MovieViewModel;
import com.amary.app.data.jetmovietvcat.ui.tv.TvShowViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static volatile ViewModelFactory INSTANCE;

    private final JetMovieTvRepository jetMovieTvRepository;

    private ViewModelFactory(JetMovieTvRepository jetMovieTvRepository) {
        this.jetMovieTvRepository = jetMovieTvRepository;
    }

    public static ViewModelFactory getInstance(Application application){
        if (INSTANCE == null){
            synchronized (ViewModelFactory.class){
                if (INSTANCE == null){
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(application));
                }
            }
        }

        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(MovieViewModel.class)){
            //noinspection unchecked
            return (T) new MovieViewModel(jetMovieTvRepository);
        }else if (modelClass.isAssignableFrom(TvShowViewModel.class)){
            //noinspection unchecked
            return (T) new TvShowViewModel(jetMovieTvRepository);
        }else if (modelClass.isAssignableFrom(DetailMovieViewModel.class)){
            //noinspection unchecked
            return (T) new DetailMovieViewModel(jetMovieTvRepository);
        }else if (modelClass.isAssignableFrom(DetailTvViewModel.class)){
            //noinspection unchecked
            return (T) new DetailTvViewModel(jetMovieTvRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
