package com.OnlineFlatRental.FlatRental.Service;

import java.util.List;

import com.OnlineFlatRental.FlatRental.DTO.FlatDTO;
import com.OnlineFlatRental.FlatRental.Exception.FlatNotFoundException;

public interface IFlatService  {
	public FlatDTO addFlat(FlatDTO flat);  
	public FlatDTO updateFlat(FlatDTO flat,int flatId) throws FlatNotFoundException;
	public void deleteFlat(int id) throws FlatNotFoundException; 
	public FlatDTO viewFlat(int FlatId)throws FlatNotFoundException;
	public List<FlatDTO> viewAllFlat(); 
	public List<FlatDTO> findByCostAndAvailability(float cost, String availability);		
}

