package org.example;


public class Customer {
    private int ID;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;

    public Customer(int ID, String first_name, String last_name, String email, String phone) {
        this.ID = ID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }


    public String getFirst_name() {
        return first_name;
    }

    public void setName(String name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhoneNumber(String phone) {
        this.phone = phone;


    }

}


