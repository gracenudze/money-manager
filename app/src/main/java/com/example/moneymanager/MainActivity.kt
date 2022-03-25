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
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var transactionList = ArrayList<TransactionRecycler>()
    var transactionLogos = intArrayOf(R.drawable.bag, R.drawable.ic_cloud_queue)
    var transactionNames = arrayOf("Groceries", "Monthly iCloud")
    var transactionDates = arrayOf("Jan 24, 2022", "Jan 22, 2022")
    var budget = arrayOf("-$54", "-$29")
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
        createTransactionList()
        val transactionRecycler = findViewById<RecyclerView>(R.id.rvTransaction)
        transactionRecycler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,
                false)
        val firstSection = TransactionAdapter(transactionList)
        transactionRecycler.adapter = firstSection
    }

    private fun createTransactionList() {
        for ((index, names) in transactionNames.withIndex()) {
            val transactionList = TransactionRecycler(transactionLogos[index], names,
                    transactionDates[index], budget[index])
            this.transactionList.add(transactionList)
        }
    }

    private fun showBottomSheetDialog() {
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog)
        bottomSheetDialog.setCanceledOnTouchOutside(false)
        val btnCreate = bottomSheetDialog.findViewById<Button>(R.id.btnCreate)
        btnCreate!!.setOnClickListener {
            Toast.makeText(applicationContext, "Create Button is Clicked ",
                    Toast.LENGTH_LONG).show()
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.show()
    }
}
