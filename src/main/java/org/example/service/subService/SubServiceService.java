package org.example.service.subService;

import org.example.base.service.BaseService;
import org.example.model.Service;
import org.example.model.SubService;
import org.example.repository.subService.SubServiceRepository;

import java.util.List;
import java.util.Optional;

public interface SubServiceService extends BaseService<SubService,Long>  {
    Optional<SubService> searchWithName(String name);
    List<SubService> searchWithIdService(Service service);
}
