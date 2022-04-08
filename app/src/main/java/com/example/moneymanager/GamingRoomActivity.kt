package com.example.moneymanager

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.moneymanager.databinding.ActivityGamingRoomBinding
import com.example.moneymanager.model.Activity

private lateinit var binding:ActivityGamingRoomBinding

class GamingRoomActivity : AppCompatActivity() {
    private val activities = listOf(
        Activity(R.drawable.ic_shopping_cart, "Shopping", "Jan 24, 2022", "$-54"),
        Activity(R.drawable.withdrawal_icon, "Withdrawal", "Jan 23, 2022", "$-54"),
        Activity(R.drawable.gaming_icon, "Gaming", "Jan 21, 2022", "$-54")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGamingRoomBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        val activityRecycler: RecyclerView = findViewById(R.id.rvActivities)

        activityRecycler.adapter =  GamingRoomAdapter(activities)

        binding.btnBack.setOnClickListener {
            val intent = Intent(this@GamingRoomActivity, MainActivity::class.java)
            startActivity(intent) }
        }
}


