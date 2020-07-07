package com.amary.app.data.jetmovietvcat.di;

import android.app.Application;

import com.amary.app.data.jetmovietvcat.data.source.JetMovieTvRepository;
import com.amary.app.data.jetmovietvcat.data.source.local.LocalRepository;
import com.amary.app.data.jetmovietvcat.data.source.remote.RemoteRepository;
import com.amary.app.data.jetmovietvcat.utils.JsonHelper;

public class Injection {
    public static JetMovieTvRepository provideRepository(Application application){
        LocalRepository localRepository = new LocalRepository();
        RemoteRepository remoteRepository = RemoteRepository.getInstance(new JsonHelper(application));

        return JetMovieTvRepository.getInstance(localRepository, remoteRepository);
    }
}
