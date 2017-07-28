package com.example.mapper;

import com.example.domain.entity.AbstractEntity;
import com.example.dto.Reference;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Objects;
import java.util.Optional;


@Component
public class ReferenceMapper {

    @PersistenceContext
    private EntityManager entityManager;

    public <T extends AbstractEntity> T resolve(final Reference reference, @TargetType final Class<T> entityClass) {
        if (Objects.nonNull(reference)) {
            final Optional<T> entityOptional = Optional.ofNullable(entityManager.find(entityClass, reference.getId()));

            return entityOptional.orElseThrow(() -> new RuntimeException(entityClass.getSimpleName() + " with id " + reference.getId() + " not found."));
        }

        return null;
    }

    public Reference toReference(final AbstractEntity entity) {
        if (Objects.nonNull(entity)) {
            final Reference reference = new Reference();

            reference.setId(entity.getId());

            return reference;
        }

        return null;
    }
}
