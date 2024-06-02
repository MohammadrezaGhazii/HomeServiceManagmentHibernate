package org.example.service.specialist;

import org.example.base.exception.NotFoundExeption;
import org.example.base.service.BaseServiceImpl;
import org.example.conncetion.SessionFactorySingleton;
import org.example.model.Admin;
import org.example.model.Client;
import org.example.model.Specialist;
import org.example.repository.service.ServiceRepository;
import org.example.repository.specialist.SpecialistRepository;
import org.example.service.admin.AdminServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class SpecialistServiceImpl extends BaseServiceImpl<Specialist, Long, SpecialistRepository>
        implements SpecialistService {
    public SpecialistServiceImpl(SpecialistRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
    private final SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
    private final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
    @Override
    public Optional<Specialist> searchWithEmail(String email) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Optional<Specialist> find = repository.searchWithEmail(email);
            find.orElseThrow(() -> new NotFoundExeption("Entity not found"));
            session.getTransaction().commit();
            return find;
        }
        catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Specialist> specialistSignIn(String email, String password) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Optional<Specialist> find = repository.specialistSignIn(email, password);
            find.orElseThrow(() -> new NotFoundExeption("Entity not found"));
            session.getTransaction().commit();
            return find;
        } catch (Exception e) {
            logger.error("An error occurred during admin SignIn", e);
            return Optional.empty();
        }
    }
}
