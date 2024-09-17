package com.sevise.impl;

import com.dto.EmailAddressDto;
import com.entity.Client;
import com.entity.EmailAddress;
import com.mapper.EmailAddressMapper;
import com.repository.ClientRepository;
import com.repository.EmailAddressRepository;
import com.sevise.EmailAddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class EmailAddressServiceImpl implements EmailAddressService {

    private final EmailAddressRepository emailAddressRepository;
    private final ClientRepository clientRepository;

    @Override
    public EmailAddressDto createEmailAddress(Long clientId, EmailAddressDto emailAddressDto) {

        Client client = clientRepository.findById(clientId);
        EmailAddress emailAddress  = EmailAddressMapper.toEmailAddress(emailAddressDto);
        emailAddress.setClient(client);

        emailAddressRepository.save(emailAddress);
        return emailAddressDto;
    }

    @Override
    public List<EmailAddressDto> getAllByClientId(Long clientId, Integer offset, Integer limit) {

        List<EmailAddress> emailAddresses = emailAddressRepository.findAllByClientId(
                clientId, PageRequest.of(offset, limit)
        ).stream().toList();


        return emailAddresses.stream()
                .map(EmailAddressMapper::toEmailAddressDto)
                .toList();
    }
}
