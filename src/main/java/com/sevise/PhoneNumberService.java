package com.sevise;

import com.dto.PhoneNumberDto;

import java.util.List;

public interface PhoneNumberService {

    PhoneNumberDto createPhoneNumber(Long clientId, PhoneNumberDto phoneNumberDto);

    List<PhoneNumberDto> getAllByClientId(Long clientId, Integer offset, Integer limit);
}
