package org.example.repository.specialist;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.conncetion.SessionFactorySingleton;
import org.example.model.Admin;
import org.example.model.Client;
import org.example.model.Specialist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Optional;

public class SpecialistRepositoryImpl extends BaseRepositoryImpl<Specialist, Long> implements SpecialistRepository {
    public SpecialistRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    private final SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    @Override
    public Class<Specialist> getEntityClass() {
        return Specialist.class;
    }

    @Override
    public String getEntity() {
        return "Specialist";
    }

    @Override
    public Optional<Specialist> searchWithEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query<Specialist> query = session.createQuery("FROM specialist s WHERE s.email=:email"
                , Specialist.class);
        query.setParameter("email", email);

        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public Optional<Specialist> specialistSignIn(String email, String password) {
        Session session = sessionFactory.getCurrentSession();
        Query<Specialist> query = session.createQuery("FROM specialist s " +
                "WHERE s.email=:email AND s.password=:password", Specialist.class);
        query.setParameter("email", email);
        query.setParameter("password", password);

        return Optional.ofNullable(query.getSingleResult());
    }
}
