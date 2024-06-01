package org.example.service.subService;

import org.example.base.exception.NotFoundExeption;
import org.example.base.service.BaseServiceImpl;
import org.example.conncetion.SessionFactorySingleton;
import org.example.model.Client;
import org.example.model.SubService;
import org.example.repository.subService.SubServiceRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Optional;

public class SubServiceServiceImpl extends BaseServiceImpl<SubService,Long, SubServiceRepository>
        implements SubServiceService {
    public SubServiceServiceImpl(SubServiceRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
    private final SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    @Override
    public Optional<SubService> searchWithName(String name) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Optional<SubService> find = repository.searchWithName(name);
            find.orElseThrow(() -> new NotFoundExeption("Entity not found"));
            session.getTransaction().commit();
            return find;
        }
        catch (Exception e) {
            return Optional.empty();
        }
    }
}
