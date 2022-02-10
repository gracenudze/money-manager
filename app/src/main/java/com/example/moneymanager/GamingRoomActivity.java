package com.example.moneymanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GamingRoomActivity extends AppCompatActivity {
    ArrayList<ActivityList> activityList = new ArrayList<>();

    int activity_logos[] = {R.drawable.ic_shopping_cart, R.drawable.withdrawal_icon,
            R.drawable.gaming_icon};
    String activity_names[] = {"Shopping", "Withdrawal", "Gaming"};
    String activity_dates[] = {"Jan 24, 2022", "Jan 23, 2022", "Jan 21, 2022"};
    String activity_balance[] = {"-$54", "-$54", "-$54"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming_room);

        createActivityList();

        RecyclerView activityRecycler = findViewById(R.id.rvActivities);
        activityRecycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,
                false));
        GamingRoomAdapter firstSection = new GamingRoomAdapter(activityList);
        activityRecycler.setAdapter(firstSection);
    }

    public void createActivityList() {
        int count = 0;
        for (String names: activity_names) {
            ActivityList activityList = new ActivityList(activity_logos[count], names,
                    activity_dates[count], activity_balance[count]);
            this.activityList.add(activityList);
            count++;
        }
    }
}
