package com.route.islamiappgfri.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.route.islamiappgfri.R;


public class SurasRecyclerAdapter  extends RecyclerView.Adapter<SurasRecyclerAdapter.ViewHolder> {

    String [] surasNames;

    public SurasRecyclerAdapter(String[] surasNames) {
        this.surasNames = surasNames;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
      View view=  LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_view_sura,viewGroup,false);
      return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        final String suraName =surasNames[position];
        viewHolder.name.setText(suraName);

        if(onItemClickListener!=null){
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(position,suraName);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return surasNames.length;
    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int pos,String suraName);
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
        }
    }
}
