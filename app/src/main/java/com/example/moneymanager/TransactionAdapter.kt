package com.example.moneymanager

import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.moneymanager.model.Transaction

class TransactionAdapter(private val transactions: List<Transaction>) : RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val transactionImage: ImageView = itemView.findViewById(R.id.ivTransactionLogo)
        val transactionName: TextView = itemView.findViewById(R.id.tvNames)
        val transactionDate: TextView = itemView.findViewById(R.id.tvDates)
        val transactionBalance: TextView = itemView.findViewById(R.id.tvBalance)

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
        val transaction = transactions[position]
        holder.transactionImage.setImageResource(transaction.logo)
        if (position == 1) {
            holder.transactionImage.setPadding(5, 5, 5, 5)
        }
        holder.transactionName.text = transaction.name
        holder.transactionDate.text = transaction.date
        holder.transactionBalance.text = transaction.budget
    }

    override fun getItemCount(): Int {
        return transactions.size
    }
}
