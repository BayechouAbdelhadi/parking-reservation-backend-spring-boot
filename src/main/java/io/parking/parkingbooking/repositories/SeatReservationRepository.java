package io.parking.parkingbooking.repositories;
import java.util.Date;
import java.util.Set;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import io.parking.parkingbooking.domain.SeatReservation;

@Repository
public interface  SeatReservationRepository extends JpaRepository<SeatReservation,Long> {
SeatReservation save(SeatReservation part);
Set<SeatReservation> findByUser_Username(String username);
Set<SeatReservation> findByReservationdateAndSeat(Date reservationDtae,int seat);

}
