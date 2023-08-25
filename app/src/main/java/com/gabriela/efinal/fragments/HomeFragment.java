package com.gabriela.efinal.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.gabriela.efinal.data.response.ShowResponse;
import com.gabriela.efinal.data.retrofit.RetrofitHelper;
import com.gabriela.efinal.databinding.FragmentHomeBinding;
import com.gabriela.efinal.model.Dog;
import com.gabriela.efinal.model.Shows;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeViewModel = ViewModelProvider.AndroidViewModelFactory
                .getInstance(getActivity().getApplication())
                .create(HomeViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        RVResumeAdapter adapter = new RVResumeAdapter(getData());
        binding.rvMoviesResume.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.rvMoviesResume.setLayoutManager(layoutManager);


        RetrofitHelper.getService().getShow().enqueue(new Callback<ShowResponse>() {
            @Override
            public void onResponse(Call<ShowResponse> call, Response<ShowResponse> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    showMovies(response.body().getShowsList());
                }
            }

            @Override
            public void onFailure(Call<ShowResponse> call, Throwable t) {

            }
        });
        homeViewModel.listLiveData.observe(requireActivity(), showList ->{
            for (int i = 0 ; i < showList.size() ; i++){
                Log.d("Shows", showList.get(i).getName());
            }
        });
        homeViewModel.getShows();
    }


    private void showMovies(List<Shows> showsList) {
        RVShowAdapter adapter = new RVShowAdapter(showsList, show -> {
            homeViewModel.addShow(show);
        });
        binding.rvShows.setAdapter(adapter);
    }

    private List<Shows> getData() {
        List<Shows> shows = new ArrayList<>();
        shows.add(new Dog("Perro Lobo", "https://images.dog.ceo/breeds/husky/n02110185_2593.jpg", "12"));
        shows.add(new Dog("Perro Golden Retriver", "https://images.dog.ceo/breeds/retriever-golden/n02099601_6318.jpg", "3"));
        shows.add(new Dog("Perro lhasa", "https://images.dog.ceo/breeds/lhasa/n02098413_4100.jpg", "5"));
        shows.add(new Dog("Perro finnish lapphund", "https://images.dog.ceo/breeds/finnish-lapphund/mochilamvan.jpg", "1"));

        return shows;
    }
}


