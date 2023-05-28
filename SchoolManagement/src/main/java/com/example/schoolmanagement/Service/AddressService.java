package com.example.schoolmanagement.Service;

import com.example.schoolmanagement.ApiException.ApiException;
import com.example.schoolmanagement.Model.Address;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Repository.AddressRepository;
import com.example.schoolmanagement.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@RequiredArgsConstructor
@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public void add(AddressDto dto, Errors errors) {
        if (errors.hasErrors())
            throw new ApiException(errors.getFieldError().getDefaultMessage());

        Teacher findTeacher = teacherRepository.findById(dto.getTeacherId()).orElseThrow(() -> new ApiException("id not found"));

        Address address = new Address(findTeacher.getId(), dto.getArea(), dto.getStreet(), dto.getBuildingNumber(), findTeacher);

        addressRepository.save(address);
    }

    public void update(int id, AddressUpdateDto dto, Errors errors) {
        if (errors.hasErrors())
            throw new ApiException(errors.getFieldError().getDefaultMessage());

        Address address = addressRepository.findById(id).orElseThrow(() -> new ApiException("id not found"));

        address.setArea(dto.getArea());
        address.setStreet(dto.getStreet());
        address.setBuildingNumber(dto.getBuildingNumber());
        addressRepository.save(address);
    }

    public void delete(int id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new ApiException("id not found"));
        addressRepository.delete(address);
    }
}