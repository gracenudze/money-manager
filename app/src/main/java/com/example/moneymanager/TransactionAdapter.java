package com.example.moneymanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {
    private ArrayList <TransactionList> mTransactionList;

    public TransactionAdapter(ArrayList<TransactionList> transactionList) {
        this.mTransactionList = transactionList;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView transactionImages;
        public TextView transactionNames, transactionDates, transactionBalance;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            transactionImages = itemView.findViewById(R.id.ivTransactionLogo);
            transactionNames = itemView.findViewById(R.id.tvNames);
            transactionDates = itemView.findViewById(R.id.tvDates);
            transactionBalance = itemView.findViewById(R.id.tvBalance);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View transactionView = inflater.inflate(R.layout.rv_transaction_items,
                parent, false);

        // Return a new holder instance
        TransactionAdapter.ViewHolder viewHolder = new ViewHolder(transactionView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TransactionList transactionList = mTransactionList.get(position);
        holder.transactionImages.setImageResource(transactionList.getTransactionLogos());
        if (position == 1) {
            holder.transactionImages.setPadding(5,5,5,5);
        }
        holder.transactionNames.setText(transactionList.getTransactionNames());
        holder.transactionDates.setText(transactionList.getTransactionDate());
        holder.transactionBalance.setText(transactionList.getBudget());

    }

    @Override
    public int getItemCount() {
        return mTransactionList.size();
    }
}
