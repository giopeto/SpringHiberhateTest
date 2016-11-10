package com.groups.service;

import com.groups.domain.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GroupServiceImpl implements GroupService{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Group save(Group g) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(g);
        return g;
    }

    public List<Group> get() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Group> groupList = session.createQuery("from Group").list();
        System.out.println("Groups => " + groupList.toString());
        return groupList;
    }

    public void delete(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Group group = new Group();
        group.setId(id);
        session.delete(group);
    }
}
