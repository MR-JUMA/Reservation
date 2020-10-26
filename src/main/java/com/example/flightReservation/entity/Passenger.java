package com.example.flightReservation.entity;
import com.example.flightReservation.entity.common.AbstractEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Passenger extends AbstractEntity {
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;



//
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Reservation reservation;



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

//
//Example 1: One-to-Many association using generics
//
//// In Customer class:
//
//@OneToMany(cascade=ALL, mappedBy="customer")
//public Set<Order> getOrders() { return orders; }
//
//        In Order class:
//
//@ManyToOne
//@JoinColumn(name="CUST_ID", nullable=false)
//public Customer getCustomer() { return customer; }
//
//
//        Example 2: One-to-Many association without using generics
//
//// In Customer class:
//
//@OneToMany(targetEntity=com.acme.Order.class, cascade=ALL,
//        mappedBy="customer")
//public Set getOrders() { return orders; }
//
//// In Order class:
//
//@ManyToOne
//@JoinColumn(name="CUST_ID", nullable=false)
//public Customer getCustomer() { return customer; }
//
//
//        Example 3: Unidirectional One-to-Many association using a foreign key mapping
//
//// In Customer class:
//
//@OneToMany(orphanRemoval=true)
//@JoinColumn(name="CUST_ID") // join column is in table for Order
//public Set<Order> getOrders() {return orders;}
//
