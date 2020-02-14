package com.afam.jpa.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public
class FullTimeEmployee extends Employee {
    protected Double salary;
}
