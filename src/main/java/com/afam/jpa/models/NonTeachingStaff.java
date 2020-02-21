package com.afam.jpa.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@DiscriminatorValue( value = "NS")
//@PrimaryKeyJoinColumn( referencedColumnName = "sid")
public class NonTeachingStaff extends Staff_TablePerClass {
    private String areaExpertise;

    public NonTeachingStaff(int sid, String sname, String areaExpertise ) {
        super(sid, sname);
        this.areaExpertise = areaExpertise;
    }
}
