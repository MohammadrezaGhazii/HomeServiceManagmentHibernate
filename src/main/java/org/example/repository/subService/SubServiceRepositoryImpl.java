package org.example.repository.subService;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.model.SubService;
import org.hibernate.SessionFactory;

public class SubServiceRepositoryImpl extends BaseRepositoryImpl<SubService, Long>
        implements SubServiceRepository {
    public SubServiceRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<SubService> getEntityClass() {
        return SubService.class;
    }

    @Override
    public String getEntity() {
        return "sub_service";
    }
}
