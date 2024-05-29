package org.example.service.subService;

import org.example.base.service.BaseServiceImpl;
import org.example.model.SubService;
import org.example.repository.subService.SubServiceRepository;
import org.hibernate.SessionFactory;

public class SubServiceServiceImpl extends BaseServiceImpl<SubService,Long, SubServiceRepository>
        implements SubServiceService {
    public SubServiceServiceImpl(SubServiceRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}
