package com.engeto.ukoly;

import java.math.BigDecimal;

public class Room {
    public Room(int roomNumber, int bedsNumber, boolean balcony, boolean seaView, BigDecimal price) {
        this.roomNumber = roomNumber;
        this.bedsNumber = bedsNumber;
        this.balcony = balcony;
        this.seaView = seaView;
        this.price = price;
    }

    int roomNumber;
    int bedsNumber;
    boolean balcony;
    boolean seaView;
    BigDecimal price;

    public String RoomInfo(){
        String balconyInfo;
        String seaViewInfo;
        if(balcony){
            balconyInfo=" s balkónom";
        }
        else{
            balconyInfo = " bez balkónu";
        }
        if(seaView == true){
            seaViewInfo = " s výhladom na more";
        }
        else{
            seaViewInfo = "" ;// prišlo mi to lepšie nepísať tam nič ako vypisovať že bez výhladu na more
        }
        return ("Izba s číslom " + roomNumber+ " s počtom postelí "+ bedsNumber +balconyInfo + seaViewInfo + ". Cena: "+price+" Kč/noc.");
    }
}
