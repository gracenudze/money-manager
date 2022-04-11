package com.example.moneymanager

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import com.example.moneymanager.databinding.RvTransactionItemsBinding
import com.example.moneymanager.model.Transaction

class TransactionAdapter(private val transactions: List<Transaction>) : RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {
    inner class ViewHolder(val transactionItemsBinding:RvTransactionItemsBinding) : RecyclerView.ViewHolder(transactionItemsBinding.root) {
//        val transactionImage: ImageView = itemView.findViewById(R.id.ivTransactionLogo)
//        val transactionName: TextView = itemView.findViewById(R.id.tvNames)
//        val transactionDate: TextView = itemView.findViewById(R.id.tvDates)
//        val transactionBalance: TextView = itemView.findViewById(R.id.tvBalance)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the custom layout
        val binding = RvTransactionItemsBinding.inflate(LayoutInflater.from(parent.context),
        parent, false)
        // Return a new holder instance
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(transactions[position]) {
                transactionItemsBinding.ivTransactionLogo.setImageResource(logo)
                if (position == 1) {
                    transactionItemsBinding.ivTransactionLogo.setPadding(5,5,5,5)
                }
                transactionItemsBinding.tvNames.text = this.name
                transactionItemsBinding.tvDates.text = this.date
                transactionItemsBinding.tvBalance.text = this.budget
            }
        }
    }

    override fun getItemCount(): Int {
        return transactions.size
    }
}

