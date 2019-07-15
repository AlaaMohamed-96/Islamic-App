package com.route.islamiappgfri.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.route.islamiappgfri.Model.Hadeth;
import com.route.islamiappgfri.R;

import java.util.List;

public class HadethAdapter extends RecyclerView.Adapter<HadethAdapter.ViewHolder> {


    List<Hadeth> ahadeth;

    public HadethAdapter(List<Hadeth> ahadeth) {
        this.ahadeth = ahadeth;
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

        final Hadeth hadeth=ahadeth.get(position);
        viewHolder.name.setText(hadeth.getTitle());

        if(onItemClickListener!=null){
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(position,hadeth);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return ahadeth.size();
    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int pos, Hadeth hadeth);
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
        }
    }
}
