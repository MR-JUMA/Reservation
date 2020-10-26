package com.example.flightReservation.entity;
import com.example.flightReservation.entity.common.AbstractEntity;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class Flight extends AbstractEntity {
    private String flightNumber;
    private String departureCity;
    private String arrivalCity;
    //@Temporal(TemporalType.DATE)
    private Date dateOfDeparture;
   // @Temporal(TemporalType.DATE)
    private Date dateOfReturn;
    private Time estimatedDepartureTime;

    public Flight() {

    }
    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
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

    public Date getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(Date dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public Time getEstimatedDepartureTime() {
        return estimatedDepartureTime;
    }

    public void setEstimatedDepartureTime(Time estimatedDepartureTime) {
        this.estimatedDepartureTime = estimatedDepartureTime;
    }
}
