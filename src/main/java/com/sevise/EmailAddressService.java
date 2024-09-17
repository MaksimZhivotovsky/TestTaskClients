package com.sevise;

import com.dto.EmailAddressDto;

import java.util.List;

public interface EmailAddressService {

    EmailAddressDto createEmailAddress(Long clientId, EmailAddressDto emailAddressDto);

    List<EmailAddressDto> getAllByClientId(Long clientId, Integer offset, Integer limit);
}
