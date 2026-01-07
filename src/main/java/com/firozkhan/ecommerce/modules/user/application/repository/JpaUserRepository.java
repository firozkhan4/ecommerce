package com.firozkhan.ecommerce.modules.user.application.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firozkhan.ecommerce.modules.user.domain.entity.User;

public interface JpaUserRepository extends JpaRepository<User,UUID> {

}
