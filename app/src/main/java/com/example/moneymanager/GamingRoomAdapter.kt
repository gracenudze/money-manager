package com.example.moneymanager

import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import java.util.ArrayList

class GamingRoomAdapter(private val mActivityRecycler: ArrayList<ActivityRecycler>) : RecyclerView.Adapter<GamingRoomAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var activityImages: ImageView = itemView.findViewById(R.id.ivActivityLogos)
        var activityNames: TextView = itemView.findViewById(R.id.tvActivityNames)
        var activityDates: TextView = itemView.findViewById(R.id.tvActivityDates)
        var balance: TextView = itemView.findViewById(R.id.tvActivity_balance)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        // Inflate the custom layout
        val gamingView = inflater.inflate(R.layout.rv_gaming_items,
                parent, false)

        // Return a new holder instance
        return ViewHolder(gamingView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val activityList = mActivityRecycler[position]
        holder.activityImages.setImageResource(activityList.activityIcons)
        if (position == 0) {
            holder.activityImages.setPadding(5, 5, 5, 5)
        }
        holder.activityNames.text = activityList.activityNames
        holder.activityDates.text = activityList.activityDates
        holder.balance.text = activityList.balance
    }

    override fun getItemCount(): Int {
        return mActivityRecycler.size
    }
}
