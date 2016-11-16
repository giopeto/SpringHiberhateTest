package com.items.service;

import com.groups.domain.Group;
import com.items.domain.Item;
import com.measures.domain.Measure;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Item save(Item i) {
        Session session = this.sessionFactory.getCurrentSession();
        /*for(int y=0;y<=10000; y++) { //Test 10 000 records
            Item i2 = new Item(i.getName(), i.getGroup(), i.getMeasures());
            session.saveOrUpdate(i2);
        }*/
        session.saveOrUpdate(i);
        return i;
    }

    public List<Item> get() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Item> itemList = session.createQuery("from Item").list();
        System.out.println("Items => " + itemList.toString() + "\n\n\n\n\n\n\n\n\n\n\n\n\n");
        return itemList;
    }

    public void delete(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Item item = new Item();
        item.setId(id);
        session.delete(item);
    }
}
