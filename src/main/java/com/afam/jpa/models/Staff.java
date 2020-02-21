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
@DiscriminatorColumn( name = "type")
@Inheritance( strategy = InheritanceType.SINGLE_TABLE)
public class Staff implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int sid;

    private String name;
}
