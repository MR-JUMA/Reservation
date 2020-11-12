package com.example.flightReservation.repository;

import com.example.flightReservation.entity.Flight;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {

    @Query(value = "from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture and dateOfReturn=:dateOfReturn and flightNumber=:flightNumber and price=:price and estimatedDepartureTime=:estimatedDepartureTime")
    List<Flight> findFlights(@Param("departureCity") String departureCity, @Param("arrivalCity") String arrivalCity, @Param("dateOfDeparture") Date dateOfDeparture,  @Param("dateOfReturn")Date dateOfReturn,@Param("flightNumber")String flightNumber,@Param("price")String price,@Param("estimatedDepartureTime") Time estimatedDepartureTime);

    @Query(value = "from Flight WHERE dateOfDeparture >=:dateOfDeparture order by dateOfDeparture")
     List<Flight> getFlightByDate(@Param("dateOfDeparture")String dateOfDeparture);

    @Query("from Flight where dateOfReturn>:dateOfDeparture and dateOfReturn<=:dateOfReturn ")
    List<Flight> findRoundFlights(@Param("dateOfDeparture")String dateOfDeparture,@Param("dateOfReturn")String dateOfReturn);

}
