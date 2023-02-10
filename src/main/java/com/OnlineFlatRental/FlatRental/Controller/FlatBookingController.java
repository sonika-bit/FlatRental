package com.OnlineFlatRental.FlatRental.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineFlatRental.FlatRental.DTO.FlatBookingDTO;
import com.OnlineFlatRental.FlatRental.DTO.FlatDTO;
import com.OnlineFlatRental.FlatRental.DTO.TenantDTO;
import com.OnlineFlatRental.FlatRental.Exception.FlatBookingNotFoundException;
import com.OnlineFlatRental.FlatRental.Exception.FlatNotFoundException;
import com.OnlineFlatRental.FlatRental.Exception.TenantNotFoundException;
import com.OnlineFlatRental.FlatRental.Service.FlatBookingService;
import com.OnlineFlatRental.FlatRental.Service.FlatService;
import com.OnlineFlatRental.FlatRental.Service.IFlatBookingService;
import com.OnlineFlatRental.FlatRental.Service.ITenantService;
import com.OnlineFlatRental.FlatRental.Service.TenantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/flatbooking")
public class FlatBookingController {

    @Autowired
    private FlatBookingService flatbookingService;

    @Autowired
    private TenantService tenantService;

    @Autowired
    FlatService flatService;

    
    // Add FlatBooking Details
    @PostMapping("/addflatbooking")
    public ResponseEntity<String> addFlatBooking(@Valid @RequestBody FlatBookingDTO flat) throws TenantNotFoundException , FlatNotFoundException{
        FlatBookingDTO fb = flatbookingService.addFlatBooking(flat);
        return new ResponseEntity<String>("FlatBooking created sucessfully.",HttpStatus.CREATED);
    }
        
    
    // View All FlatBooking Details
    @GetMapping("/viewAllFlatBooking")
    public ResponseEntity<List<FlatBookingDTO>> viewAllFlatBooking() {
        List<FlatBookingDTO> list=flatbookingService.viewAllFlatBooking();
        return new ResponseEntity<List<FlatBookingDTO>>(list,HttpStatus.OK);
    }
    
    // View FlatBooking Details By Id
    @GetMapping("/viewflatbooking/{id}")
    public ResponseEntity<FlatBookingDTO> viewFlatBooking(@PathVariable int id) throws FlatBookingNotFoundException {
        FlatBookingDTO fb=flatbookingService.viewFlatBooking(id);
        return new ResponseEntity<FlatBookingDTO>(fb,HttpStatus.OK);
    }

    
    // Delete FlatBooking Details By Id
    @DeleteMapping("/deleteflatbooking/{id}")
    public ResponseEntity<String> deleteFlatBooking(@PathVariable int id) throws FlatBookingNotFoundException{
        flatbookingService.deleteFlatBooking(id);
        return new ResponseEntity<String>("FlatBooking with Booking No: "+id+" sucessfully deleted.",HttpStatus.OK);
    }

    
    // Update FlatBooking Details By Id
    @PutMapping("/updateflatbooking/{id}")
    public ResponseEntity<FlatBookingDTO> updateFlatBooking(@Valid @RequestBody FlatBookingDTO flatbooking,@PathVariable int id) throws FlatBookingNotFoundException, TenantNotFoundException, FlatNotFoundException {
        FlatBookingDTO fb = flatbookingService.updateFlatBooking(flatbooking,id);
        TenantDTO t = tenantService.updateTenant(fb.getTenantId().getTenantId(), fb.getTenantId());
        FlatDTO f = flatService.updateFlat(fb.getFlat(),fb.getFlat().getFlatId());
        return new ResponseEntity<FlatBookingDTO>(fb,HttpStatus.ACCEPTED);
    }
}
