package com.OnlineFlatRental.FlatRental.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.OnlineFlatRental.FlatRental.Entity.FlatBooking;

@Repository
public interface FlatBookingRepository extends CrudRepository<FlatBooking, Integer>{

}