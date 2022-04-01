package com.example.moneymanager

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.moneymanager.model.Activity

class GamingRoomActivity : AppCompatActivity() {
    private val activities = listOf(
        Activity(R.drawable.ic_shopping_cart, "Shopping", "Jan 24, 2022", "$-54"),
        Activity(R.drawable.withdrawal_icon, "Withdrawal", "Jan 23, 2022", "$-54"),
        Activity(R.drawable.gaming_icon, "Gaming", "Jan 21, 2022", "$-54")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gaming_room)

        val activityRecycler: RecyclerView = findViewById(R.id.rvActivities)

        activityRecycler.adapter =  GamingRoomAdapter(activities)
        val btnBack: ImageButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this@GamingRoomActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
