package com.afam.jpa.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Clas implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int cid;
    private String cname;

    @ManyToMany(targetEntity = Teacher.class)
    private Collection teacherSet;

    public Clas(String cname, Set teacherSet ) {
        this.cname = cname;
        this.teacherSet = teacherSet;
    }


}
