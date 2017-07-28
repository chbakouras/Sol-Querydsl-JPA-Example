package com.example.domain.entity.system;

import com.example.domain.entity.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Minion extends AbstractEntity {

    private String name;

    private Integer despicability;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDespicability() {
        return despicability;
    }

    public void setDespicability(Integer despicability) {
        this.despicability = despicability;
    }
}
