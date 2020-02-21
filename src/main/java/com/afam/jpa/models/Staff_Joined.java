package com.afam.jpa.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Inheritance( strategy = InheritanceType.JOINED)
public class Staff_Joined implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int sid;

    private String name;
}

