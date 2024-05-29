package org.example.service.service;

import org.example.base.service.BaseServiceImpl;
import org.example.model.Service;
import org.example.repository.service.ServiceRepository;
import org.hibernate.SessionFactory;

public class ServiceServiceImpl extends BaseServiceImpl<Service,Long, ServiceRepository>
        implements ServiceService {
    public ServiceServiceImpl(ServiceRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}
