package io.parking.parkingbooking.services;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import io.parking.parkingbooking.domain.SeatReservation;
import io.parking.parkingbooking.domain.User;
import io.parking.parkingbooking.dto.SeatReservationDto;
import io.parking.parkingbooking.repositories.SeatReservationRepository;
import io.parking.parkingbooking.repositories.UserRepository;

@Service
public class SeatReservationService {

	@Autowired 
	SeatReservationRepository partReprsitory;
	
	@Autowired
	UserRepository userReposittory;
	public SeatReservation saveSeatReservation(SeatReservationDto seatDto,String username) 
	{
		User user = userReposittory.findByUsername(username);
		SeatReservation seat=new SeatReservation();
		seat.setUser(user);
		seat.setTime(seatDto.getTime());
		seat.setSeat(seatDto.getSeat());
		seat.setReservationdate(seatDto.getReservation_date());
		SeatReservation p= partReprsitory.save(seat);
		return p;
	}
	/*
	public SeatReservation saveSeatReservation(SeatReservationDto seatDto,String username) 
	{
		User user = userReposittory.findByUsername(username);
		SeatReservation seat=new SeatReservation();
		seat.setUser(user);
		seat.setTime(seatDto.getTime());
		seat.setSeat(seatDto.getSeat());
		try {
			seat.setReservationdate(new SimpleDateFormat("yyyy-MM-dd").parse(seatDto.getReservation_date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SeatReservation p= partReprsitory.save(seat);
		return p;
	}
	*/
}
