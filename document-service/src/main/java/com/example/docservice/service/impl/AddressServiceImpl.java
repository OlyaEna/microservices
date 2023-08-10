package com.example.docservice.service.impl;

import com.example.docservice.model.dto.AddressDto;
import com.example.docservice.model.repository.AddressRepository;
import com.example.docservice.schema.Address;
import com.example.docservice.service.AddressService;
import com.example.docservice.service.mapper.AddressMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;


    @Override
    public List<AddressDto> findAll() {
        return addressMapper.listToDto(addressRepository.findAll());
    }

    @Override
    public AddressDto save(AddressDto addressDto) {
        return addressMapper.toDto(addressRepository.save(addressMapper.toEntity(addressDto)));
    }

    @Override
    public void delete(String id) {
        addressRepository.deleteById(id);
    }

    @Override
    public AddressDto update(AddressDto addressDto) {
        AddressDto address = findById(addressDto.getId());
        if(address != null){
            address.setCountry(addressDto.getCountry());
            address.setCity(addressDto.getCity());
            address.setStreetName(addressDto.getStreetName());
            address.setStreetNumber(addressDto.getStreetNumber());
            address.setPostCode(addressDto.getPostCode());
            save(address);
        }
        return address;
    }

    @Override
    public AddressDto findById(String id){
        return addressMapper.toDto(addressRepository.findAddressById(id));
    }

    public void transferFromAvro(Address address){
        AddressDto dto = new AddressDto();
        dto.setCity(address.getCity().toString());
        dto.setCountry(address.getCountry().toString());
        dto.setStreetName(address.getStreetName().toString());
        dto.setStreetNumber(address.getStreetName().toString());
        dto.setPostCode(address.getPostCode().toString());
        save(dto);
    }
}
