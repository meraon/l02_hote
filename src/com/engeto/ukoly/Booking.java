package com.engeto.ukoly;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Booking {

    List<Host> hosts;
    Room room;
    LocalDate startDate;
    LocalDate endDate;
    TypeOfStay type;

    public Booking(List<Host> hosts, Room room) {
        this.hosts = hosts;
        this.room = room;
        this.startDate = LocalDate.now();
        this.endDate =  startDate.plusDays(6);
        this.type = TypeOfStay.RECREATION;
    }

    public Booking() { // pre vytvorenie inštancie v ktorej držím históriu rezervácií
    }

    public Booking(List<Host> hosts, Room room, LocalDate startDate, LocalDate endDate, TypeOfStay type) {
        this.hosts = hosts;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
    }

    public TypeOfStay getType() {
        return type;
    }

    public void setType(TypeOfStay type) {
        this.type = type;
    }

    public void BookingInfo(){
        if (!hosts.isEmpty()){
            if (hosts.size() < 2){
                System.out.println("\nHosť:");
            }
            else{
                System.out.println("\nHostia:");
            }
            for (Host host :hosts){
                System.out.println(host);
            }
            if (hosts.size() < 2){
                System.out.println("Má zarezervované: " + room.RoomInfo() + " Od: " + startDate + " Do: "+endDate);
            }
            else{
                System.out.println("Majú zarezervované: " + room.RoomInfo() + " Od: " + startDate + " Do: "+endDate);
            }

        }
        else{
            System.out.println("Nie je vytvorená rezervácia");
        }
    }

    enum TypeOfStay {
        WORK,
        RECREATION, // ciarka na konci a bodkociarka na novom riadku je cool trik aby ti git pri pridani novych hodnot nehlasil zmeny aj na poslednom/starom riadku
        ;
    }

}
