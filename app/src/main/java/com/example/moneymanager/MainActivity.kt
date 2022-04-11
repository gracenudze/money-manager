package com.example.moneymanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import android.widget.Toast
import com.example.moneymanager.databinding.ActivityMainBinding
import com.example.moneymanager.databinding.BottomSheetDialogBinding
import com.example.moneymanager.model.Transaction

private lateinit var activityMainBinding: ActivityMainBinding
private lateinit var dialogBinding: BottomSheetDialogBinding

class MainActivity : AppCompatActivity() {
    private val transactions = listOf(
        Transaction("Groceries", R.drawable.bag, "Jan 24, 2022", "$-54"),
        Transaction("Monthly iCloud", R.drawable.ic_cloud_queue, "Jan 22, 2022", "$-29")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(activityMainBinding.root)

        //initializing bottom sheet dialog
        activityMainBinding.btnAdd.setOnClickListener { showBottomSheetDialog() }


        //Opening the gaming activity

        activityMainBinding.flGame.setOnClickListener {
            val intent = Intent(this@MainActivity, GamingRoomActivity::class.java)
            startActivity(intent)
        }

        // set the id for the progressbar and progress text
        activityMainBinding.rvTransaction.layoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL,
            false
        )

        activityMainBinding.rvTransaction.adapter =  TransactionAdapter(transactions)
    }

    private fun showBottomSheetDialog() {
        val bottomSheetDialog = BottomSheetDialog(this)

        val inflater = LayoutInflater.from(this)
        dialogBinding = BottomSheetDialogBinding.inflate(inflater)

        bottomSheetDialog.setContentView(dialogBinding.root)
        bottomSheetDialog.setCanceledOnTouchOutside(false)

        dialogBinding.btnCreate.setOnClickListener {
            Toast.makeText(
                applicationContext, "Create Button is Clicked ",
                Toast.LENGTH_LONG
            ).show()
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.show()
    }
}

