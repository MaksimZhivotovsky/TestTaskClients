package com.repository;

import com.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {

    Page<Client> findAll(Pageable pageable);

    Client save(Client client);

    Client findById(Long id);
}
