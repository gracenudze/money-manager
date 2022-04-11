package com.example.moneymanager

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import com.example.moneymanager.databinding.RvGamingItemsBinding
import com.example.moneymanager.model.Activity

class GamingRoomAdapter(private val activities: List<Activity>) : RecyclerView.Adapter<GamingRoomAdapter.ViewHolder>() {
    inner class ViewHolder(val gamingItemsBinding: RvGamingItemsBinding) : RecyclerView.ViewHolder(gamingItemsBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the custom layout
        val binding = RvGamingItemsBinding.inflate(
            LayoutInflater.from(parent.context),
                parent, false)

        // Return a new holder instance
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(activities[position]) {
                gamingItemsBinding.ivActivityLogos.setImageResource(icon)
                if (position == 0) {
                    gamingItemsBinding.ivActivityLogos.setPadding(5, 5, 5, 5)
                }
                gamingItemsBinding.tvActivityNames.text = this.name

                gamingItemsBinding.tvActivityDates.text = this.date

                gamingItemsBinding.tvActivityBalance.text = this.balance
            }
        }
    }

    override fun getItemCount(): Int {
        return activities.size
    }
}

