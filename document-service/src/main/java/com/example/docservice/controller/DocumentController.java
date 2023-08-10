package com.example.docservice.controller;


import com.example.docservice.model.dto.AddressDto;
import com.example.docservice.model.dto.DocumentDto;
import com.example.docservice.model.dto.DocumentRequest;
import com.example.docservice.model.entity.Document;
import com.example.docservice.model.repository.DocumentRepository;
import com.example.docservice.service.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/document")
public class DocumentController {
    private final DocumentService documentService;
    private final DocumentRepository documentRepository;

    @GetMapping("/all")
    public List<DocumentDto> findAll() {
        return documentService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<DocumentDto> create(@RequestBody DocumentRequest documentRequest) {
        DocumentDto dto = documentService.save(documentRequest);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public DocumentDto findById(@PathVariable String id) {
        return documentService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        documentService.delete(id);
        return new ResponseEntity<>("Deleted with id { }" + id, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<DocumentDto> update(@RequestBody DocumentRequest dto) {
        DocumentDto document = documentService.update(dto);
        return new ResponseEntity<>(document, HttpStatus.OK);
    }
}
