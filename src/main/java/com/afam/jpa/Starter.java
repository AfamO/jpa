/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afam.jpa;

import com.afam.jpa.models.Employee;
import com.afam.jpa.models.FullTimeEmployee;
import com.afam.jpa.models.Task;
import com.afam.jpa.models.User;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author afam.okonkwo
 */
@Slf4j
public class Starter {
    
    
    public static void main(String [] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, 1L); 
        System.out.println("Found User == " + user);

        queryEmployee(em);
        //createBulkEmployee(em);
        //saveUser(em);
        //dropUser(em);
        emf.close();
       
    }
    
    static void saveUser(EntityManager em) {
        
        em.getTransaction().begin();
        User user = new User();
        user.setActive(Boolean.FALSE);
        user.setPassword("cigao");
        user.setRoles("ROLE_ADMIN");
        user.setUser_Name("CigaO");
        em.persist(user);
        em.getTransaction().commit();
        System.out.println("Successfully saved User == " + user);
        
    }
    
    static void dropUser(EntityManager em) {
        
        em.getTransaction().begin();
        User user = em.find(User.class, 2L);
        em.remove(user);  
        em.getTransaction().commit();
        System.out.println("Successfully removed User == " + user);
        
    }

    static void createBulkEmployee(EntityManager entityManager) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee();
        
        Employee employee = new Employee();
        employee.setEid( 1201 );
        employee.setEname( "Gopal" );
        employee.setSalary(40000d);
        employee.setDeg( "Technical Manager" );
        entityManager.persist(fullTimeEmployee);
        employee.setEmployeeType("Full_Time");
        entityManager.persist(employee);
        
        employee = new Employee();
        employee.setEid( 1202 );
        employee.setEname( "Manisha" );
        employee.setSalary(40000D);
        employee.setDeg( "Proof Reader" );
        entityManager.persist(fullTimeEmployee);
        employee.setEmployeeType("Full_Time");
        entityManager.persist(employee);
        
        employee = new Employee();
        employee.setEid( 1203 );
        employee.setEname( "Masthanvali" );
        employee.setSalary(40000d);
        employee.setDeg( "Technical Writer" );
        entityManager.persist(fullTimeEmployee);
        employee.setEmployeeType("Full_Time");
        entityManager.persist(employee);
        
        employee = new Employee();
        employee.setEid( 1204 );
        employee.setEname( "Satish" );
        employee.setSalary(30000D);
        employee.setDeg( "Technical Writer" );
        entityManager.persist(fullTimeEmployee);
        employee.setEmployeeType("Full_Time");
        entityManager.persist(employee);
        
        employee = new Employee();
        employee.setEid( 1205 );
        employee.setEname( "Krishna" );
        employee.setSalary(30000d);
        employee.setDeg( "Technical Writer" );
        entityManager.persist(fullTimeEmployee);
        employee.setEmployeeType("Full_Time");
        entityManager.persist(employee);
        
        employee = new Employee();
        employee.setEid( 1206 );
        employee.setEname( "Kiran" );
        employee.setSalary(35000D);
        employee.setDeg( "Proof Reader" );
        entityManager.persist(fullTimeEmployee);
        employee.setEmployeeType("Full_Time");
        entityManager.persist(employee);
        
        Task task1 = new Task("Welcome Visitors", new Date(), false);
        Task task2 = new Task("Type Marketing Letters", new Date(), false);
        entityManager.persist(task1);
        entityManager.persist(task2);
        log.info(" The Id of fullTimeEmployee,Task1, Task2 Is {}, {}, {} :: " + fullTimeEmployee.getId(), task1,  task2);
        employee.setTasks(Arrays.asList(task1,task2 ));
        entityManager.persist(employee);
        
        
        entityTransaction.commit();
        System.out.println("Successfully saved Employee " + employee);

        entityManager.close();

        
    }

    static void queryEmployee(EntityManager entityManager) {
        // scalar function
        Query query = entityManager.createQuery("Select UPPER(e.ename) from Employee e");
        List<String> list =  query.getResultList();
        System.out.println("QueryList:: " + list);
        list.forEach((empl) -> {
            System.out.println("Employee Name : " + empl);
        });

        //Aggregate Function

        query = entityManager.createQuery("Select MAX(e.salary) from Employee e");
        Double result = (Double)query.getSingleResult();
        System.out.println("Max Employee Salary: " + result);

        query = entityManager.createQuery("select e from Employee e where e.salary BETWEEN 10000 AND 30000");

        List<Employee> list1 = query.getResultList();
        System.out.println("Between Query Results :: " );
        list1.forEach((emp) -> System.out.println("Employee is " + emp) );
        System.out.println("QueryList1:: " + list1);

        query = entityManager.createQuery("select e from Employee e where e.ename LIKE '%sh%' ");

        List<Employee> list2 = query.getResultList();
        System.out.println("Like Query Results :: " );
        list2.forEach((emp)-> System.out.println("Employee: " + emp));
        System.out.println("QueryList2:: " + list2);

        System.out.println("Order by Results :: " );

        query = entityManager.createQuery("SELECT e from Employee e  ORDER BY e.ename ASC");

        System.out.println("Query :: " + query);

        List<Employee> employeeList = (List<Employee>) query.getResultList();
        
        employeeList.stream().map(employee -> "Employee ID :" + employee.getEid( ) +"\t Employee Name :" + employee.getEname( )).forEach(System.out::println);
        //System.out.println("employeeList:: " + employeeList);

        // Execute Named Queries
        query = entityManager.createNamedQuery("findEmployeeById");
        query.setParameter("id", 1204);
        List<Employee> list3 = query.getResultList();
        System.out.println("NamedQueryResult Is :: ");
        list3.forEach(System.out::println);

        entityManager.close();


    }

}
