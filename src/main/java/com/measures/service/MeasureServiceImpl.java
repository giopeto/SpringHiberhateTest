package com.measures.service;


import com.groups.domain.Group;
import com.measures.domain.Measure;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class MeasureServiceImpl implements MeasureService{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Measure save(Measure m) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(m);
        return m;
    }

    public List get() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Group> list = session.createQuery("from Measure").list();
        return list;
    }

    public void delete(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Measure m = new Measure();
        m.setId(id);
        session.delete(m);
    }
}
