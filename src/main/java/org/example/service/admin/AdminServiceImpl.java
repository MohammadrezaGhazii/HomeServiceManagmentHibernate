package org.example.service.admin;

import org.example.base.exception.NotFoundExeption;
import org.example.base.service.BaseServiceImpl;
import org.example.conncetion.SessionFactorySingleton;
import org.example.model.Admin;
import org.example.repository.admin.AdminRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class AdminServiceImpl extends BaseServiceImpl<Admin, Long, AdminRepository>
        implements AdminService {
    public AdminServiceImpl(AdminRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    private final SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
    private final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Override
    public Optional<Admin> adminSignIn(String email, String password) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Optional<Admin> find = repository.adminSignIn(email, password);
            find.orElseThrow(() -> new NotFoundExeption("Entity not found"));
            session.getTransaction().commit();
            return find;
        } catch (Exception e) {
            logger.error("An error occurred during admin SignIn", e);
            return Optional.empty();
        }
    }
}
