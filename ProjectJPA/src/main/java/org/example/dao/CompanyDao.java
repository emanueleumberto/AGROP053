package org.example.dao;

import org.example.entities.Company;
import org.example.entities.Passport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CompanyDao {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private static EntityManager em = emf.createEntityManager();

    public static void saveCompany(Company company) {
        em.getTransaction().begin();
        em.persist(company);
        em.getTransaction().commit();
    }

    public static Company getCompanyById(long id) {
        return em.find(Company.class, id);
    }

    public static void removeCompany(Company company) {
        em.getTransaction().begin();
        em.remove(company);
        em.getTransaction().commit();
    }

    public static List<Company> getAllCompanies() {
        Query q = em.createNamedQuery("Company.findAll");
        return q.getResultList();
    }
}
