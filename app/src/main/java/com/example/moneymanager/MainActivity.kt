package com.example.moneymanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.FrameLayout
import android.content.Intent
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import android.widget.Toast
import com.example.moneymanager.model.Transaction

class MainActivity : AppCompatActivity() {
    private val transactions = listOf(
        Transaction("Groceries", R.drawable.bag, "Jan 24, 2022", "$-54"),
        Transaction("Monthly iCloud", R.drawable.ic_cloud_queue, "Jan 22, 2022", "$-29")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initializing bottom sheet dialog
        val imageButton = findViewById<ImageButton>(R.id.btnAdd)
        imageButton.setOnClickListener { showBottomSheetDialog() }

        //Opening the gaming activity
        val flGameLayout = findViewById<FrameLayout>(R.id.flGame)
        flGameLayout.setOnClickListener {
            val intent = Intent(this@MainActivity, GamingRoomActivity::class.java)
            startActivity(intent)
        }

        // set the id for the progressbar and progress text
        val transactionRecycler = findViewById<RecyclerView>(R.id.rvTransaction)
        transactionRecycler.layoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL,
            false
        )
        val firstSection = TransactionAdapter(transactions)
        transactionRecycler.adapter = firstSection
    }

    private fun showBottomSheetDialog() {
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog)
        bottomSheetDialog.setCanceledOnTouchOutside(false)
        val btnCreate = bottomSheetDialog.findViewById<Button>(R.id.btnCreate)
        btnCreate!!.setOnClickListener {
            Toast.makeText(
                applicationContext, "Create Button is Clicked ",
                Toast.LENGTH_LONG
            ).show()
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.show()
    }
}

