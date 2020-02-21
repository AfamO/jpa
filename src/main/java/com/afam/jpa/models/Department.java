package com.afam.jpa.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int id;
    private String name;

    //@OneToMany(targetEntity = Employee.class)
    //private List<Employee> employeeList;
}
