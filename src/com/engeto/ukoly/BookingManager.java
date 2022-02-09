package com.engeto.ukoly;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {

    List<Booking> bookings = new ArrayList<>();

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

            if (isOverlapping(newBooking)) {
                //TODO vypis message ze sa booking prekryva s inym
                return;
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

    public boolean isOverlapping(Booking overlappingBooking) {
        return bookings.stream().anyMatch(booking -> booking.room.roomNumber == overlappingBooking.room.roomNumber
                && (booking.startDate.isBefore(overlappingBooking.endDate) || booking.startDate.equals(overlappingBooking.startDate))
                && (booking.endDate.isAfter(overlappingBooking.startDate) || booking.endDate.equals(overlappingBooking.endDate))
        );
    }
}
