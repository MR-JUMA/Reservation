package com.example.flightReservation.controller;

public class Insert {

    public static void main(String[] args) {

        String from[] = {"Dar", "Mwanza", "Arusha"};
        String to[] = {"Arusha", "Kagera", "Dodoma"};
        String date[] = {"2020-01-20", "2020-01-21"};
        String time[] = {"00:00", "06:00", "10:00"};

//        for(int a = 0; a < from.length; a++){
//
//            System.out.printf("from: %s, to: %s, date: %s, time: %s", from[a], to[a], date[0], time[a]);
//            System.out.println();
//        }

        for(int a = 0; a < date.length; a++){

            String d = date[a];

            for(int b = 0; b < from.length; b++){

                System.out.printf("from: %s, to: %s, date: %s, time: %s", from[b], to[b], d, time[b]);
                System.out.println();
            }
        }
    }
}
