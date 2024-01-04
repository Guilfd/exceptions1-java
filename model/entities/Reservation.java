package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	
	private static SimpleDateFormat sfd = new SimpleDateFormat ("dd/MM/yyyy");
	
	private Integer  roomNumber;
	private Date checkIn;
	private Date checkOut;
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if ( checkOut.after(checkIn)) {
			throw new DomainException ("Check-Out date mast be after check-in date");
		}
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	
	public Date getCheckOut() {
		return checkOut;
	}

	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	
	public void updateDates(Date CheckOut, Date checkIn) throws DomainException {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException ("Reservation dates for update must be future dates");
		}
		if ( checkOut.after(now)) {
			throw new DomainException ("Check-Out date mast be after check-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "room "
				+ roomNumber
				+ ", check-in: "
				+ sfd.format(checkIn)
				+ ", check-Out"
				+ sfd.format(checkOut)
				+ ", "
				+ duration()
				+ " nights: ";
	}
	
	
	
}
