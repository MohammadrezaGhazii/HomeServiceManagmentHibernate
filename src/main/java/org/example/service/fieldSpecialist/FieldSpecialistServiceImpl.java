package org.example.service.fieldSpecialist;

import org.example.base.service.BaseServiceImpl;
import org.example.model.FieldSpecialist;
import org.example.repository.fieldSpecialist.FieldSpecialistRepository;
import org.hibernate.SessionFactory;

public class FieldSpecialistServiceImpl extends BaseServiceImpl<FieldSpecialist,Long, FieldSpecialistRepository>
        implements FieldSpecialistService {
    public FieldSpecialistServiceImpl(FieldSpecialistRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}
