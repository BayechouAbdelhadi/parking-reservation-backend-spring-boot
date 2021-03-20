package io.parking.parkingbooking.services;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import io.parking.parkingbooking.domain.ParkingReservation;
import io.parking.parkingbooking.domain.User;
import io.parking.parkingbooking.dto.ParkingReservationDto;
import io.parking.parkingbooking.repositories.ParkingReservationRepository;
import io.parking.parkingbooking.repositories.UserRepository;

@Service
public class ParkingReservationService {

	@Autowired 
	ParkingReservationRepository parkingRepository;
	
	@Autowired
	UserRepository userReposittory;
	
	public ParkingReservation saveParkingReservation(ParkingReservationDto parkingDto,String username) 
	{
		User user = userReposittory.findByUsername(username);
		ParkingReservation parking=new ParkingReservation();
		parking.setUser(user);
		parking.setPark(parkingDto.getPark());
		try {
			parking.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(parkingDto.getStart_reservation()));
			parking.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(parkingDto.getEnd_reservation()));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ParkingReservation p= parkingRepository.save(parking);
		return p;
	}
	
}