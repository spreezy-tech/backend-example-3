package com.backend.restro.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;

@Data
@Entity
@Table(name = "restaurant_details")
public class RestaurantDetails {

    @Id
    @SequenceGenerator(name = "restaurant_id_seq", sequenceName = "restaurant_id_seq", allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_id_seq")
    private Integer id;
    private String name;
    private String address;
    private String cuisine;
    private Integer numberOfTables;
    
}
