package com.example.flightReservation.entity;
import com.example.flightReservation.entity.common.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class Flight extends AbstractEntity {
    @NotNull
    private String flightNumber;
    private String departureCity;
    private String arrivalCity;
    private String price;
    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    private String dateOfDeparture;
    @JsonFormat(pattern = "yyyy-MM-dd", shape= JsonFormat.Shape.STRING)
    private String dateOfReturn;
    private Time estimatedDepartureTime;

    private String Type;
    private String PlaneClass;

    public Flight() {

    }

    public String getPrice() {
        return price;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getPlaneClass() {
        return PlaneClass;
    }

    public void setPlaneClass(String planeClass) {
        PlaneClass = planeClass;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(String dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }


    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(String dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public Time getEstimatedDepartureTime() {
        return estimatedDepartureTime;
    }

    public void setEstimatedDepartureTime(Time estimatedDepartureTime) {
        this.estimatedDepartureTime = estimatedDepartureTime;
    }
}
