package com.example.sadia.firebasetutorials;

/**
 * Created by sadia on 10/7/17.
 */
public class posts {
    String name;

    String genre;
    String catagory;
    String phone;
    String date;

    public posts() {

    }


    public posts(String Name, String genre, String catagory, String phone,String date) {
        this.name = Name;
        this.genre = genre;
        this.catagory = catagory;
        this.phone = phone;
        this.date = date;
    }

    public String getName() {
        return name;
    }


    public String getgenre() {
        return genre;
    }

    public String getcatagory() {
        return catagory;
    }

    public String getphone() {
        return phone;
    }

    public String getDate() {
        return date;
    }
}
