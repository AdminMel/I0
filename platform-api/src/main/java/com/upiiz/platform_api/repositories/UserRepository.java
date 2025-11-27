package com.upiiz.platform_api.repositories;

import com.upiiz.platform_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmailInst(String emailInst);
    Optional<User> findByExternalId(String externalId);
}
