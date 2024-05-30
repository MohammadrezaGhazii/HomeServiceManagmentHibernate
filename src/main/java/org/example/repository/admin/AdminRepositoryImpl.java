package org.example.repository.admin;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.conncetion.SessionFactorySingleton;
import org.example.model.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Optional;

public class AdminRepositoryImpl extends BaseRepositoryImpl<Admin, Long>
        implements AdminRepository {
    public AdminRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    private final SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }

    @Override
    public String getEntity() {
        return "Admin";
    }

    @Override
    public Optional<Admin> adminSignIn(String email, String password) {
        Session session = sessionFactory.getCurrentSession();
        Query<Admin> query = session.createQuery("FROM admin a " +
                "WHERE a.email=:email AND a.password=:password", Admin.class);
        query.setParameter("email", email);
        query.setParameter("password", password);

        return Optional.ofNullable(query.getSingleResult());
    }
}
