package com.example.sadia.firebasetutorials;

/**
 * Created by sadia on 10/7/17.
 */
public class posts {
    String name;

    String Genre;
    String Catagory;
    String Phone;
    String date;

    public posts() {

    }


    public posts(String Name, String Genre, String Catagory, String Phone,String date) {
        this.name = Name;
        this.Genre = Genre;
        this.Catagory = Catagory;
        this.Phone = Phone;
        this.date = date;
    }

    public String getName() {
        return name;
    }


    public String getGenre() {
        return Genre;
    }

    public String getCatagory() {
        return Catagory;
    }

    public String getPhone() {
        return Phone;
    }

    public String getDate() {
        return date;
    }
}