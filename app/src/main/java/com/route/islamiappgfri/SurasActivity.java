package com.route.islamiappgfri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.route.islamiappgfri.Adapters.SurasRecyclerAdapter;

public class SurasActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SurasRecyclerAdapter adapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suras);
        recyclerView=findViewById(R.id.recycler_view);

        adapter=new SurasRecyclerAdapter(Constants.ArSuras);
        adapter.setOnItemClickListener(new SurasRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, String suraName) {
               Intent i= new Intent(SurasActivity.this,SuraDetailsActivity.class);
               SuraDetailsActivity.position=pos;
               SuraDetailsActivity.suraName=suraName;
               i.putExtra("position",pos);
               i.putExtra("suraName",suraName);
                startActivity(i);
            }
        });
        layoutManager=new GridLayoutManager(this,3,LinearLayoutManager.HORIZONTAL,
                false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }
}
