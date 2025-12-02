package org.example;

import org.example.dao.CompanyDao;
import org.example.dao.CourseDao;
import org.example.dao.PassportDao;
import org.example.dao.UserDao;
import org.example.entities.Company;
import org.example.entities.Course;
import org.example.entities.Passport;
import org.example.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {

    private static  EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private static EntityManager em = emf.createEntityManager();

    public static void main( String[] args ) {

//        Course co = new Course("Java", 25);
//        CourseDao.saveCourse(co);
//
//        Company c = new Company("MyCompany");
//        CompanyDao.saveCompany(c);
//
//        User u = new User("Mario", "Rossi", 25, "m.rossi@example.com", "Pa$$w0rd!", c);
//        u.getCourses().add(co);
//        UserDao.saveUser(u);
//
//        Passport p = new Passport(1, LocalDate.now(), u);
//        PassportDao.savePassport(p);

        User u = UserDao.getUserById(1);
        System.out.println(u);
        System.out.println(u.getCompany());
        System.out.println(u.getPassport());
        u.getCourses().forEach(System.out::println);


    }
}
