package org.example.repository.specialist;

import org.example.base.repository.BaseRepository;
import org.example.enums.SpecialistSituation;
import org.example.model.Specialist;

import java.util.List;
import java.util.Optional;

public interface SpecialistRepository extends BaseRepository<Specialist,Long> {
    Optional<Specialist> searchWithEmail(String email);
    Optional<Specialist> specialistSignIn(String email, String password);
    List<Specialist> findSpecialistsBySituation (SpecialistSituation situation);
}
