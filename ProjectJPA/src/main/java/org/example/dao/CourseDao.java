package org.example.dao;

import org.example.entities.Company;
import org.example.entities.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CourseDao {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private static EntityManager em = emf.createEntityManager();

    public static void saveCourse(Course course) {
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
    }

    public static Course getCourseById(long id) {
        return em.find(Course.class, id);
    }

    public static void removeCourse(Course course) {
        em.getTransaction().begin();
        em.remove(course);
        em.getTransaction().commit();
    }

    public static List<Course> getAllCourses() {
        Query q = em.createNamedQuery("Course.findAll");
        return q.getResultList();
    }
}
