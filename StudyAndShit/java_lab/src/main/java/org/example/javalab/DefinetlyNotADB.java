package org.example.javalab;

import java.util.ArrayList;

public class DefinetlyNotADB {
    ArrayList<Footballer> footballers = new ArrayList<>();

    public DefinetlyNotADB(ArrayList<Footballer> footballers) {
        this.footballers = footballers;
    }
    void addFootballer(Footballer footballer){
        footballers.add(footballer);
    }
    ArrayList<Footballer> getFootballers(){
        return footballers;
    }

}
