package com.hiraru.mavenproject1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather {
    @Id
    @GeneratedValue
    private int id;
    private double latitude;
    private double longitude;
    private String condition;
    private double temperature;
}