package com.firozkhan.ecommerce.application.repository.implement;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.firozkhan.ecommerce.application.repository.jpa.JpaUserRepository;
import com.firozkhan.ecommerce.model.entity.User;
import com.firozkhan.ecommerce.model.repository.UserRepository;

@Repository
public class UserRepositoryImp implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    public UserRepositoryImp(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public Optional<User> findByEmailIgnoreCase(String email) {
        return jpaUserRepository.findByEmailIgnoreCase(email);
    }

    @Override
    public Optional<User> findByPhone(String phone) {
        return jpaUserRepository.findByPhone(phone);
    }

    @Override
    public boolean existsByEmailIgnoreCase(String email) {
        return jpaUserRepository.existsByEmailIgnoreCase(email);
    }

    @Override
    public boolean existsByPhone(String phone) {
        return jpaUserRepository.existsByPhone(phone);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return jpaUserRepository.findById(id);
    }

    @Override
    public User save(User user) {
       return jpaUserRepository.save(user);
    }

    @Override
    public Optional<User> findByIdentifier(String identifier) {
        return jpaUserRepository.findByIdentifier(identifier);
    }

    @Override
    public boolean existsById(UUID id) {
        return jpaUserRepository.existsById(id);
    }

    
}
