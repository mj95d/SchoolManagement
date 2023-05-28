package com.example.schoolmanagement.Controller;

import com.example.schoolmanagement.ApiResponse.ApiResponse;
import com.example.schoolmanagement.Model.Address;
import com.example.schoolmanagement.Service.AddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/api/v1/teacher")
@AllArgsConstructor
public class AddressController {


        private final AddressService addressService;

        @GetMapping("/getAll")
        public ResponseEntity getAllAddress(){
            List<Address> AddressList=AddressService.getAllAddress();
            return ResponseEntity.status(200).body(AddressList);
        }


        @PostMapping("/add")
        public ResponseEntity addAddress(@Valid @RequestBody Address address){
            AddressService.addAddress(address);
            return ResponseEntity.status(200).body(new ApiResponse("Address added"));
        }

        @PutMapping("/update/{id}")
        public ResponseEntity updateAddress(@Valid @RequestBody Address address, @PathVariable Integer id){
            addressService.updateAddress(address,id);
            return ResponseEntity.status(200).body("address Updated");
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity deleteAddress(@PathVariable Integer id){
            addressService.deleteAddress(id);
            return ResponseEntity.status(200).body("address deleted");

        }
    }
