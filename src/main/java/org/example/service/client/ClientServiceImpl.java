package org.example.service.client;

import org.example.base.service.BaseServiceImpl;
import org.example.model.Client;
import org.example.repository.client.ClientRepository;
import org.hibernate.SessionFactory;

public class ClientServiceImpl extends BaseServiceImpl<Client,Long, ClientRepository>
        implements ClientService {
    public ClientServiceImpl(ClientRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}
