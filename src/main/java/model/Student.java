package model;


import java.util.Date;

public class Student {
    public  int  id;
    public String name;
    public Date birth;
    public String Address;
    public String Phonenumber;
    public String Email;
    public int ClassID;

    public Student() {
    }

    public Student(int id, String name, Date birth, String address, String phonenumber, String email, int classID) {
        this.id = id;
        this.name = name;
        birth = birth;
        Address = address;
        Phonenumber = phonenumber;
        Email = email;
        ClassID = classID;
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

    public Date getbirth() {
        return birth;
    }

    public void setDateofbirth(Date dateofbirth) {
        birth = birth;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getClassID() {
        return ClassID;
    }

    public void setClassID(int classID) {
        ClassID = classID;
    }

    public Student(String name, Date birth, String address, String phonenumber, String email, int classID) {
        this.name = name;
        birth = birth;
        Address = address;
        Phonenumber = phonenumber;
        Email = email;
        ClassID = classID;
    }
}
