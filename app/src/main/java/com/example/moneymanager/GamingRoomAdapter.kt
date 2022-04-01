package com.example.moneymanager

import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.moneymanager.model.Activity

class GamingRoomAdapter(private val activities: List<Activity>) : RecyclerView.Adapter<GamingRoomAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val activityImage: ImageView = itemView.findViewById(R.id.ivActivityLogos)
        val activityName: TextView = itemView.findViewById(R.id.tvActivityNames)
        val activityDate: TextView = itemView.findViewById(R.id.tvActivityDates)
        val balance: TextView = itemView.findViewById(R.id.tvActivity_balance)

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
        val activity = activities[position]
        holder.activityImage.setImageResource(activity.icon)
        if (position == 0) {
            holder.activityImage.setPadding(5, 5, 5, 5)
        }
        holder.activityName.text = activity.name
        holder.activityDate.text = activity.date
        holder.balance.text = activity.balance
    }

    override fun getItemCount(): Int {
        return activities.size
    }
}
