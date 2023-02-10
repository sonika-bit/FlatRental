package com.OnlineFlatRental.FlatRental.Service;

import java.util.List;

import com.OnlineFlatRental.FlatRental.DTO.FlatBookingDTO;
import com.OnlineFlatRental.FlatRental.DTO.FlatDTO;
import com.OnlineFlatRental.FlatRental.Exception.FlatBookingNotFoundException;

public interface IFlatBookingService {
	public FlatBookingDTO addFlatBooking(FlatBookingDTO flat);
    public FlatBookingDTO updateFlatBooking(FlatBookingDTO flat,int id) throws FlatBookingNotFoundException;
    public void deleteFlatBooking(int id) throws FlatBookingNotFoundException;
    public FlatBookingDTO viewFlatBooking(int id) throws FlatBookingNotFoundException;
    public List<FlatBookingDTO> viewAllFlatBooking();

}
