package com.hermes.core.infrastructure.dataaccess.services;


import com.hermes.core.domain.AbstractPersistentObject;
import com.hermes.core.infrastructure.dataaccess.specifications.Specification;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.UUID;

public class GenericRepositoryImpl<T extends AbstractPersistentObject> implements GenericRepository<T> {

    protected final Class<? extends T> repositoryType;

    private final SessionFactory sessionFactory;

    public GenericRepositoryImpl(Class<? extends T> repositoryType, SessionFactory sessionFactory) {
        this.repositoryType = repositoryType;
        this.sessionFactory = sessionFactory;
    }

    public Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(T entity) {
//        System.out.println("Saving: "+repositoryType+" "+entity.getId()+" "+entity.getVersion());
        currentSession().save(entity);
//        System.out.println("Saved: "+repositoryType+" "+entity.getId()+" "+entity.getVersion());
    }

    @Override
    public void saveOrUpdate(T entity) {
        currentSession().saveOrUpdate(entity);
    }

    @Override
    public void update(T entity) {
//        System.out.println("Updating: "+repositoryType+" "+entity.getId()+" "+entity.getVersion());
        currentSession().saveOrUpdate(entity);
//        System.out.println("Updateded: "+repositoryType+" "+entity.getId()+" "+entity.getVersion());
    }

    @Override
    public void remove(T entity) {
        currentSession().delete(entity);
    }

    @Override
    public T find(UUID key) {
        Criteria criteria = currentSession().createCriteria(repositoryType);
        criteria.add(Restrictions.eq("id", key));
        //criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return repositoryType.cast(criteria.list().get(0));
    }

    @Override
    public <T> List findAllBySpecification(Specification<T>...specification) {
        Criteria criteria = currentSession().createCriteria(repositoryType);
        for(Specification<T> detail : specification) {
            criteria.add(detail.toCriterion());
        }
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }

    @Override
    public List<T> getAll() {
        Criteria criteria = currentSession().createCriteria(repositoryType);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }
}