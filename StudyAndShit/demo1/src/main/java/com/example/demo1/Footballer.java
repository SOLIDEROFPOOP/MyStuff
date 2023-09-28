package com.example.demo1;

public class Footballer {
    int id;
    String name;
    int salary;
    String club;
    int transferPrice;


    public Footballer(int id, String name, int salary, String club, int transferPrice) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.club = club;
        this.transferPrice = transferPrice;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public int getTransferPrice() {
        return transferPrice;
    }

    public void setTransferPrice(int transferPrice) {
        this.transferPrice = transferPrice;
    }
}

