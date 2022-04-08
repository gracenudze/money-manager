package com.example.moneymanager

import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.moneymanager.databinding.ActivityGamingRoomBinding
import com.example.moneymanager.databinding.RvGamingItemsBinding
import com.example.moneymanager.model.Activity

class GamingRoomAdapter(private val activities: List<Activity>) : RecyclerView.Adapter<GamingRoomAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: RvGamingItemsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context

        // Inflate the custom layout
        val binding = RvGamingItemsBinding.inflate(
            LayoutInflater.from(context),
                parent, false)

        // Return a new holder instance
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(activities[position]) {
                binding.ivActivityLogos.setImageResource(icon)
                if (position == 0) {
                binding.ivActivityLogos.setPadding(5, 5, 5, 5)
                }
                binding.tvActivityNames.text = this.name

                binding.tvActivityDates.text = this.date

                binding.tvActivityBalance.text = this.balance
            }
        }
    }

    override fun getItemCount(): Int {
        return activities.size
    }
}

