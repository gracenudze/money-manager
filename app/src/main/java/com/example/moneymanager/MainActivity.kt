package com.example.moneymanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.FrameLayout
import android.content.Intent
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import android.widget.Toast
import com.example.moneymanager.databinding.ActivityMainBinding
import com.example.moneymanager.databinding.BottomSheetDialogBinding
import com.example.moneymanager.model.Transaction

private lateinit var binding: ActivityMainBinding
private lateinit var bind: BottomSheetDialogBinding

class MainActivity : AppCompatActivity() {
    private val transactions = listOf(
        Transaction("Groceries", R.drawable.bag, "Jan 24, 2022", "$-54"),
        Transaction("Monthly iCloud", R.drawable.ic_cloud_queue, "Jan 22, 2022", "$-29")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        //initializing bottom sheet dialog
        binding.btnAdd.setOnClickListener { showBottomSheetDialog()  }


        //Opening the gaming activity

        binding.flGame.setOnClickListener {
            val intent = Intent(this@MainActivity, GamingRoomActivity::class.java)
            startActivity(intent)
        }

        // set the id for the progressbar and progress text
        val transactionRecycler = findViewById<RecyclerView>(R.id.rvTransaction)
        transactionRecycler.layoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL,
            false
        )

        transactionRecycler.adapter =  TransactionAdapter(transactions)
    }

    private fun showBottomSheetDialog() {
        val bottomSheetDialog = BottomSheetDialog(this)
        bind = BottomSheetDialogBinding.inflate(layoutInflater)
        val view:View = bind.root

        bottomSheetDialog.setCanceledOnTouchOutside(false)

        bind.btnCreate.setOnClickListener {
            Toast.makeText(
                applicationContext, "Create Button is Clicked ",
                Toast.LENGTH_LONG
            ).show()
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.show()
    }
}

