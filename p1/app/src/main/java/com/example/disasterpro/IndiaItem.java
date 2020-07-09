package com.example.disasterpro;


public class IndiaItem {
    private String Location, Date, Time;
    int imageId;

    public IndiaItem(String location, String date, int imageId) {
        Location = location;
        Date = date;

        this.imageId = imageId;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }



    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}