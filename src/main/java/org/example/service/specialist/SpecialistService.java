package org.example.service.specialist;

import org.example.base.service.BaseService;
import org.example.enums.SpecialistSituation;
import org.example.model.Specialist;

import java.util.List;
import java.util.Optional;

public interface SpecialistService extends BaseService<Specialist,Long> {
    Optional<Specialist> searchWithEmail(String email);
    Optional<Specialist> specialistSignIn(String email, String password);
    List<Specialist> findSpecialistsBySituation (SpecialistSituation situation);
}
