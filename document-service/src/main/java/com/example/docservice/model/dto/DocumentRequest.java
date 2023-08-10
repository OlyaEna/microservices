package com.example.docservice.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class DocumentRequest {
    private String id;
    private String documentId;
    private String companyId;
    private String bankDetails;
    private LocalDateTime createdAt;
}
