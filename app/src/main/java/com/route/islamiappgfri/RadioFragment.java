package com.route.islamiappgfri;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.route.islamiappgfri.API.APIManager;
import com.route.islamiappgfri.API.Model.RadioChannelsResponse;
import com.route.islamiappgfri.API.Model.RadiosItem;
import com.route.islamiappgfri.Adapters.RadioChannelsRecyclerAdapter;
import com.route.islamiappgfri.Base.BaseFragment;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class RadioFragment extends BaseFragment {


    public RadioFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    View view;
    RadioChannelsRecyclerAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view= inflater.inflate(R.layout.fragment_radio, container, false);
         recyclerView=view.findViewById(R.id.recycler_view);
         initRecycler();
        getRadioChannelsFromApi();
        return view;
    }

    public void initRecycler(){
        recyclerView.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false));
        adapter=new RadioChannelsRecyclerAdapter(null);
        recyclerView.setAdapter(adapter);
        SnapHelper snapHelper= new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        adapter.setOnPlayClickListener(new RadioChannelsRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, RadiosItem radiosItem) {
                playChannel(radiosItem.getRadioUrl());
            }
        });
        adapter.setOnStopClickListener(new RadioChannelsRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, RadiosItem radiosItem) {
                stopChannel();
            }
        });

    }


    MediaPlayer mediaPlayer;
    public void playChannel(String url){
        stopChannel();
        mediaPlayer=new MediaPlayer();
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayer.start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
            showMessage(R.string.error,R.string.cannot_play_this_url,R.string.ok);
        }


    }
    public void stopChannel(){
        if(mediaPlayer!=null&&mediaPlayer.isPlaying())
            mediaPlayer.stop();
    }

    public void getRadioChannelsFromApi(){
        showProgressBar(R.string.loading);
        APIManager.getApis().getRadioChannels()
                .enqueue(new Callback<RadioChannelsResponse>() {
                    @Override
                    public void onResponse(Call<RadioChannelsResponse> call,
                                           Response<RadioChannelsResponse> response) {
                        hideProgressDialog();
                        adapter.changeData(response.body().getRadios());
                    }

                    @Override
                    public void onFailure(Call<RadioChannelsResponse> call, Throwable t) {
                        hideProgressDialog();
                    }
                });
    }

}
