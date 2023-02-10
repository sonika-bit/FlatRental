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

import com.OnlineFlatRental.FlatRental.DTO.LandlordDTO;
import com.OnlineFlatRental.FlatRental.Exception.LandlordNotFoundException;
import com.OnlineFlatRental.FlatRental.Service.LandlordService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/landlord")


public class LandlordController {

	@Autowired
	private LandlordService landlordService;

	@Autowired
	private Environment environment;

	
	//View All Landlord
	@GetMapping(value = "/viewalllandlord")
	public ResponseEntity<List<LandlordDTO>> viewAllLandlord() {
		List<LandlordDTO> landlordList = landlordService.viewAllLandlord();
		return new ResponseEntity<>(landlordList, HttpStatus.OK);
	}

	
	//View Landlord By Id
	@GetMapping(value = "/viewlandlord/{landlordId}")
	public ResponseEntity<LandlordDTO> viewLandlord(@PathVariable Integer landlordId) throws LandlordNotFoundException {
		LandlordDTO landlord = landlordService.viewLandlord(landlordId);
		return new ResponseEntity<>(landlord, HttpStatus.OK);
	}

	
	//Add Landlord 
	@PostMapping(value = "/addlandlord")
	public ResponseEntity<String> addLandlord(@Valid @RequestBody LandlordDTO landlord) throws LandlordNotFoundException {
		LandlordDTO landlordId = landlordService.addLandlord(landlord);
		String successMessage = "landlordId:"+landlordId.getLandlordId()+","+environment.getProperty("API.INSERT_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}

	
	//Update Landlord By Id
	@PutMapping(value = "/updatelandlord/{landlordId}")
	public ResponseEntity<String> updateLandlord(@PathVariable Integer landlordId,@Valid @RequestBody LandlordDTO landlord)
			throws LandlordNotFoundException {
		landlordService.updateLandlord(landlordId, landlord);
		String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

	
	//Delete Landlord By Id
	@DeleteMapping(value = "/deletelandlord/{landlordId}")
	public ResponseEntity<String> deleteLandlord(@PathVariable Integer landlordId) throws LandlordNotFoundException {
		landlordService.deleteLandlord(landlordId);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
}