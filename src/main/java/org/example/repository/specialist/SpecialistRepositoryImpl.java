package org.example.repository.specialist;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.model.Specialist;
import org.hibernate.SessionFactory;

public class SpecialistRepositoryImpl extends BaseRepositoryImpl<Specialist,Long> implements SpecialistRepository {
    public SpecialistRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Specialist> getEntityClass() {
        return Specialist.class;
    }

    @Override
    public String getEntity() {
        return "Specialist";
    }
}
