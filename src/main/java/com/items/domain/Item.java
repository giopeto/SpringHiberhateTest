package com.items.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.groups.domain.Group;
import com.measures.domain.Measure;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="items")
public class Item {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    //@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="group_id")
    private Group group;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "items2measures", joinColumns = { @JoinColumn(name = "item_id") }, inverseJoinColumns = { @JoinColumn(name = "measure_id") })
    private Set<Measure> measures = new HashSet<Measure>(0);

    public Item() {}

    public Item(Long id, String name, Group group, Set<Measure> measures) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.measures = measures;
    }
    public Item(String name, Group group, Set<Measure> measures) {

        this.name = name;
        this.group = group;
        this.measures = measures;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Set<Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(Set<Measure> measures) {
        this.measures = measures;
    }
}
