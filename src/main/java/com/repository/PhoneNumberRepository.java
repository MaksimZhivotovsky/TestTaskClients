package com.repository;

import com.entity.PhoneNumber;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PhoneNumberRepository extends PagingAndSortingRepository<PhoneNumber, Long> {

    Page<PhoneNumber> findAllByClientId(Long clientId, Pageable pageable);

    void save(PhoneNumber phoneNumber);
}
