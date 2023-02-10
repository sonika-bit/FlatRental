package com.OnlineFlatRental.FlatRental.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineFlatRental.FlatRental.DTO.TenantDTO;
import com.OnlineFlatRental.FlatRental.Exception.TenantNotFoundException;
import com.OnlineFlatRental.FlatRental.Service.TenantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/tenant")
  public class TenantController {
	
  @Autowired
  private TenantService tenantServ;
 
	
	//Add Tenant
	@PostMapping("/addtenant")
	public ResponseEntity<TenantDTO> addTenant(@Valid @RequestBody TenantDTO tenant) {
		return new ResponseEntity<>(tenantServ.addTenant(tenant), HttpStatus.CREATED);
	}
	
	//Update Tenant By Id
	@PutMapping("/updatetenant/{tenantId}")
	public ResponseEntity<TenantDTO> updateTenant(@PathVariable int tenantId,@Valid @RequestBody TenantDTO tenant)
			throws TenantNotFoundException {
		TenantDTO t = tenantServ.updateTenant(tenantId, tenant);
		return new ResponseEntity<TenantDTO>(t, HttpStatus.ACCEPTED);
	}

	//Delete Tenant By Id
	@DeleteMapping("/deletetenant/{tenantId}")
	public ResponseEntity<String> deleteTenant(@PathVariable int tenantId) throws TenantNotFoundException {
		tenantServ.deleteTenant(tenantId);
		return new ResponseEntity<String>("Tenant with Tenant Id " + tenantId + " deleted successfuly", HttpStatus.OK);

	}
	
	//Get Tenants
	@GetMapping("/gettenants")
	public ResponseEntity<List<TenantDTO>> viewAllTenant() {
		List<TenantDTO> list = (List<TenantDTO>) tenantServ.viewAllTenant();
		return new ResponseEntity<List<TenantDTO>>(list, HttpStatus.OK);
	}
	
	//View Tenant By Id
	@GetMapping("/viewtenant/{tenantId}")
	public ResponseEntity<TenantDTO> viewTenant(@PathVariable int tenantId) throws TenantNotFoundException {
		TenantDTO t = tenantServ.viewTenant(tenantId);
		return new ResponseEntity<TenantDTO>(t, HttpStatus.OK);

	}	
	
	//Validate Tenant By Id
	@PatchMapping("/validatetenant/{tenantId}")
	public ResponseEntity<String>validateTenant(@PathVariable int tenantId) throws TenantNotFoundException {
		if(!tenantServ.validateTenant(tenantId)) {
			return new ResponseEntity<String>("Tenant Id not match", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<String>("Tenant Id Matched", HttpStatus.ACCEPTED);
		}
	}



	}
