package org.example.service.specialist;

import org.example.base.service.BaseService;
import org.example.model.Specialist;

import java.util.Optional;

public interface SpecialistService extends BaseService<Specialist,Long> {
    Optional<Specialist> searchWithEmail(String email);
}
