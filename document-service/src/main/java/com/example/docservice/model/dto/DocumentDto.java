package com.example.docservice.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DocumentDto {
    private String id;
    private String documentId;
    private CompanyDto company;
    private String bankDetails;
    private LocalDateTime createdAt;
}
