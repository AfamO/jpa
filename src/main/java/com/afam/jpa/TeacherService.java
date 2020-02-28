package com.afam.jpa;

import com.afam.jpa.models.Clas;
import com.afam.jpa.models.Teacher;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

public class TeacherService {

    public void SaveTeacher(EntityManager entityManager) {

        entityManager.getTransaction().begin();




        entityManager.getTransaction().commit();
        /*
        //Create Class Set1
        Set<Clas> clasSet1 = new HashSet<>();
        clasSet1.add(clas1);
        clasSet1.add(clas2);
        clasSet1.add(clas3);

        //Create Class Set2
        Set<Clas> clasSet2 = new HashSet<>();
        clasSet2.add(clas3);
        clasSet2.add(clas1);
        clasSet2.add(clas2);

        //Create Class Set3
        Set<Clas> clasSet3 = new HashSet<>();
        clasSet3.add(clas2);
        clasSet3.add(clas3);
        clasSet3.add(clas1);
        
        */

        Teacher teacher1 = new Teacher("Satish", "Java", null);
        Teacher teacher2 = new Teacher("Krishna", "Adv Java", null);
        Teacher teacher3 = new Teacher("Masthanvali", "DB2", null);

        entityManager.persist(teacher1);
        entityManager.persist(teacher2);
        entityManager.persist(teacher3);

        Set<Teacher> teacherSet = new HashSet<>();
        teacherSet.add(teacher1);
        teacherSet.add(teacher2);
        teacherSet.add(teacher3);

        Set<Teacher> teacherSet2 = new HashSet<>();
        teacherSet2.add(teacher2);
        teacherSet2.add(teacher1);
        teacherSet2.add(teacher3);

        Set<Teacher> teacherSet3 = new HashSet<>();
        teacherSet2.add(teacher3);
        teacherSet2.add(teacher2);
        teacherSet2.add(teacher1);

        entityManager.getTransaction().begin();


        Clas clas1 = new Clas("1st", teacherSet);
        Clas clas2 = new Clas("2nd", teacherSet2);
        Clas clas3 = new Clas("3rd", teacherSet3);

        entityManager.persist(clas1);
        entityManager.persist(clas2);
        entityManager.persist(clas3);

        entityManager.getTransaction().commit();

        entityManager.close();

        System.out.println(" Class was successfully saved to DB "+ clas3);
    }
}
