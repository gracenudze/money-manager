package com.example.moneymanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GamingRoomAdapter extends RecyclerView.Adapter<GamingRoomAdapter.ViewHolder> {
    private ArrayList<ActivityList> mActivityList;

    public GamingRoomAdapter(ArrayList<ActivityList> activityList) {
        this.mActivityList = activityList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView activityImages;
        public TextView activityNames, activityDates, balance;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            activityImages = itemView.findViewById(R.id.ivActivityLogos);
            activityNames = itemView.findViewById(R.id.tvActivityNames);
            activityDates = itemView.findViewById(R.id.tvActivityDates);
            balance = itemView.findViewById(R.id.tvActivity_balance);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View gamingView = inflater.inflate(R.layout.rv_gaming_items,
                parent, false);

        // Return a new holder instance
        GamingRoomAdapter.ViewHolder viewHolder = new ViewHolder(gamingView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ActivityList activityList = mActivityList.get(position);

        holder.activityImages.setImageResource(activityList.getActivityIcons());
        if (position == 0) {
            holder.activityImages.setPadding(5,5,5,5);
        }
        holder.activityNames.setText(activityList.getActivityNames());
        holder.activityDates.setText(activityList.getActivityDates());
        holder.balance.setText(activityList.getBalance());

    }

    @Override
    public int getItemCount() {
        return mActivityList.size();
    }
}
