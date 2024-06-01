package org.example.repository.subService;

import org.example.base.repository.BaseRepository;
import org.example.model.SubService;

import java.util.Optional;

public interface SubServiceRepository extends BaseRepository<SubService,Long> {
    Optional<SubService> searchWithName (String name);
}
