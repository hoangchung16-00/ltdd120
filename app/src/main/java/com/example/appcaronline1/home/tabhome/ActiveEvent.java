package com.example.appcaronline1.home.tabhome;

import java.util.Date;

public class ActiveEvent {
    private String eventTitle;
    private String eventImage;
    private String content;
    private String date;

    public ActiveEvent(String eventTitle, String eventImage, String content, String date) {
        this.eventTitle = eventTitle;
        this.eventImage = eventImage;
        this.content = content;
        this.date = date;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
