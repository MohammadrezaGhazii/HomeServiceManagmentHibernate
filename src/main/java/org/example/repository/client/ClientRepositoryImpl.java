package org.example.repository.client;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.conncetion.SessionFactorySingleton;
import org.example.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Optional;

public class ClientRepositoryImpl extends BaseRepositoryImpl<Client,Long>
        implements ClientRepository {
    public ClientRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    private final SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    @Override
    public Class<Client> getEntityClass() {
        return Client.class;
    }

    @Override
    public String getEntity() {
        return "Client";
    }


    @Override
    public Optional<Client> searchWithEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query<Client> query = session.createQuery("FROM client c WHERE c.email=:email" , Client.class);
        query.setParameter("email",email);

        return Optional.ofNullable(query.getSingleResult());
    }
}
