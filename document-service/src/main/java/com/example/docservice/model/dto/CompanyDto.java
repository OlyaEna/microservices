package com.example.docservice.model.dto;
import com.example.docservice.model.entity.FormOwnership;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CompanyDto {
    private String id;
    private FormOwnership formOwnership;
    private AddressDto address;
    private String occupation;
    private Long personnel;
    private BigDecimal financialAmount;
}
