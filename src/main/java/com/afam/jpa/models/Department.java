package com.afam.jpa.models;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int id;
    private String name;

    //@OneToMany(targetEntity = Employee.class)
    //private List<Employee> employeeList;
}
