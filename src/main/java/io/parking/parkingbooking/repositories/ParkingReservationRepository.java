package io.parking.parkingbooking.repositories;
import java.util.Date;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.parking.parkingbooking.domain.ParkingReservation;


@Repository
public interface  ParkingReservationRepository extends JpaRepository<ParkingReservation,Long> {
	ParkingReservation save(ParkingReservation part);
	Set<ParkingReservation> findByUser_Username(String username);
	//Set<ParkingReservation> findByReservationdateAndSeat(Date reservationDtae,int seat);
	Set<ParkingReservation> findByPark(int park);

}
