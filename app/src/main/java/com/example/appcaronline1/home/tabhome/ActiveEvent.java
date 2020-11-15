package com.example.appcaronline1.home.tabhome;

public class ActiveEvent {
    private String eventTitle;
    private String eventImage;

    public ActiveEvent(String eventTitle, String eventImage) {
        this.eventTitle = eventTitle;
        this.eventImage = eventImage;
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
}
