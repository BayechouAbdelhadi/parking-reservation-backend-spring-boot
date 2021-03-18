package io.parking.parkingbooking.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class SeatReservationDto {
	
	 @NotNull( message = "Please enter a time")
	 private int time;
	 @NotNull( message = "Please enter a seat")
	 private int seat;
	 @NotNull( message = "Please enter a date")
	 private String reservation_date;
	
	public SeatReservationDto() {
	
	}


	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}


	public int getSeat() {
		return seat;
	}


	public void setSeat(int seat) {
		this.seat = seat;
	}


	public String getReservation_date() {
		return reservation_date;
	}


	public void setReservation_date(String reservation_date) {
		this.reservation_date = reservation_date;
	}

	
}
