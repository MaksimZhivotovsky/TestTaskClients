package com.sevise;

import com.dto.ClientDto;
import com.dto.ContactDto;

import java.util.List;

public interface ClientService {

    ClientDto createClient(ClientDto clientDto);

    List<ClientDto> getAllClients(Integer offset, Integer limit);

    ClientDto getById(Long id);

    List<ContactDto> getAllContactByClientId(Long id);
}
