package com.route.islamiappgfri.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.route.islamiappgfri.API.Model.RadiosItem;
import com.route.islamiappgfri.R;

import java.util.List;


public class RadioChannelsRecyclerAdapter extends RecyclerView.Adapter<RadioChannelsRecyclerAdapter.ViewHolder> {

    List<RadiosItem> channels;

    public RadioChannelsRecyclerAdapter(List<RadiosItem> channels) {
        this.channels = channels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
      View view=  LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_view_channel,viewGroup,false);
      return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        final RadiosItem channel= channels.get(position);
        viewHolder.name.setText(channel.getName());

        if(onPlayClickListener!=null){
            viewHolder.play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onPlayClickListener.onItemClick(position,channel);
                }
            });
        }
        if(onStopClickListener!=null){
            viewHolder.stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onStopClickListener.onItemClick(position,channel);
                }
            });
        }
    }

   public void changeData(List<RadiosItem> channels){
        this.channels=channels;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if(channels==null)return 0;
        return channels.size();
    }

    OnItemClickListener onPlayClickListener;
    OnItemClickListener onStopClickListener;

    public void setOnPlayClickListener(OnItemClickListener onPlayClickListener) {
        this.onPlayClickListener = onPlayClickListener;
    }

    public void setOnStopClickListener(OnItemClickListener onStopClickListener) {
        this.onStopClickListener = onStopClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int pos, RadiosItem radiosItem);
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView play,stop;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            play=itemView.findViewById(R.id.play);
            stop=itemView.findViewById(R.id.stop);
        }
    }
}
