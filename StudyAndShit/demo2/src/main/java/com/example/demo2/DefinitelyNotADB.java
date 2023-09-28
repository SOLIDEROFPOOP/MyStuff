    package com.example.demo2;

    import java.util.ArrayList;

    public class DefinitelyNotADB {
        private static ArrayList<Footballer> footballers = new ArrayList<>();
        static {
            footballers.add(new Footballer(1, "Player1", 1000, "Club1", 1500));
            footballers.add(new Footballer(2, "Player2", 1200, "Club2", 1800));
            footballers.add(new Footballer(3, "Player3", 900, "Club3", 1300));
            footballers.add(new Footballer(4, "Player4", 800, "Club4", 1100));
        }
        static int id = 4;
        public static void addFootballer(Footballer footballer){
            footballers.add(footballer);
        }
        public static ArrayList<Footballer> getFootballers(){
            return footballers;
        }

        public void setFootballers(ArrayList<Footballer> footballers) {
            this.footballers = footballers;
        }
    }

