package com.example.docservice.model.dto;

import com.example.docservice.model.entity.FormOwnership;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class CompanyRequest {
    private String id;
    private FormOwnership formOwnership;
    private String addressId;
    private String occupation;
    private Long personnel;
    private BigDecimal financialAmount;
}
