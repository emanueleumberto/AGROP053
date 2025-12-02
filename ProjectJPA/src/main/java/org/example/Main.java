package org.example;

import org.example.dao.UserDao;
import org.example.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main( String[] args ) {
//        User u = new User();
//        u.setName("Mario");
//        u.setLastname("Rossi");
//        u.setAge(25);
//        u.setEmail("m.rossi@example.com");
//        u.setPassword("Pa$$w0rd!");

//        UserDao.saveUser(u);

        User u = UserDao.getUserById(1);
        // u.setAge(99);
        // UserDao.saveUser(u);
        // System.out.println(u);

        UserDao.removeUser(u);
    }
}
