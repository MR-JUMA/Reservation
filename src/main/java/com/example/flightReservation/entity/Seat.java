package com.example.flightReservation.entity;

import com.example.flightReservation.entity.common.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Set;
@Entity
public class Seat extends AbstractEntity {


    @ManyToOne
    @JoinColumn(name="reservation.id",insertable=false, updatable = false)
    private Reservation reservation;


    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//
//    @JoinColumn(name="cart_id", nullable=false)
//    private Passenger  passenger;
    //private Set<Passenger> passengers;
}
