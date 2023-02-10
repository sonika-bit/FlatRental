package com.OnlineFlatRental.FlatRental.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineFlatRental.FlatRental.DTO.AddressDTO;
import com.OnlineFlatRental.FlatRental.DTO.FlatDTO;
import com.OnlineFlatRental.FlatRental.DTO.LandlordDTO;
import com.OnlineFlatRental.FlatRental.Entity.Address;
import com.OnlineFlatRental.FlatRental.Entity.Flat;
import com.OnlineFlatRental.FlatRental.Entity.Landlord;
import com.OnlineFlatRental.FlatRental.Exception.LandlordNotFoundException;
import com.OnlineFlatRental.FlatRental.Repository.LandlordRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LandlordService implements ILandlordService {

	@Autowired
	private LandlordRepository landlordRepository;
	//Add landlord
	@Override
	public LandlordDTO addLandlord(LandlordDTO landlord) {
		
		Landlord l=new Landlord();
		l.setLandlordName(landlord.getLandlordName());
		l.setLandlordAge(landlord.getLandlordAge());
		List<Flat> fList = new ArrayList<>();
		landlord.getFlatList().forEach(flat->{
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
            fList.add(f);
		});
		l.setFlatList(fList);
		landlordRepository.save(l);
		return landlord;
	}
	//Delete landlord
    @Override
	public void deleteLandlord(Integer landlordId) throws LandlordNotFoundException {
		if (!landlordRepository.existsById(landlordId)) {
			throw new LandlordNotFoundException("Service.LANDLORD_NOT_FOUND");
		}
		landlordRepository.deleteById(landlordId);
	}
    //View Landlord By Id
	@Override
	public LandlordDTO viewLandlord(Integer landlordId) throws LandlordNotFoundException {

		if (!landlordRepository.existsById(landlordId)) {
			throw new LandlordNotFoundException("Service.LANDLORD_NOT_FOUND");
		}
		Landlord landlord=landlordRepository.findById(landlordId).get();
		LandlordDTO l=new LandlordDTO();
		l.setLandlordId(landlord.getLandlordId());
		l.setLandlordName(landlord.getLandlordName());
		l.setLandlordAge(landlord.getLandlordAge());
		List<FlatDTO> fList = new ArrayList<>();
		landlord.getFlatList().forEach(flat->{
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
		l.setFlatList(fList);
		return l;
	}
	//View All Landlord
	@Override
	public List<LandlordDTO> viewAllLandlord() {
		List<Landlord> list =(List<Landlord>) landlordRepository.findAll();
		List<LandlordDTO> lList = new ArrayList<>();
		list.forEach(landlord->{
			LandlordDTO l=new LandlordDTO();
			l.setLandlordId(landlord.getLandlordId());
			l.setLandlordName(landlord.getLandlordName());
			l.setLandlordAge(landlord.getLandlordAge());
			List<FlatDTO> fList = new ArrayList<>();
			landlord.getFlatList().forEach(flat->{
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
			l.setFlatList(fList);
			lList.add(l);
		});
		return lList;
	}
	//Update Landlord
	@Override
	public LandlordDTO updateLandlord(Integer landlordId, LandlordDTO landlord) throws LandlordNotFoundException {
		if (!landlordRepository.existsById(landlordId)) {
			throw new LandlordNotFoundException("Service.LANDLORD_NOT_FOUND");
		}
		Landlord l = landlordRepository.findById(landlordId).get();
		l.setLandlordName(landlord.getLandlordName());
		l.setLandlordAge(landlord.getLandlordAge());
		List<Flat> fList = new ArrayList<>();
		landlord.getFlatList().forEach(flat->{
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
            fList.add(f);
		});
		l.setFlatList(fList);
		landlordRepository.save(l);
		return landlord;
	}
}
