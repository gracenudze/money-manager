package com.example.moneymanager;

public class ActivityList {
    private int mActivityIcons;
    private String mActivityNames;
    private String mActivityDates;
    private String mBalance;

    public ActivityList(int activityIcons, String activityNames, String activityDates, String balance) {
        this.mActivityIcons = activityIcons;
        this.mActivityNames = activityNames;
        this.mActivityDates = activityDates;
        this.mBalance = balance;
    }

    public int getActivityIcons() {
        return mActivityIcons;
    }

    public String getActivityNames() {
        return mActivityNames;
    }

    public String getActivityDates() {
        return mActivityDates;
    }

    public String getBalance() {
        return mBalance;
    }
}
