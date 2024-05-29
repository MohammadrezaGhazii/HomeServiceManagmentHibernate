package org.example.repository.creditClient;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.model.CreditClient;
import org.hibernate.SessionFactory;

public class CreditClientRepositoryImp extends BaseRepositoryImpl<CreditClient,Long>
        implements CreditClientRepository{
    public CreditClientRepositoryImp(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<CreditClient> getEntityClass() {
        return CreditClient.class;
    }

    @Override
    public String getEntity() {
        return "CreditClient";
    }
}
