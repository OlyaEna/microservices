package com.example.docservice.service.mapper;

import com.example.docservice.model.dto.AddressDto;
import com.example.docservice.model.entity.Address;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class AddressMapper {
    private ModelMapper modelMapper;

    public Address toEntity(AddressDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Address.class);
    }

    public AddressDto toDto(Address entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, AddressDto.class);
    }

    public List<AddressDto> listToDto(List<Address> entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, new TypeToken<List<AddressDto>>() {
        }.getType());
    }

}
