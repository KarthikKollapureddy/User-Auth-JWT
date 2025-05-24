package com.security.userauthservice.dao;

import com.security.userauthservice.entity.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends MongoRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
}
