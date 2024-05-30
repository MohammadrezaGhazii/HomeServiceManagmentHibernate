package org.example.repository.client;

import org.example.base.repository.BaseRepository;
import org.example.model.Client;

import java.util.Optional;

public interface ClientRepository extends BaseRepository<Client,Long> {
    Optional<Client> searchWithEmail (String email);
    Optional<Client> clientSignIn(String email , String password);
}
