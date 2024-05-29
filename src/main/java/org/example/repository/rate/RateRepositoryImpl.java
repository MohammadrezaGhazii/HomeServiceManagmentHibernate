package org.example.repository.rate;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.model.Rate;
import org.hibernate.SessionFactory;

public class RateRepositoryImpl extends BaseRepositoryImpl<Rate,Long> implements RateRepository{
    public RateRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Rate> getEntityClass() {
        return Rate.class;
    }

    @Override
    public String getEntity() {
        return "Rate";
    }
}
