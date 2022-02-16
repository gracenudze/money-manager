package com.example.moneymanager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.*;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moneymanager.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<TransactionList> transactionList = new ArrayList<>();

    int transaction_logos[] = {R.drawable.bag, R.drawable.ic_cloud_queue};
    String  transaction_names[] = {"Groceries", "Monthly iCloud"};
    String transaction_dates[] = {"Jan 24, 2022", "Jan 22, 2022"};
    String budget[] = {"-$54", "-$29"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing bottom sheet dialog

        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog();
            }
        });

        //Opening the gaming activity
        FrameLayout flGameLayout = findViewById(R.id.flGame);
        flGameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, GamingRoomActivity.class);
               startActivity(intent);
            }
        });

        // set the id for the progressbar and progress text

        createTransactionList();

        RecyclerView transactionRecycler = findViewById(R.id.rvTransaction);
        transactionRecycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,
                false));
        TransactionAdapter firstSection = new TransactionAdapter(transactionList);
        transactionRecycler.setAdapter(firstSection);
    }

    public void createTransactionList() {
        int count = 0;
        for (String names: transaction_names) {
            TransactionList transactionList = new TransactionList(transaction_logos[count], names,
                  transaction_dates[count], budget[count]);
            this.transactionList.add(transactionList);
            count++;
        }
    }

    private void showBottomSheetDialog() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog);
        bottomSheetDialog.setCanceledOnTouchOutside(false);


        Button btnCreate =bottomSheetDialog.findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Create Button is Clicked ",
                        Toast.LENGTH_LONG).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.show();
    }
}
