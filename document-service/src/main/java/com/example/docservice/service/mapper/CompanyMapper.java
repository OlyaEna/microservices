package com.example.docservice.service.mapper;


import com.example.docservice.model.dto.CompanyDto;
import com.example.docservice.model.entity.Company;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class CompanyMapper {
    private ModelMapper modelMapper;

    public Company toEntity(CompanyDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Company.class);
    }

    public CompanyDto toDto(Company entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, CompanyDto.class);
    }

    public List<CompanyDto> listToDto(List<Company> entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, new TypeToken<List<CompanyDto>>() {
        }.getType());
    }

}
