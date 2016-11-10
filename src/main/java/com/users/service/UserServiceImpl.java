package com.users.service;

import com.users.domain.User;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UsersService {

    private SessionFactory sessionFactory;
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User save (User u) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(u);
        return u;
    }

    public List<User> get() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> personsList = session.createQuery("from User").list();
        for(User p : personsList){
            System.out.println("User => "+p);
        }
        return personsList;
    }

}
/*TEST*//*

        long startTime = System.currentTimeMillis();

        System.out.println("START: " + new Date());
        for(int i=0; i<10000; i++){
            User u2 = new User();
            u2.setFirstName(u.getFirstName());
            u2.setLastName(u.getLastName());
            u2.setEmail(u.getEmail());
            u2.setPassword(u.getPassword());
            u2.setUserName(u.getUserName());
            session.persist(u2);
           //System.out.println(i + " : " + u2.getId());
        }

        System.out.println("END: " + new Date());
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;

        long second = (elapsedTime / 1000) % 60;
        long minute = (elapsedTime / (1000 * 60)) % 60;
        long hour = (elapsedTime / (1000 * 60 * 60)) % 24;

        String diff = String.format("%02d:%02d:%02d", hour, minute, second);

        System.out.println("Time: " + diff);
        *//*TEST END*//*

        return u;*/