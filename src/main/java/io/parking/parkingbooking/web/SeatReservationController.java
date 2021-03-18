package io.parking.parkingbooking.web;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import io.parking.parkingbooking.domain.SeatReservation ;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.parking.parkingbooking.dto.AllReservationDto;
import io.parking.parkingbooking.dto.SeatReservationDto;
import io.parking.parkingbooking.repositories.SeatReservationRepository;
import io.parking.parkingbooking.services.MapValidationErrorService;
import io.parking.parkingbooking.services.SeatReservationService;

@Controller
@RestController
@RequestMapping(value="/api")
public class SeatReservationController {
	
	@Autowired
	SeatReservationService seatReservationService;
	
	@Autowired
	SeatReservationRepository seatReservationRepository;
	
	@Autowired
    private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping(value="/seats")
	  public ResponseEntity<?> createNewProject(@Valid @RequestBody SeatReservationDto part, BindingResult result, Principal principal){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;
        SeatReservation part1 =  seatReservationService.saveSeatReservation(part, principal.getName());
        return new ResponseEntity<SeatReservation>(part1, HttpStatus.CREATED);
    }
	
	@GetMapping(value="/seats")
	  public ResponseEntity<?> findAllReservations(Principal principal){
		 Set<SeatReservation >partS =  seatReservationRepository.findByUser_Username(principal.getName());
	   //List<Part >partS = seatReservationRepository.findAll();

      return new ResponseEntity<Set<SeatReservation >>(partS, HttpStatus.CREATED);
	}
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


}
