package com.example.myapplication.login.model;



public class PlacesDetails_Modal {

    public String address,phone_no,distance,name,photourl;
    public float rating;



    public PlacesDetails_Modal(String address, String phone_no, float rating, String distance, String name, String photurl)
    {
        this.address = address;
        this.phone_no = phone_no;
        this.rating = rating;
        this.distance = distance;
        this.name = name;
        this.photourl = photurl;
    }

}
