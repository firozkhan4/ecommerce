package com.firozkhan.ecommerce.application.repository.implement;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.firozkhan.ecommerce.application.repository.jpa.JpaAddressRepository;
import com.firozkhan.ecommerce.modules.user.domain.entity.Address;
import com.firozkhan.ecommerce.modules.user.domain.repository.AddressRepository;

@Repository
public class AddressRepositoryImp implements AddressRepository {

    private final JpaAddressRepository jpaAddressRepository;

    public AddressRepositoryImp(JpaAddressRepository jpaAddressRepository) {
        this.jpaAddressRepository = jpaAddressRepository;
    }

    @Override
    public List<Address> findAllByUserId(UUID userId) {
        return jpaAddressRepository.findAllByUserId(userId);
    }

    @Override
    public Optional<Address> findByUserIdAndIsDefaultTrue(UUID userId) {
        return jpaAddressRepository.findByUserIdAndIsDefaultTrue(userId);
    }

    @Override
    public boolean existsByUserIdAndIsDefaultTrue(UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsByUserIdAndIsDefaultTrue'");
    }

    @Override
    public void deleteAllByUserId(UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllByUserId'");
    }

    @Override
    public Optional<Address> findByIdAndUserId(UUID id, UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByIdAndUserId'");
    }

}