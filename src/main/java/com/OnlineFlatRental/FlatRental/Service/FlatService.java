package com.OnlineFlatRental.FlatRental.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineFlatRental.FlatRental.DTO.AddressDTO;
import com.OnlineFlatRental.FlatRental.DTO.FlatDTO;
import com.OnlineFlatRental.FlatRental.Entity.Address;
import com.OnlineFlatRental.FlatRental.Entity.Flat;
import com.OnlineFlatRental.FlatRental.Exception.FlatNotFoundException;
import com.OnlineFlatRental.FlatRental.Repository.FlatRepository;

@Service
public class FlatService implements IFlatService{

@Autowired
private FlatRepository flatRepository;
//Add Flat
@Override
public FlatDTO addFlat(FlatDTO flat) {
	Flat f= new Flat();
    f.setFlatId(flat.getFlatId());
    f.setCost(flat.getCost());
    f.setAvailability(flat.getAvailability());
    Address fa=new Address();
    fa.setHouseNo(flat.getFlatAddress().getHouseNo());
    fa.setStreet(flat.getFlatAddress().getStreet());
    fa.setCity(flat.getFlatAddress().getCity());
    fa.setState(flat.getFlatAddress().getState());
    fa.setPin(flat.getFlatAddress().getPin());
    fa.setCountry(flat.getFlatAddress().getCountry());
    f.setFlatAddress(fa);
	flatRepository.save(f);
	return flat;
}
//Update Flat
@Override	
public FlatDTO updateFlat(FlatDTO flat,int flatId) throws FlatNotFoundException {
	Flat f = flatRepository.findById(flatId).orElseThrow(()->new FlatNotFoundException("Service.FLAT_NOT_FOUND"));
	f.setCost(flat.getCost());
	f.setAvailability(flat.getAvailability());
	Address fa=new Address();
    fa.setHouseNo(flat.getFlatAddress().getHouseNo());
    fa.setStreet(flat.getFlatAddress().getStreet());
    fa.setCity(flat.getFlatAddress().getCity());
    fa.setState(flat.getFlatAddress().getState());
    fa.setPin(flat.getFlatAddress().getPin());
    fa.setCountry(flat.getFlatAddress().getCountry());
    f.setFlatAddress(fa);
	flatRepository.save(f);
	return flat;
}
//Delete Flat
@Override	
public void deleteFlat(int flatId)throws FlatNotFoundException{
	Flat f=flatRepository.findById(flatId).orElseThrow(()->new FlatNotFoundException("Service.FLAT_NOT_FOUND"));
	flatRepository.delete(f);
}
//View Flat
@Override
public FlatDTO viewFlat(int flatId) throws FlatNotFoundException {
	Flat flat=flatRepository.findById(flatId).orElseThrow(()->new FlatNotFoundException("Service.FLAT_NOT_FOUND"));
	FlatDTO f= new FlatDTO();
    f.setFlatId(flat.getFlatId());
    f.setCost(flat.getCost());
    f.setAvailability(flat.getAvailability());
    AddressDTO fa=new AddressDTO();
    fa.setHouseNo(flat.getFlatAddress().getHouseNo());
    fa.setStreet(flat.getFlatAddress().getStreet());
    fa.setCity(flat.getFlatAddress().getCity());
    fa.setState(flat.getFlatAddress().getState());
    fa.setPin(flat.getFlatAddress().getPin());
    fa.setCountry(flat.getFlatAddress().getCountry());
    f.setFlatAddress(fa);
    return f;
}
//View All Flat
@Override
public List<FlatDTO> viewAllFlat() {
	List<Flat> list=(List<Flat>) flatRepository.findAll();
	List<FlatDTO> fList = new ArrayList<>();
	list.forEach(flat->{
		FlatDTO f= new FlatDTO();
        f.setFlatId(flat.getFlatId());
        f.setCost(flat.getCost());
        f.setAvailability(flat.getAvailability());
        AddressDTO fa=new AddressDTO();
        fa.setHouseNo(flat.getFlatAddress().getHouseNo());
        fa.setStreet(flat.getFlatAddress().getStreet());
        fa.setCity(flat.getFlatAddress().getCity());
        fa.setState(flat.getFlatAddress().getState());
        fa.setPin(flat.getFlatAddress().getPin());
        fa.setCountry(flat.getFlatAddress().getCountry());
        f.setFlatAddress(fa);
        fList.add(f);
	});
	return fList;
}
//Find By Cost and Availability
@Override
public List<FlatDTO> findByCostAndAvailability(float cost,String availability){
	List<Flat> list=flatRepository.findByCostAndAvailability(cost,availability);
	List<FlatDTO> fList = new ArrayList<>();
	list.forEach(flat->{
		FlatDTO f= new FlatDTO();
        f.setFlatId(flat.getFlatId());
        f.setCost(flat.getCost());
        f.setAvailability(flat.getAvailability());
        AddressDTO fa=new AddressDTO();
        fa.setHouseNo(flat.getFlatAddress().getHouseNo());
        fa.setStreet(flat.getFlatAddress().getStreet());
        fa.setCity(flat.getFlatAddress().getCity());
        fa.setState(flat.getFlatAddress().getState());
        fa.setPin(flat.getFlatAddress().getPin());
        fa.setCountry(flat.getFlatAddress().getCountry());
        f.setFlatAddress(fa);
        fList.add(f);
	});
	return fList;
 }	
}