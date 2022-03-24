package com.example.moneymanager

import com.example.moneymanager.TransactionList
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import com.example.moneymanager.R
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import java.util.ArrayList

class TransactionAdapter(private val mTransactionList: ArrayList<TransactionList>) : RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var transactionImages: ImageView = itemView.findViewById(R.id.ivTransactionLogo)
        var transactionNames: TextView = itemView.findViewById(R.id.tvNames)
        var transactionDates: TextView = itemView.findViewById(R.id.tvDates)
        var transactionBalance: TextView = itemView.findViewById(R.id.tvBalance)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        // Inflate the custom layout
        val transactionView = inflater.inflate(R.layout.rv_transaction_items,
                parent, false)

        // Return a new holder instance
        return ViewHolder(transactionView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transactionList = mTransactionList[position]
        holder.transactionImages.setImageResource(transactionList.transactionLogos)
        if (position == 1) {
            holder.transactionImages.setPadding(5, 5, 5, 5)
        }
        holder.transactionNames.text = transactionList.transactionNames
        holder.transactionDates.text = transactionList.transactionDate
        holder.transactionBalance.text = transactionList.budget
    }

    override fun getItemCount(): Int {
        return mTransactionList.size
    }
}