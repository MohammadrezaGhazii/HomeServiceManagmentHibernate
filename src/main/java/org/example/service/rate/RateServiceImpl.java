package org.example.service.rate;

import org.example.base.service.BaseServiceImpl;
import org.example.model.Rate;
import org.example.repository.rate.RateRepository;
import org.hibernate.SessionFactory;

public class RateServiceImpl extends BaseServiceImpl<Rate,Long, RateRepository>
        implements RateService{
    public RateServiceImpl(RateRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}
