package org.example.service.creditSpecialist;

import org.example.base.service.BaseServiceImpl;
import org.example.model.CreditSpecialist;
import org.example.repository.creditSpecialist.CreditSpecialistRepository;
import org.hibernate.SessionFactory;

public class CreditSpecialistServiceImpl extends BaseServiceImpl<CreditSpecialist,Long, CreditSpecialistRepository>
        implements CreditSpecialistService {
    public CreditSpecialistServiceImpl(CreditSpecialistRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}
