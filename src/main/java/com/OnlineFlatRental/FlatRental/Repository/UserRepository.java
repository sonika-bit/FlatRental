package com.OnlineFlatRental.FlatRental.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.OnlineFlatRental.FlatRental.Entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	public Optional<User> findByUserName(String userName);
}