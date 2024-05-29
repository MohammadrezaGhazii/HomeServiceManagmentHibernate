package org.example.repository.admin;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.model.Admin;
import org.hibernate.SessionFactory;

public class AdminRepositoryImpl extends BaseRepositoryImpl<Admin,Long>
        implements AdminRepository{
    public AdminRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }

    @Override
    public String getEntity() {
        return "Admin";
    }
}
