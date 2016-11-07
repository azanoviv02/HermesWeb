package com.hermes.hermes.infrastructure.dataaccess.services;

import com.hermes.hermes.domain.AbstractPersistentObject;
import com.hermes.hermes.infrastructure.dataaccess.specifications.Specification;

import java.util.List;
import java.util.UUID;

public interface GenericRepository<T extends AbstractPersistentObject> {

    public void add(T entity) ;

    public void saveOrUpdate(T entity) ;

    public void update(T entity) ;

    public void remove(T entity);

    public T find(UUID key);

    public <T> List findAllBySpecification(Specification<T>... specification);

    public List<T> getAll() ;
}
