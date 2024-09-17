package com.repository;

import com.entity.EmailAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmailAddressRepository extends PagingAndSortingRepository<EmailAddress, Long> {

    Page<EmailAddress> findAllByClientId(Long clientId, Pageable pageable);

    void save(EmailAddress emailAddress);
}
