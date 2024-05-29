package org.example.service.admin;

import org.example.base.service.BaseServiceImpl;
import org.example.model.Admin;
import org.example.repository.admin.AdminRepository;
import org.hibernate.SessionFactory;

public class AdminServiceImpl extends BaseServiceImpl<Admin,Long, AdminRepository>
        implements AdminService{
    public AdminServiceImpl(AdminRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}
