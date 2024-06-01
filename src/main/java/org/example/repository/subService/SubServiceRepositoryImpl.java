package org.example.repository.subService;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.conncetion.SessionFactorySingleton;
import org.example.model.SubService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Optional;

public class SubServiceRepositoryImpl extends BaseRepositoryImpl<SubService, Long>
        implements SubServiceRepository {
    public SubServiceRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    private final SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    @Override
    public Class<SubService> getEntityClass() {
        return SubService.class;
    }

    @Override
    public String getEntity() {
        return "sub_service";
    }


    @Override
    public Optional<SubService> searchWithName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<SubService> query = session.createQuery("FROM sub_service s WHERE s.name=:name" , SubService.class);
        query.setParameter("name" , name);

        return Optional.ofNullable(query.getSingleResult());
    }
}
