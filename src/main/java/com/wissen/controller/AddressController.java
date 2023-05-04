package com.wissen.controller;

import com.wissen.dto.AddressDTO;
import com.wissen.entity.Address;
import com.wissen.enums.AddressType;
import com.wissen.service.AddressService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/address")
@Slf4j
@Validated
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * API to Update Address of an employee
     * @author Anushka Saxena
     * @description Method to update Address.
     * @param addressDTOList
     * @return List of Address
     */
    @PutMapping
    @ApiOperation("Update address of an employee")
    public ResponseEntity<List<Address>> updateAddress(@RequestBody @NotNull(message = "List of address cannot be empty")List<AddressDTO> addressDTOList){
        log.debug("Update address of an employee");
        List<Address> updatedAddressList = this.addressService.updateAddress(addressDTOList);
        log.debug("Update address response {}", updatedAddressList);
        return ResponseEntity.status(HttpStatus.OK).body(updatedAddressList);
    }

    /**
     * API to fetch the Employee Address based on ID
     * author Vishal Tomar
     * @param wissenId
     * @return
     */
    @GetMapping
    @ApiOperation("Get present and permanent address of an employee based on Employee ID")
    public ResponseEntity<List<Address>> getAddressesByEmployeeId(
            @RequestParam @NotNull(message = "Wissen id is null") String wissenId) {
        log.debug("Getting address for wissen_id {}", wissenId);
        List<Address> empAddressList = this.addressService.getAddressByWissenId(wissenId);
        log.debug("Employee address response {}", empAddressList);
        return ResponseEntity.status(HttpStatus.OK).body(empAddressList);
    }

    /**
     * @author Anushka Saxena
     * @description Method to fetch AddressType.
     * @return Enum AddressType
     */
    @GetMapping("/addressType")
    public ResponseEntity<AddressType[]> getAddressType(){
        return ResponseEntity.status(HttpStatus.OK).body(AddressType.values());
    }

}
