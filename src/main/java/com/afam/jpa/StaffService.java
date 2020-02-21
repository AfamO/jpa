package com.afam.jpa;

import com.afam.jpa.models.NonTeachingStaff;
import com.afam.jpa.models.TeachingStaff;

import javax.persistence.EntityManager;

public class StaffService {
    

    public void SaveStaffs(EntityManager entityManager) {

        entityManager.getTransaction().begin();

        //Teaching Staff Entity
        TeachingStaff teachingStaff1 = new TeachingStaff(1, "Gopal", "Msc Med", "Maths");
        TeachingStaff teachingStaff2 = new TeachingStaff(2, "Manisha", "BSc BEd", "English");

        //Non Teaching Staff
        NonTeachingStaff nonTeachingStaff1 = new NonTeachingStaff(1, "Satish", "Accounts");
        NonTeachingStaff nonTeachingStaff2 = new NonTeachingStaff(2, "Krishna", "Office Admin");

        //Storing all entities
        System.out.println("TeachingStaff1 Id Is:: "+teachingStaff1.getSid() + " TeachingStaff2 Id Is::"+teachingStaff2.getSid()+ " NonTeachingStaff1 Id Is::"+nonTeachingStaff1.getSid() + " nonTeachingStaff2 Id Is::"+nonTeachingStaff2.getSid());
        entityManager.merge(teachingStaff1);
        entityManager.merge(teachingStaff2);
        entityManager.merge(nonTeachingStaff2);
        entityManager.merge(nonTeachingStaff1);

        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println(" Successfully Saved Staffs: " + teachingStaff1 +" "+ nonTeachingStaff2);
    }
}
