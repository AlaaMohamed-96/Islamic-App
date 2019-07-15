package com.route.islamiappgfri;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.route.islamiappgfri.Adapters.SuraContentRecyclerAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SuraDetailsActivity extends AppCompatActivity {

    static int position;
    static String suraName;
    String intentSuraName;
    int intentSuraPosition;
    ArrayList<String> suraContent;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SuraContentRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sura_details);
        recyclerView=findViewById(R.id.recycler_view);
        intentSuraName= getIntent().getStringExtra("suraName");
        intentSuraPosition=getIntent().getIntExtra("position",-1);
        readSuraFromFile((position+1)+".txt");

        layoutManager=new LinearLayoutManager(this);
        adapter=new SuraContentRecyclerAdapter(suraContent);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    void readSuraFromFile(String fileName) {
        BufferedReader reader;

        try{
            suraContent=new ArrayList<>();
            final InputStream file = getAssets().open(fileName);
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();
            while(line != null){
                Log.d("StackOverflow", line);
                line = reader.readLine();
                suraContent.add(line);

            }
        } catch(IOException ioe){
            ioe.printStackTrace();
        }

    }
}
