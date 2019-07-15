package com.route.islamiappgfri;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.route.islamiappgfri.Adapters.SurasRecyclerAdapter;


public class QuranFragment extends Fragment {

    public QuranFragment() {
        // Required empty public constructor
    }



    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SurasRecyclerAdapter adapter;

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_quran, container, false);
        recyclerView=view.findViewById(R.id.recycler_view);

        adapter=new SurasRecyclerAdapter(Constants.ArSuras);
        adapter.setOnItemClickListener(new SurasRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, String suraName) {
                Intent i= new Intent(
                        getContext(),SuraDetailsActivity.class);
                SuraDetailsActivity.position=pos;
                SuraDetailsActivity.suraName=suraName;
                i.putExtra("position",pos);
                i.putExtra("suraName",suraName);
                startActivity(i);
            }
        });
        layoutManager=new GridLayoutManager(getContext(),3,LinearLayoutManager.HORIZONTAL,
                false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        return view;
    }


}
