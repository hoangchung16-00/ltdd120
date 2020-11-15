package com.example.appcaronline1.home.tabacitivity.taballactivity;

public class Activity {
    String activityTitle,activityContext;

    public Activity(String activityTitle, String activityContext) {
        this.activityTitle = activityTitle;
        this.activityContext = activityContext;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public String getActivityContext() {
        return activityContext;
    }

    public void setActivityContext(String activityContext) {
        this.activityContext = activityContext;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityTitle='" + activityTitle + '\'' +
                ", activityContext='" + activityContext + '\'' +
                '}';
    }
}
