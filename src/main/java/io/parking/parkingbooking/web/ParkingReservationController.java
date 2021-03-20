package io.parking.parkingbooking.web;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.parking.parkingbooking.domain.ParkingReservation;
import io.parking.parkingbooking.domain.SeatReservation;
import io.parking.parkingbooking.dto.ParkingReservationDto;
import io.parking.parkingbooking.repositories.ParkingReservationRepository;
import io.parking.parkingbooking.security.Path;
import io.parking.parkingbooking.services.MapValidationErrorService;
import io.parking.parkingbooking.services.ParkingReservationService;

@CrossOrigin(origins = Path.PATH)
@RestController
@RequestMapping(value="/api")
public class ParkingReservationController {
	
	@Autowired
	ParkingReservationService parkingResrvationService;
	
	@Autowired
	ParkingReservationRepository parkingReservationRepository;
	
	@Autowired
    private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping(value="/parking")
	  public ResponseEntity<?> createNewParking(@Valid @RequestBody ParkingReservationDto parking, BindingResult result, Principal principal){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;
        ParkingReservation parking1 =  parkingResrvationService.saveParkingReservation(parking, principal.getName());
        return new ResponseEntity<ParkingReservation>(parking1, HttpStatus.CREATED);
    }
	@GetMapping(value="/parking")
	  public ResponseEntity<?> findAllReservations(Principal principal){
		 Set<ParkingReservation >partS =  parkingReservationRepository.findByUser_Username(principal.getName());
	   //List<Part >partS = seatReservationRepository.findAll();

    return new ResponseEntity<Set<ParkingReservation >>(partS, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/parking/{park}")
	  public ResponseEntity<?> findParkingReservationsByParkId(@PathVariable int park){
		 Set<ParkingReservation> parking=  parkingReservationRepository.findByPark(park);
	   //List<parking >parkingS = seatReservationRepository.findAll();
      return new ResponseEntity<Set<ParkingReservation >>(parking, HttpStatus.CREATED);
	}
	/*
	@GetMapping(value="/seats/{seat}")
	  public ResponseEntity<?> findAllReservationsToday(@PathVariable int seat) throws ParseException{
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
		String now=format.format((new Date()));
		Date d =format.parse(now);
		Set<SeatReservation > todayReservation =  seatReservationRepository.findByReservationdateAndSeat( d,seat);
    return new ResponseEntity<Set<SeatReservation >>(todayReservation, HttpStatus.CREATED);
	}
	@PostMapping(value="/seats/{seat}")
	  public ResponseEntity<?> findAllReservations(@PathVariable int seat, @RequestBody AllReservationDto allReservationDto ) throws ParseException{
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
		//String now=format.format((new Date()));
		Date d =format.parse(allReservationDto.getDate());
		Set<SeatReservation > todayReservation =  seatReservationRepository.findByReservationdateAndSeat( d,seat);
  		return new ResponseEntity<Set<SeatReservation >>(todayReservation, HttpStatus.CREATED);
	}
*/

}