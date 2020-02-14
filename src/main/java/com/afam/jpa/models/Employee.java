/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afam.jpa.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author afam.okonkwo
 */
@NamedQuery(query = "Select e from Employee e where e.eid = :id", name = "findEmployeeById")
@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "EMPLOYEE_TYPE")
public class Employee implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int eid;
    private String ename;
    private String deg;
    private String employeeType;
    private Double salary;
    
    @ManyToMany
    private List<Task> tasks;
    
}

