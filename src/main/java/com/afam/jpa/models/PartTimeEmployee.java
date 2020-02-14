package com.afam.jpa.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class PartTimeEmployee extends Employee {
    protected Float hourlyWage;
}
