package com.OnlineFlatRental.FlatRental.Service;

import java.util.List;

import com.OnlineFlatRental.FlatRental.DTO.UserDTO;
import com.OnlineFlatRental.FlatRental.Exception.UserNotFoundException;

import jakarta.validation.ValidationException;

public interface IUserService {
	public UserDTO viewUser(int userId) throws UserNotFoundException;
	public List<UserDTO> viewAllUsers() throws UserNotFoundException;
	public Boolean validateUser(String userName,String password,String userType) throws UserNotFoundException,ValidationException;
	public UserDTO addUser(UserDTO user) throws UserNotFoundException;
	public UserDTO updateUser(UserDTO user) throws UserNotFoundException;
	public UserDTO updatePassword(UserDTO user,String newPassword) throws UserNotFoundException;
	public UserDTO removeUser(Integer userId) throws UserNotFoundException;
}


