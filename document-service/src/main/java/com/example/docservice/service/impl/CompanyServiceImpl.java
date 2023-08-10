package com.example.docservice.service.impl;


import com.example.docservice.model.dto.CompanyDto;
import com.example.docservice.model.dto.CompanyRequest;
import com.example.docservice.model.repository.CompanyRepository;
import com.example.docservice.schema.Company;
import com.example.docservice.service.CompanyService;
import com.example.docservice.service.AddressService;
import com.example.docservice.service.mapper.CompanyMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final AddressService addressService;


    @Override
    public List<CompanyDto> findAll() {
        return companyMapper.listToDto(companyRepository.findAll());
    }

    @Override
    public CompanyDto save(CompanyRequest dto) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setPersonnel(dto.getPersonnel());
        companyDto.setOccupation(dto.getOccupation());
        companyDto.setFormOwnership(dto.getFormOwnership());
        companyDto.setFinancialAmount(dto.getFinancialAmount());
        companyDto.setAddress(addressService.findById(dto.getAddressId()));
        return create(companyDto);
    }

    private CompanyDto create(CompanyDto dto) {
        return companyMapper.toDto(companyRepository.save(companyMapper.toEntity(dto)));
    }

    @Override
    public void delete(String id) {
        companyRepository.deleteById(id);
    }

    @Override
    public CompanyDto update(CompanyRequest dto) {
        CompanyDto companyDto = findById(dto.getId());
        if (companyDto != null) {
            companyDto.setPersonnel(dto.getPersonnel());
            companyDto.setOccupation(dto.getOccupation());
            companyDto.setFormOwnership(dto.getFormOwnership());
            companyDto.setFinancialAmount(dto.getFinancialAmount());
            companyDto.setAddress(addressService.findById(dto.getAddressId()));
            create(companyDto);
        }
        return companyDto;
    }

    @Override
    public CompanyDto findById(String id) {
        return companyMapper.toDto(companyRepository.getById(id));
    }

    @Override
    public void transferFromAvro(Company company) {
        CompanyRequest dto = new CompanyRequest();
        dto.setAddressId(company.getAddressId().toString());
        dto.setPersonnel( company.getPersonnel());
        dto.setOccupation(company.getOccupation().toString());
        BigDecimal bigDecimal = new BigDecimal(company.getFinancialAmount().toString());
        dto.setFinancialAmount(bigDecimal);
        save(dto);
    }

}
