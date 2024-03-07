package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int roomNumber = input.nextInt();
            System.out.print("Check-in date: ");
            Date checkIn = sdf.parse(input.next());
            System.out.print("Check-out date: ");
            Date checkOut = sdf.parse(input.next());
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.print(reservation);
            System.out.println();

            System.out.print("Enter new Check-in date: ");
            checkIn = sdf.parse(input.next());
            System.out.print("Enter new Check-out date: ");
            checkOut = sdf.parse(input.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.print(reservation);
        }
        catch (ParseException e){
            System.out.println("[dd/MM/yyyy] - Invalid date format!");
        }
        catch (DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error");
        }

        input.close();
    }
}
