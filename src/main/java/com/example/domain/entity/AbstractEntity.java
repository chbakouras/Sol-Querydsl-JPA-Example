package com.example.domain.entity;

import org.hibernate.annotations.GenericGenerator;
import org.intellift.sol.domain.Identifiable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Chrisostomos Bakouras.
 */
@MappedSuperclass
public class AbstractEntity implements Identifiable<String> {

    @Id
    @GeneratedValue(generator = "java-uuid")
    @GenericGenerator(name = "java-uuid", strategy = "com.example.domain.entity.generator.UUIDGenerator")
    protected String id;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
