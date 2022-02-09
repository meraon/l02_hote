package com.engeto.ukoly;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BookingManager bookings = new BookingManager();
//        1. Vytvoř klienty Adélu Malíkovou (narozena 13. 3. 1993) a Jana Dvořáčka (narozen 5.5.1995). Vypiš na obrazovku jejich popis (description).
        Host adela = new Host("Adéla", "Malíkova", LocalDate.of(1993, 3, 13));
        Host jan = new Host("Jan", "Dvořák",LocalDate.of(1995,5,5));
        adela.getDescription();
        jan.getDescription();
//        2.  Vytvoř pokoje a vypiš na obrazovku jejich popis (description).:
//            číslo 1 a 2, které budou jednolůžkové za cenu 1000 Kč/noc, s balkonem a výhledem na moře. Vypiš na obrazovku jejich popis (description).
//                pokoj číslo 3, který bude trojlůžkový za cenu 2400 Kč/noc, bez balkónu, s výhledem na moře.
        Room single1 = new Room(1,1,true,true, BigDecimal.valueOf(1000));
        Room single2 = new Room(2,1,true,true, BigDecimal.valueOf(1000));
        Room family3 = new Room(3,3,false,true, BigDecimal.valueOf(2400));
        System.out.println(single1.RoomInfo());
        System.out.println(single2.RoomInfo());
        System.out.println(family3.RoomInfo());
//        3. Připrav rezervace:
//        pro Adélu na pokoj č. 1 od 19. do 26. 7. 2021.
//        pro oba (společná rezervace) na pokoj č. 3 od 1. do 14. 9. 2021.
        Booking booking1 = new Booking(Arrays.asList(adela),single1,LocalDate.of(2022,7,19),LocalDate.of(2022,7,26), Booking.TypeOfStay.RECREATION);
        Booking booking2 = new Booking(Arrays.asList(adela,jan),family3,LocalDate.of(2022,9,1),LocalDate.of(2022,9,14), Booking.TypeOfStay.WORK);
        booking1.BookingInfo();
        bookings.addBooking(booking1);
        bookings.addBooking(booking2);
//        4. Vypiš seznam všech rezervací.
        bookings.printBookings();
        System.out.println("------------------------------Zkontroluj si: zajímavé body, challenge a časté chyby--------------------------------------");
//        Zkontroluj si: zajímavé body, challenge a časté chyby
//        1. Je rozlišen pracovní a rekreační pobyt (potřebuje enum)?
        //použil som enum aby som zabránil nezmyslu na vstupe
        System.out.println(booking1.getType());
        System.out.println(booking2.getType());
//        2. Lze evidovat více hostů v rámci jedné rezervace.
        //ano, naplňam si pole hosti

//        3. Můžeme sledovat historii rezervací? Nepřepíše se novou rezervací informace o původní rezervaci? (Údaje o rezervaci by neměly být součástí hosta ani pokoje.)
        // ano, držím to v instancií "bookings" vytvorenej na 11. riadku, taktiež to slúži ako historia, nižie som Petrovi pridelil izbu č.1 rovnakú akú má adela akurát v inom dátume
        Host peter = new Host("Peter", "Novák",LocalDate.of(1986,1,1));
        booking1 = new Booking(Arrays.asList(peter),single1,LocalDate.of(2022,11,28),LocalDate.of(2022,12,3), Booking.TypeOfStay.RECREATION);
        bookings.addBooking(booking1);
        bookings.printBookings();
//        4. Volitelně můžeš zkusit zařídit, aby se při vytváření rezervace rezervovalo automaticky na rekreační pobyt od dneška na dalších 6 nocí, pokud nezadáš konkrétní data začátku a konce. (Pokud uvedeš všechny parametry rezervace, použijí se tak, jak jsou zadané.)
        Booking bookingRecreation = new Booking(Arrays.asList(peter),family3);
        bookings.addBooking(bookingRecreation);
        bookings.printBookings();

        System.out.println("--------------------------------Ošetrovanie vstupov------------------------------------");
        booking1 = new Booking(Arrays.asList(peter),single1,LocalDate.of(2022,1,1),LocalDate.of(2022,1,30), Booking.TypeOfStay.RECREATION);
        bookings.addBooking(booking1);
        booking1 = new Booking(Arrays.asList(peter),single1,LocalDate.of(2023,11,28),LocalDate.of(2022,12,3), Booking.TypeOfStay.RECREATION);
        bookings.addBooking(booking1);
    }
}
