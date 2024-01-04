package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Programm {

	public static void main(String[] args)  {

		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sfd = new SimpleDateFormat("dd/mm/yyyy");
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyy): ");
			Date checkIn = sfd.parse(sc.next());
			System.out.print("Chec-Out date (dd/MM/yyy): ");
			Date checkOut = sfd.parse(sc.next());
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation " + reservation);
	
			System.out.println();
			System.out.println("Enter date to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyy): ");
			checkIn = sfd.parse(sc.next());
			System.out.print("Chec-Out date (dd/MM/yyy): ");
			checkOut = sfd.parse(sc.next());
	
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation " + reservation);
		}
		catch(ParseException e) {
			System.out.print("Invalid date format");
		}
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.print("Unexpected error");
		}
		sc.close();

	}

}
