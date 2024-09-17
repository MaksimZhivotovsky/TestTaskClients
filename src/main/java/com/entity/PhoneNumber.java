package com.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString(of = {"phoneNumber"})
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "phone_numbers")
public class PhoneNumber extends Contact {

    @Column(name = "phone_number")
    private String phoneNumber;

}
