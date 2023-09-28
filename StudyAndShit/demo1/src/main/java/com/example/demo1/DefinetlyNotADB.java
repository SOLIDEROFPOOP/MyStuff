package com.example.demo1;

import java.util.ArrayList;

public class DefinetlyNotADB {
    private static ArrayList<Footballer> footballers = new ArrayList<>();
    static int id = 4;
    static {
        footballers.add(new Footballer(1, "Player1", 1000, "Club1", 1500));
        footballers.add(new Footballer(2, "Player2", 1200, "Club2", 1800));
        footballers.add(new Footballer(3, "Player3", 900, "Club3", 1300));
        footballers.add(new Footballer(4, "Player4", 800, "Club4", 1100));
    }

    public static void addFootballer(Footballer footballer){
        footballers.add(footballer);
    }
    public static ArrayList<Footballer> getFootballers(){
        return footballers;
    }

}
