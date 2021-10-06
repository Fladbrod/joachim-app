package kea.mandatory1.joachimapp.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "cars")
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String brand;

    @Column
    private String type;

    @Column
    private String engine;

    @Column
    private int year;
}
