package com.example.dto.system;

import com.example.dto.AbstractDto;

public class MinionDto extends AbstractDto {

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
