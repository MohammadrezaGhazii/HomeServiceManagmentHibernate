package org.example.service.client;

import org.example.base.exception.NotFoundExeption;
import org.example.base.service.BaseServiceImpl;
import org.example.conncetion.SessionFactorySingleton;
import org.example.model.Client;
import org.example.repository.client.ClientRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class ClientServiceImpl extends BaseServiceImpl<Client,Long, ClientRepository>
        implements ClientService {
    public ClientServiceImpl(ClientRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
    private final SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
    private final Logger logger = LoggerFactory.getLogger(Client.class);

    @Override
    public Optional<Client> searchWithEmail(String email) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Optional<Client> find = repository.searchWithEmail(email);
            find.orElseThrow(() -> new NotFoundExeption("Entity not found"));
            session.getTransaction().commit();
            return find;
        }
        catch (Exception e) {
//            logger.error("An error occurred during search", e);
            return Optional.empty();
        }
    }
}
