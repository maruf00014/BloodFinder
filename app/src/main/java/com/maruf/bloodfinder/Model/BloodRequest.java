package com.maruf.bloodfinder.Model;

public class BloodRequest {

    private int id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String donorID;

    public BloodRequest(int id, String name, String phone, String email, String address, String donorID) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.donorID = donorID;
    }

    public BloodRequest(String name, String phone, String email, String address, String donorID) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.donorID = donorID;
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

    public String getDonorID() {
        return donorID;
    }

    public void setDonorID(String donorID) {
        this.donorID = donorID;
    }
}
