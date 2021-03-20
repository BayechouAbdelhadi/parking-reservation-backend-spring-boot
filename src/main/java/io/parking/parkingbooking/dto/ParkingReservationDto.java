package io.parking.parkingbooking.dto;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class ParkingReservationDto {

	 @NotNull( message = "Please enter a seat")
	 private int park;
	 @NotNull( message = "Please enter a date")
	 private String start_reservation;
	 @NotNull( message = "Please enter a date")
	 private String end_reservation;
	 public ParkingReservationDto() {
	
	 }
	public int getPark() {
		return park;
	}
	public void setPark(int park) {
		this.park = park;
	}
	public String getStart_reservation() {
		return start_reservation;
	}
	public void setStart_reservation(String start_reservation) {
		this.start_reservation = start_reservation;
	}
	public String getEnd_reservation() {
		return end_reservation;
	}
	public void setEnd_reservation(String end_reservation) {
		this.end_reservation = end_reservation;
	}


	
}
