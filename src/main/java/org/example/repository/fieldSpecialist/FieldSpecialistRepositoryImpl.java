package org.example.repository.fieldSpecialist;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.model.FieldSpecialist;
import org.hibernate.SessionFactory;

public class FieldSpecialistRepositoryImpl extends BaseRepositoryImpl<FieldSpecialist,Long>
        implements FieldSpecialistRepository{
    public FieldSpecialistRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<FieldSpecialist> getEntityClass() {
        return FieldSpecialist.class;
    }

    @Override
    public String getEntity() {
        return "field_specialist";
    }
}
