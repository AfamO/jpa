/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afam.jpa;

import com.afam.jpa.models.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.*;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.apache.commons.lang.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author afam.okonkwo
 */
@Slf4j
public class Starter {

    static class TestNullPointer {
        private String name; 
        private Long account;
        public TestNullPointer(String name, Long account){
            this.name = Objects.requireNonNull(name, "Name must not be null!");
            this.account = Objects.requireNonNull(account, "acccount must not be null!"); 
        }

        public  void print()
        {
            System.out.println("Conactenated Name == " + this.name.concat("good") + ",  Account Class " + this.account.getClass());
        }
    }

    public static void main(String [] args) throws FileNotFoundException, ScriptException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        //User user = em.find(User.class, 1L);
        //System.out.println("Found User == " + user);
        new TestNullPointer("CigaO", 123L).print();
        System.out.println("Padded String Is ::" + StringUtils.leftPad("bat", 10));
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("Nashorn");
        scriptEngine.eval(new FileReader("C:\\Users\\afam.okonkwo\\Documents\\Afam\\helloNashon.js"));
        //new TeacherService().SaveTeacher(em); //save teacher and corresponding class info.
        //new StaffService().SaveStaffs(em);
        //queryEmployee(em);
        criteriaQueryEmployee(em);
        Map<String, Double> map = new HashMap<>();
        map.put("Fee Amount", 12.4);
        map.put("fee", 33D);
        System.out.println("Map Is "+map);
        System.out.println("Fee Amount "+map.get("Fee Amount"));
        //createEmployee_OneToOne(em);
        //createBulkEmployee_OneToMany(em);
        //saveUser(em);
        //dropUser(em);
        emf.close();

    }
    
    static void criteriaQueryEmployee(EntityManager em) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<Employee> from = criteriaQuery.from(Employee.class);
        
        
        //select all records
         System.out.println("Select all records");
         CriteriaQuery<Object> select = criteriaQuery.select(from)
                                        .where(criteriaBuilder.equal(from.get("salary"), 35000))
                                        ;
         TypedQuery<Object> typedQuery = em.createQuery(select);
         List<Object> resultList = typedQuery.getResultList();
         resultList.stream().map((o) -> (Employee)o).forEachOrdered((e) -> {
             System.out.println("EID : " + e.getEid() + " Ename : " + e.getEname());
        });
         
       //Ordering the records
       System.out.println("Select all records by follow ordering");
       select.orderBy(criteriaBuilder.asc(from.get("ename")));
       typedQuery = em.createQuery(select);
       resultList = typedQuery.getResultList();
       resultList.stream().map((o) -> (Employee)o).forEachOrdered((e) -> {
             System.out.println("EID : " + e.getEid() + " Ename : " + e.getEname() + "Salary : " +e.getSalary());
        });
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

    static void createEmployee_OneToOne(EntityManager entityManager) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        
        Employee employee = new Employee();
        employee.setEid( 1201 );
        employee.setEname( "Satish" );
        employee.setSalary(45000.0);
        employee.setDeg( "Technical Writer" );

        Department department = new Department();
        department.setName("Development");

        entityManager.persist(department);
        employee.setDepartment(department);
        entityManager.persist(employee);
        
        
       

        entityTransaction.commit();
        //System.out.println("Successfully saved OneToOne Employee To DB " + employee);

        entityManager.close();
        

    }

    static void createBulkEmployee_OneToMany(EntityManager entityManager) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        List<Employee> employeeList = new ArrayList<>();
        

        Employee employee = new Employee();
        employee.setEid( 1201 );
        employee.setEname( "Gopal" );
        employee.setSalary(40000d);
        employee.setDeg( "Technical Manager" );
        entityManager.persist(employee);
        employeeList.add(employee);

        employee = new Employee();
        employee.setEid( 1202 );
        employee.setEname( "Manisha" );
        employee.setSalary(40000D);
        employee.setDeg( "Proof Reader" );
        
        entityManager.persist(employee);
        employeeList.add(employee);

        employee = new Employee();
        employee.setEid( 1203 );
        employee.setEname( "Masthanvali" );
        employee.setSalary(40000d);
        employee.setDeg( "Technical Writer" );
        
        entityManager.persist(employee);
        employeeList.add(employee);

        employee = new Employee();
        employee.setEid( 1204 );
        employee.setEname( "Satish" );
        employee.setSalary(30000D);
        employee.setDeg( "Technical Writer" );
        entityManager.persist(employee);
        employeeList.add(employee);

        employee = new Employee();
        employee.setEid( 1205 );
        employee.setEname( "Krishna" );
        employee.setSalary(30000d);
        employee.setDeg( "Technical Writer" );
        
        entityManager.persist(employee);
        employeeList.add(employee);

        employee = new Employee();
        employee.setEid( 1206 );
        employee.setEname( "Kiran" );
        employee.setSalary(35000D);
        employee.setDeg( "Proof Reader" );
        
        entityManager.persist(employee);
        employeeList.add(employee);
        
        Department department = new Department();
        department.setName("Development");
        //department.setEmployeeList(employeeList);
        entityManager.persist(department);
        Task task1 = new Task("Welcome Visitors", new Date(), false);
        Task task2 = new Task("Type Marketing Letters", new Date(), false);
        entityManager.persist(task1);
        entityManager.persist(task2);

        //employee.setTasks(Arrays.asList(task1,task2 ));
        entityManager.persist(employee);


        entityTransaction.commit();
        System.out.println("Successfully saved Employee To DB " + employee);

        entityManager.close();


    }

    static void createBulkEmployee_ManyToOne(EntityManager entityManager) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Department department = new Department();
        department.setName("Development");
        entityManager.persist(department);
        
        Employee employee = new Employee();
        employee.setEid( 1201 );
        employee.setEname( "Gopal" );
        employee.setSalary(40000d);
        employee.setDeg( "Technical Manager" );
        //employee.setDepartment(department);
        entityManager.persist(employee);
        
        employee = new Employee();
        employee.setEid( 1202 );
        employee.setEname( "Manisha" );
        employee.setSalary(40000D);
        employee.setDeg( "Proof Reader" );
        //employee.setDepartment(department);
        entityManager.persist(employee);
        
        employee = new Employee();
        employee.setEid( 1203 );
        employee.setEname( "Masthanvali" );
        employee.setSalary(40000d);
        employee.setDeg( "Technical Writer" );
        //employee.setDepartment(department);
        entityManager.persist(employee);

        employee = new Employee();
        employee.setEid( 1204 );
        employee.setEname( "Satish" );
        employee.setSalary(30000D);
        employee.setDeg( "Technical Writer" );
        //employee.setDepartment(department);
        entityManager.persist(employee);

        employee = new Employee();
        employee.setEid( 1205 );
        employee.setEname( "Krishna" );
        employee.setSalary(30000d);
        employee.setDeg( "Technical Writer" );
        //employee.setDepartment(department);
        entityManager.persist(employee);

        employee = new Employee();
        employee.setEid( 1206 );
        employee.setEname( "Kiran" );
        employee.setSalary(35000D);
        employee.setDeg( "Proof Reader" );
       // employee.setDepartment(department);
        entityManager.persist(employee);

        Task task1 = new Task("Welcome Visitors", new Date(), false);
        Task task2 = new Task("Type Marketing Letters", new Date(), false);
        entityManager.persist(task1);
        entityManager.persist(task2);
        
        //employee.setTasks(Arrays.asList(task1,task2 ));
        entityManager.persist(employee);


        entityTransaction.commit();
        System.out.println("Successfully saved Employee " + employee);

        entityManager.close();

        
    }

    static void queryEmployeee(EntityManager entityManager) {
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
