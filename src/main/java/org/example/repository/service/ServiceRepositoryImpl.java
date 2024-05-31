package org.example.repository.service;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.model.Service;
import org.hibernate.SessionFactory;

public class ServiceRepositoryImpl extends BaseRepositoryImpl<Service,Long> implements ServiceRepository {
    public ServiceRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Service> getEntityClass() {
        return Service.class;
    }

    @Override
    public String getEntity() {
        return "service";
    }
}
