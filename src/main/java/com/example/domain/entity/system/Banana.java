package com.example.domain.entity.system;

import com.example.domain.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Banana extends AbstractEntity {

    private Double juicy;

    @ManyToOne
    private Minion minion;

    public Double getJuicy() {
        return juicy;
    }

    public void setJuicy(Double juicy) {
        this.juicy = juicy;
    }

    public Minion getMinion() {
        return minion;
    }

    public void setMinion(Minion minion) {
        this.minion = minion;
    }
}
