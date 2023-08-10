package com.example.docservice.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddressDto {
    private String  id;
    private String country;
    private String city;
    private String streetName;
    private String streetNumber;
    private String postCode;
}
