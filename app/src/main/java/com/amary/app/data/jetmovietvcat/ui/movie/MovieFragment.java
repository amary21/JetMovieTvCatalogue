package com.amary.app.data.jetmovietvcat.ui.movie;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amary.app.data.jetmovietvcat.R;
import com.amary.app.data.jetmovietvcat.viewmodel.ViewModelFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private RecyclerView rvMovie;
    private ProgressBar progressBar;

    public MovieFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return new MovieFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMovie = view.findViewById(R.id.rv_movies);
        progressBar = view.findViewById(R.id.pb_loading);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            progressBar.setVisibility(View.VISIBLE);
            MovieViewModel viewModel = obtainViewModel(getActivity());

            MovieAdapter adapter = new MovieAdapter(getActivity());

            viewModel.getMovies().observe(this, movieEntities -> {
                progressBar.setVisibility(View.GONE);
                adapter.setListMovie(movieEntities);
                adapter.notifyDataSetChanged();
            });

            rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
            rvMovie.setHasFixedSize(true);
            rvMovie.setAdapter(adapter);
        }
    }

    @NonNull
    private static MovieViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(MovieViewModel.class);
    }
}
