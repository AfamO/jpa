package com.afam.jpa.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Teacher implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int tid;
    private String tname;
    private String subject;

    @ManyToMany(targetEntity = Clas.class)
    private Set clasSet;

    public Teacher(String tname, String subject, Set clasSet) {
        this.tname = tname;
        this.subject = subject;
        this.clasSet = clasSet;
    }


}
