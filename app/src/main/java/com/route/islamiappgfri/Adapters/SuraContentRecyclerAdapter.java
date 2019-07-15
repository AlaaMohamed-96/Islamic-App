package com.route.islamiappgfri.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.route.islamiappgfri.R;

import java.util.ArrayList;


public class SuraContentRecyclerAdapter extends RecyclerView.Adapter<SuraContentRecyclerAdapter.ViewHolder> {


    ArrayList<String>verses;

    public SuraContentRecyclerAdapter(ArrayList<String> verses) {
        this.verses = verses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
      View view=  LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_view_verse,viewGroup,false);
      return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        final String aya = verses.get(position);
        viewHolder.name.setText(aya  +"{"+(position+1)+"}");

        if(onItemClickListener!=null){
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(position,aya);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return verses.size();
    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int pos, String suraName);
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
        }
    }
}
