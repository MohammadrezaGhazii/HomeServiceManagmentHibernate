package org.example.service.creditClient;

import org.example.base.service.BaseServiceImpl;
import org.example.model.CreditClient;
import org.example.repository.creditClient.CreditClientRepository;
import org.hibernate.SessionFactory;

public class CreditClientServiceImpl extends BaseServiceImpl<CreditClient,Long, CreditClientRepository>
        implements CreditClientService {
    public CreditClientServiceImpl(CreditClientRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}
