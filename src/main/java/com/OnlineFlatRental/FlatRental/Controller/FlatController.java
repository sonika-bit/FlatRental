package com.OnlineFlatRental.FlatRental.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

import com.OnlineFlatRental.FlatRental.DTO.FlatDTO;
import com.OnlineFlatRental.FlatRental.Exception.FlatNotFoundException;
import com.OnlineFlatRental.FlatRental.Service.FlatService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/flat")
public class FlatController {

    @Autowired
    private FlatService flatService;

    @Autowired
    private Environment environment;

    
   //Add Flat Details
    @PostMapping(value = "/addflat")
    public ResponseEntity<FlatDTO> addFlat(@Valid @RequestBody FlatDTO flat) {
        return new ResponseEntity<>(flatService.addFlat(flat), HttpStatus.CREATED);
    }

    //Update Flat Details By Id
    @PutMapping("/updateflat/{flatId}")
    public ResponseEntity<String> updateFlat(@Valid @RequestBody FlatDTO flat, @PathVariable Integer flatId)
            throws FlatNotFoundException {
        flatService.updateFlat(flat, flatId);
        String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    //Delete Flat Details By Id
    @DeleteMapping(value = "/deleteflat/{flatId}")
    public ResponseEntity<String> deleteFlat(@PathVariable Integer flatId) throws FlatNotFoundException {
        flatService.deleteFlat(flatId);
        String successMessage = environment.getProperty("API.DELETE_SUCCESS");
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    
    //View Flat Details By Id
    @GetMapping(value = "/viewflat/{flatId}")
    public ResponseEntity<FlatDTO> viewFlat(@PathVariable Integer flatId) throws FlatNotFoundException {
        FlatDTO flat = flatService.viewFlat(flatId);
        return new ResponseEntity<>(flat, HttpStatus.OK);
    }

    
   //View All Flats
    @GetMapping(value = "/viewallflat")
    public ResponseEntity<List<FlatDTO>> viewAllFlat() {
        List<FlatDTO> flatList = flatService.viewAllFlat();
        return new ResponseEntity<>(flatList, HttpStatus.OK);
    }

    
    //Find Flats By Availability and Cost
    @GetMapping("findflat/{cost}/{availability}")
    public List<FlatDTO> findByCostAndAvailability(@PathVariable("cost") float cost, @PathVariable("availability") String availability) {
        return flatService.findByCostAndAvailability(cost, availability);
    }

}