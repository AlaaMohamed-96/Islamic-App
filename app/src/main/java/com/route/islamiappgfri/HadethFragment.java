package com.route.islamiappgfri;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.route.islamiappgfri.Adapters.HadethAdapter;
import com.route.islamiappgfri.Model.Hadeth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



public class HadethFragment extends Fragment {


    public HadethFragment() {
        //
        //Required empty public constructor
    }

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    HadethAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_hadeth, container, false);
        recyclerView=view.findViewById(R.id.recycler_view);
        readHadethFile();
        adapter=new HadethAdapter(allAhadeth);
        adapter.setOnItemClickListener(new HadethAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, Hadeth Hadeth) {
                HadethDialogFragment dialogFragment=new HadethDialogFragment();
                dialogFragment.setHadeth(Hadeth);
                dialogFragment.show(getChildFragmentManager(),"");

            }
        });
        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }


    List<Hadeth> allAhadeth;
    void readHadethFile() {
        BufferedReader reader;
        allAhadeth=new ArrayList<>();
        try{
            final InputStream file = getActivity().
                    getAssets().open("ahadeth.txt");
            reader = new BufferedReader(new InputStreamReader(file));
            String line =null;
            ;
            while((line=reader.readLine()) != null){
              //  Log.d("StackOverflow", line);
                String title=line;
                String content="";
                while( (line = reader.readLine())!=null){
                    if(line.trim().equals("#")) break;
                    content=content+"\n"+line;
                }
                Hadeth hadeth=new Hadeth(title,content);
                allAhadeth.add(hadeth);
            }
        } catch(IOException ioe){
            ioe.printStackTrace();
        }

    }
}
