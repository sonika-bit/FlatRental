package com.OnlineFlatRental.FlatRental.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.OnlineFlatRental.FlatRental.Entity.Flat;

@Repository
public interface FlatRepository extends CrudRepository <Flat,Integer>{
	List<Flat> findByCostAndAvailability(float cost, String availability);
}