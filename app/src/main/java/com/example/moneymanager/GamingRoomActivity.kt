package com.example.moneymanager

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class GamingRoomActivity : AppCompatActivity() {
    var activityList = ArrayList<ActivityList>()
    var activityLogos = intArrayOf(R.drawable.ic_shopping_cart, R.drawable.withdrawal_icon,
            R.drawable.gaming_icon)
    var activity_names = arrayOf("Shopping", "Withdrawal", "Gaming")
    var activity_dates = arrayOf("Jan 24, 2022", "Jan 23, 2022", "Jan 21, 2022")
    var activity_balance = arrayOf("-$54", "-$54", "-$54")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gaming_room)
        createActivityList()
        val activityRecycler: RecyclerView = findViewById(R.id.rvActivities)
        val firstSection = GamingRoomAdapter(activityList)
        activityRecycler.adapter = firstSection
        val btnBack: ImageButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@GamingRoomActivity, MainActivity::class.java)
            startActivity(intent)
        })
    }

    private fun createActivityList() {
        var count = 0
        for (names in activity_names) {
            val activityList = ActivityList(activityLogos[count], names,
                    activity_dates[count], activity_balance[count])
            this.activityList.add(activityList)
            count++
        }
    }
}