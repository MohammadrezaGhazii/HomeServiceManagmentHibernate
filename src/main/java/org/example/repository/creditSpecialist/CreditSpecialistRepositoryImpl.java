package org.example.repository.creditSpecialist;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.model.CreditSpecialist;
import org.hibernate.SessionFactory;

public class CreditSpecialistRepositoryImpl extends BaseRepositoryImpl<CreditSpecialist, Long>
        implements CreditSpecialistRepository {
    public CreditSpecialistRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<CreditSpecialist> getEntityClass() {
        return CreditSpecialist.class;
    }

    @Override
    public String getEntity() {
        return "CreditSpecialist";
    }
}
