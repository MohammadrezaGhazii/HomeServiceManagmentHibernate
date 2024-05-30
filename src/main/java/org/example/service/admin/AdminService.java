package org.example.service.admin;

import org.example.base.service.BaseService;
import org.example.model.Admin;

import java.util.Optional;

public interface AdminService extends BaseService<Admin,Long> {
    Optional<Admin> adminSignIn(String email , String password);
}
