package com.example.appcaronline1.home.tabnoti;

public class Message {
    String mesTitle,mesImage;

    @Override
    public String toString() {
        return "Message{" +
                "mesTitle='" + mesTitle + '\'' +
                ", mesImage='" + mesImage + '\'' +
                '}';
    }

    public Message(String mesTitle, String mesImage) {
        this.mesTitle = mesTitle;
        this.mesImage = mesImage;
    }

    public String getMesTitle() {
        return mesTitle;
    }

    public void setMesTitle(String mesTitle) {
        this.mesTitle = mesTitle;
    }

    public String getMesImage() {
        return mesImage;
    }

    public void setMesImage(String mesImage) {
        this.mesImage = mesImage;
    }
}
