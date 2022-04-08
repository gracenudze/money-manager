package com.example.moneymanager

import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.moneymanager.databinding.RvTransactionItemsBinding
import com.example.moneymanager.model.Transaction

class TransactionAdapter(private val transactions: List<Transaction>) : RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {
    inner class ViewHolder(val binding:RvTransactionItemsBinding) : RecyclerView.ViewHolder(binding.root) {
//        val transactionImage: ImageView = itemView.findViewById(R.id.ivTransactionLogo)
//        val transactionName: TextView = itemView.findViewById(R.id.tvNames)
//        val transactionDate: TextView = itemView.findViewById(R.id.tvDates)
//        val transactionBalance: TextView = itemView.findViewById(R.id.tvBalance)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        // Inflate the custom layout
        val binding = RvTransactionItemsBinding.inflate(LayoutInflater.from(context),
        parent, false)
        // Return a new holder instance
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(transactions[position]) {
                binding.ivTransactionLogo.setImageResource(logo)
                if (position == 1) {
                    binding.ivTransactionLogo.setPadding(5,5,5,5)
                }
                binding.tvNames.text = this.name
                binding.tvDates.text = this.date
                binding.tvBalance.text = this.budget
            }
        }
    }

    override fun getItemCount(): Int {
        return transactions.size
    }
}

