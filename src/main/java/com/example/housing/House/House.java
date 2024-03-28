package com.example.housing.House;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int hn;
    int bedroom;
    int bathroom;
    int squareFoot;
    String location;
    int salePrice;
}
