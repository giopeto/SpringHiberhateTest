package com.items.domain;

import com.groups.domain.Group;
import com.measures.domain.Measure;

import javax.persistence.*;

@Entity
@Table(name="items")
public class Item {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    //@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name="group_id")
    private Group group;
    @ManyToOne
    @JoinColumn(name="measure_id")
    private Measure measures;

    public Item() {}

    public Item(Long id, String name, Group group, Measure measures) {
        this.id = id;
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

    public Measure getMeasures() {
        return measures;
    }

    public void setMeasures(Measure measures) {
        this.measures = measures;
    }
}
