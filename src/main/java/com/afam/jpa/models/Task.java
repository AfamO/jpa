/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.afam.jpa.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author HP
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date targetDate;
    private Boolean isDone;
    
    @ManyToMany(mappedBy = "tasks")
    private List<Employee> employees;

    public Task(String description, Date targetDate, Boolean isDone) {
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public Task(String description, Date targetDate, Boolean isDone, List<Employee> employees) {
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = isDone;
        this.employees = employees;
    }
    
    
    
    
    
}
