package com.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PhoneNumberDto extends ContactDto {

    @NotNull
    @Pattern(regexp="^\\+(?:[0-9] ?){6,14}[0-9]$", message = "Неправильный номер телефона")
    private String phoneNumber;
}
