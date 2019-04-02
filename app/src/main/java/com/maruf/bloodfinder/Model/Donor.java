package com.maruf.bloodfinder.Model;

import java.util.ArrayList;
import java.util.List;

public class Donor {

    private int id;
    private String name;
    private String bloodGroup;
    private String gender;
    private String phone;
    private String email;
    private String address;
    private String status;
    private String password;

    public Donor(int id, String name, String bloodGroup, String gender, String phone,
                 String email, String address, String status, String password) {
        this.id = id;
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.status = status;
        this.password = password;
    }

    public Donor(String name, String bloodGroup, String gender, String phone,
                 String email, String address, String status, String password) {

        this.name = name;
        this.bloodGroup = bloodGroup;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.status = status;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static List<Donor> generateMovieList(){
        List<Donor> movieList = new ArrayList<>();

        movieList.add(new Donor(10,"Kamal Hasan","O+","Male",
                "123456","kamal@gmail.com","Dhaka, Tejgaon","Available","Action"));



        return movieList;

    }
}
