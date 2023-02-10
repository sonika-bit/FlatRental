package com.OnlineFlatRental.FlatRental.Service;

import java.util.List;

import com.OnlineFlatRental.FlatRental.DTO.LandlordDTO;
import com.OnlineFlatRental.FlatRental.Exception.LandlordNotFoundException;

public interface ILandlordService {
	public LandlordDTO addLandlord(LandlordDTO landlord);
	public LandlordDTO updateLandlord(Integer landlordId, LandlordDTO landlord) throws LandlordNotFoundException;
	public void deleteLandlord(Integer landlordId) throws LandlordNotFoundException;
	public LandlordDTO viewLandlord(Integer landlordId) throws LandlordNotFoundException;
	public List<LandlordDTO> viewAllLandlord();
}


