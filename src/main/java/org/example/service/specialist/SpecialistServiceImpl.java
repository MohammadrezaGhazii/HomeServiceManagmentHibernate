package org.example.service.specialist;

import org.example.base.service.BaseServiceImpl;
import org.example.model.Specialist;
import org.example.repository.service.ServiceRepository;
import org.example.repository.specialist.SpecialistRepository;
import org.hibernate.SessionFactory;

public class SpecialistServiceImpl extends BaseServiceImpl<Specialist, Long, SpecialistRepository>
        implements SpecialistService {
    public SpecialistServiceImpl(SpecialistRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}
