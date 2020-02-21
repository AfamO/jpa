package com.afam.jpa.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@DiscriminatorValue( value = "TS")
//@PrimaryKeyJoinColumn(referencedColumnName = "sid")
public class TeachingStaff extends Staff_TablePerClass {
    private String qualification;
    private String subjectExpertise;

    public TeachingStaff(int sid, String sname, String qualification, String subjectExpertise) {
        super(sid, sname);
        this.qualification = qualification;
        this.subjectExpertise = subjectExpertise;
    }

    
}
