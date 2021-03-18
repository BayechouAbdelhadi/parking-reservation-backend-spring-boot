package io.parking.parkingbooking.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class SeatReservation {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull( message = "Please enter a time slot ")
	private int time ;
	
	@NotNull( message = "Please enter a time slot ")
	private int seat ;
    
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(updatable = false)
    private Date created_At;
    
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date reservationdate;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getReservationdate() {
		return reservationdate;
	}

	public void setReservationdate(Date reservation_date) {
		this.reservationdate = reservation_date;
	}

	@PrePersist
    protected void onCreate(){
        this.created_At = new Date();
    }


	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}	
