package org.example.repository.client;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.model.Client;
import org.hibernate.SessionFactory;

public class ClientRepositoryImpl extends BaseRepositoryImpl<Client,Long>
        implements ClientRepository {
    public ClientRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Client> getEntityClass() {
        return Client.class;
    }

    @Override
    public String getEntity() {
        return "Client";
    }
}
