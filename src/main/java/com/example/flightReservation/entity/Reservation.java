package com.example.flightReservation.entity;
import com.example.flightReservation.entity.common.AbstractEntity;

import javax.persistence.*;

@Entity
public class Reservation extends AbstractEntity {
    private Boolean checkedIn;
    private Integer numberOfBags;

    @ManyToOne
    @JoinColumn(name="passenger.id",insertable=false, updatable = false)
    private Passenger passenger;


    @ManyToOne
    @JoinColumn(name="flight.id",insertable=false, updatable = false)
    private Flight flight;

    public Reservation() {
    }

    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public Integer getNumberOfBags() {
        return numberOfBags;
    }

    public void setNumberOfBags(Integer numberOfBags) {
        this.numberOfBags = numberOfBags;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
