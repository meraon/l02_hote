package com.engeto.ukoly;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Booking {


//    public Booking(List<Host> hosts, Room room, LocalDate startDate, LocalDate endDate, TypeOfStay type) {
//        if(startDate.isBefore(endDate)){
//            this.hosts = hosts;
//            this.room = room;
//            if(startDate.isBefore(LocalDate.now())){
//                System.out.println("Váš požadovaný dátum rezervácie " + startDate + " je v minulosti, preto Vaša rezervácia bude posunutá k aktuálnemu dňu " + LocalDate.now());
//
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //toto nie je najlepšie riešenie :/
//                LocalDate date1 = LocalDate.parse(startDate.toString(), formatter);
//                LocalDate date2 = LocalDate.parse(endDate.toString(), formatter);
//                long elapsedDays = ChronoUnit.DAYS.between(date1, date2);
//                System.out.println(elapsedDays);
//                this.startDate = LocalDate.now();
//                this.endDate = LocalDate.now().plusDays(elapsedDays);
//            }
//            else{
//                this.startDate = startDate;
//                this.endDate = endDate;
//            }
//            this.type = type;
//        }
//        else{
//            System.out.println("Rezervácia nebude vytvorená, nemôže byť dátum pobytu Do menší ako dátum pobytu Od!");
//        }
//    }

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

    List<Host> hosts;
    Room room;
    LocalDate startDate;
    LocalDate endDate;
    TypeOfStay type;

    public TypeOfStay getType() {
        return type;
    }

    public void setType(TypeOfStay type) {
        this.type = type;
    }

    enum TypeOfStay {
        WORK,
        RECREATION, // ciarka na konci a bodkociarka na novom riadku je cool trik aby ti git pri pridani novych hodnot nehlasil zmeny aj na poslednom/starom riadku
        ;
    }

    ArrayList<Booking> bookings = new ArrayList<Booking>() {
    };

    public void addBooking(Booking newBooking) {
        if(newBooking.startDate.isBefore(newBooking.endDate)){
            if(newBooking.startDate.isBefore(LocalDate.now())){

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //toto nie je najlepšie riešenie :/
                LocalDate date1 = LocalDate.parse(newBooking.startDate.toString(), formatter);
                LocalDate date2 = LocalDate.parse(newBooking.endDate.toString(), formatter);
                long elapsedDays = ChronoUnit.DAYS.between(date1, date2);
               // System.out.println(elapsedDays);
                System.out.println("Váš požadovaný dátum rezervácie od: " + newBooking.startDate + " do: "+newBooking.endDate + " na "+elapsedDays + " dní " + " je v minulosti, preto Vaša rezervácia bude posunutá k aktuálnemu dňu od: " + LocalDate.now() + " do: " + LocalDate.now().plusDays(elapsedDays));
                newBooking.startDate = LocalDate.now();
                newBooking.endDate = LocalDate.now().plusDays(elapsedDays);

            }
            bookings.add(newBooking);
            System.out.println("Rezervácie bola úspešne spracovaná.");
        }
        else{
            System.out.println("Vaša rezervácia na meno "+ newBooking.hosts.get(0).name + " " + newBooking.hosts.get(0).surrName + " nebola pridaná do rezervačného listu. Prosím skontrolujte si dátum od: " + newBooking.startDate + " Do: " + newBooking.endDate);
        }

    }

    public void printBookings() {
        for (Booking booking : bookings) {
           booking.BookingInfo();
        }
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




}
