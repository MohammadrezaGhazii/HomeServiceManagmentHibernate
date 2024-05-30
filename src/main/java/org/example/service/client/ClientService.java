package org.example.service.client;

import org.example.base.service.BaseService;
import org.example.model.Client;

import java.util.Optional;

public interface ClientService extends BaseService<Client,Long> {
    Optional<Client> searchWithEmail (String email);
    Optional<Client> clientSignIn(String email , String password);
}
