package com.example.moneymanager;

public class TransactionList {
    private int mTransactionLogos;
    private String mTransactionNames;
    private String mTransactionDate;
    private String mBudget;

    public TransactionList(int transactionLogos, String transactionNames, String transactionDate, String budget) {
        this.mTransactionLogos = transactionLogos;
        this.mTransactionNames = transactionNames;
        this.mTransactionDate = transactionDate;
        this.mBudget = budget;
    }

    public int getTransactionLogos() {
        return mTransactionLogos;
    }

    public String getTransactionNames() {
        return mTransactionNames;
    }

    public String getTransactionDate() {
        return mTransactionDate;
    }

    public String getBudget() {
        return mBudget;
    }
}
