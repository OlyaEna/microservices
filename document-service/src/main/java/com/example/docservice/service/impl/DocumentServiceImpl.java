package com.example.docservice.service.impl;


import com.example.docservice.exceptions.SameIdInFiveMinutes;
import com.example.docservice.model.dto.DocumentDto;
import com.example.docservice.model.dto.DocumentRequest;
import com.example.docservice.model.repository.DocumentRepository;
import com.example.docservice.schema.Company;
import com.example.docservice.schema.Document;
import com.example.docservice.service.CompanyService;
import com.example.docservice.service.DocumentService;
import com.example.docservice.service.mapper.DocumentMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@AllArgsConstructor
@Slf4j
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;
    private final CompanyService companyService;

    @Override
    public List<DocumentDto> findAll() {
        return documentMapper.listToDto(documentRepository.findAll());
    }

    @Override
    public DocumentDto save(DocumentRequest dto) {
        DocumentDto documentDto = new DocumentDto();
        documentDto.setDocumentId(dto.getDocumentId());
        documentDto.setCompany(companyService.findById(dto.getCompanyId()));
        documentDto.setCreatedAt(LocalDateTime.now());
        documentDto.setBankDetails(dto.getBankDetails());
        return create(documentDto);

    }

    private DocumentDto create(DocumentDto dto) {
        return documentMapper.toDto(documentRepository.save(documentMapper.toEntity(dto)));
    }

    @Override
    public void delete(String id) {
        documentRepository.deleteById(id);
    }

    @Override
    public DocumentDto update(DocumentRequest dto) {
        DocumentDto documentDto = findById(dto.getId());
        if (documentDto != null) {
            documentDto.setDocumentId(dto.getDocumentId());
            documentDto.setCompany(companyService.findById(dto.getCompanyId()));
            documentDto.setBankDetails(dto.getBankDetails());
            create(documentDto);
        }
        return documentDto;
    }

    @Override
    public DocumentDto findById(String id) {
        return documentMapper.toDto(documentRepository.getById(id));
    }

    @Override
    public void transferFromAvro(Document document) {
        DocumentRequest dto = new DocumentRequest();
        boolean ifSave = timeDifference(document);
        if (ifSave) {
            dto.setDocumentId(document.getDocumentId().toString());
            dto.setBankDetails(document.getBankDetails().toString());
            dto.setCompanyId(document.getCompanyId().toString());
            save(dto);
        } else {
            throw new SameIdInFiveMinutes("Document with id  {}" + document.getDocumentId() + " has already been added within five minutes");
        }
    }

    public boolean timeDifference(Document document) {
        com.example.docservice.model.entity.Document doc = documentRepository.
                findFirstByDocumentIdOrderByCreatedAtDesc(document.getDocumentId().toString());
        long seconds = 0;
        boolean check = false;
        if (doc != null) {
            LocalDateTime end = doc.getCreatedAt();
            LocalDateTime localDateTimeEnd = LocalDateTime.parse(end.truncatedTo(ChronoUnit.SECONDS).toString());
            LocalDateTime localDateTimeStart = LocalDateTime.parse(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).toString());

            Duration duration = Duration.between(localDateTimeStart, localDateTimeEnd);
            seconds = (duration.getSeconds() / 60);
            if (seconds > 5) {
                check = true;
            }
        }
        return check;
    }


}
