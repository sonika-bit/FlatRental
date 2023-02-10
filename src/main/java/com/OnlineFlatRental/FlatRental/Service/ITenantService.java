package com.OnlineFlatRental.FlatRental.Service;

import java.util.List;

import com.OnlineFlatRental.FlatRental.DTO.TenantDTO;
import com.OnlineFlatRental.FlatRental.Exception.TenantNotFoundException;

public interface ITenantService {
	TenantDTO addTenant(TenantDTO tenant);
	TenantDTO updateTenant(int tenantId, TenantDTO tenant) throws TenantNotFoundException;
	void deleteTenant(int tenantId) throws TenantNotFoundException;
	TenantDTO viewTenant(int tenantId) throws TenantNotFoundException;
	boolean validateTenant(int tenantId) throws TenantNotFoundException;
	List<TenantDTO> viewAllTenant();

}
