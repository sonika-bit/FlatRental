package com.OnlineFlatRental.FlatRental.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineFlatRental.FlatRental.DTO.UserDTO;
import com.OnlineFlatRental.FlatRental.Entity.User;
import com.OnlineFlatRental.FlatRental.Exception.UserNotFoundException;
import com.OnlineFlatRental.FlatRental.Repository.UserRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;

@Service
@Transactional
public class UserService implements IUserService{
	@Autowired
	private UserRepository userRepository;
	//View User
	@Override
	public UserDTO viewUser(int userId) throws UserNotFoundException {
		Optional<User> optional = userRepository.findById(userId);
		User user = optional.orElseThrow(() -> new UserNotFoundException("Service.USER_NOT_FOUND"));
		UserDTO user1 = new UserDTO();
		user1.setUserId(user.getUserId());
		user1.setUserName(user.getUserName());
		user1.setPassword(user.getPassword());
		user1.setUserType(user.getUserType());
		return user1;
	}
	//View All Users
	@Override
	public List<UserDTO> viewAllUsers() throws UserNotFoundException{
		Iterable<User> users = userRepository.findAll();
		List<UserDTO> usersList = new ArrayList<>();
		users.forEach(user -> {
			UserDTO user1 = new UserDTO();
			user1.setUserId(user.getUserId());
			user1.setUserName(user.getUserName());
			user1.setPassword(user.getPassword());
			user1.setUserType(user.getUserType());
			usersList.add(user1);
		});
		if (usersList.isEmpty())
			throw new UserNotFoundException("Service.USERS_NOT_FOUND");
		return usersList;
	}
	//Validate User
	@Override
	public Boolean validateUser(String userName,String password,String userType) throws UserNotFoundException,ValidationException {
		Optional<User> optional = userRepository.findByUserName(userName);
		optional.orElseThrow(() -> new UserNotFoundException("Service.USER_NOT_FOUND"));
		Boolean flag=false;
		if(optional.get().getPassword().equals(password) && userType.equals(optional.get().getUserType())) {
			flag=true;
		}
		else {
			throw new ValidationException("Service.INCORRECT_PASSWORD");
		}
		return flag;
	}
	//Add User
	@Override
	public UserDTO addUser(UserDTO user) throws UserNotFoundException {
		if(userRepository.existsById(user.getUserId())) {
			throw new UserNotFoundException("Service.USER_ALREADY_EXIST");
		}
		else {
			User user1 = new User();
			user1.setUserId(user.getUserId());
			user1.setUserName(user.getUserName());
			user1.setPassword(user.getPassword());
			user1.setUserType(user.getUserType());
			userRepository.save(user1);
			return user;
		}
		
	}
	//Update User
	@Override
	public UserDTO updateUser(UserDTO user) throws UserNotFoundException {
		Optional<User> optional = userRepository.findById(user.getUserId());
		optional.orElseThrow(() -> new UserNotFoundException("Service.USER_NOT_FOUND"));
		User user1=optional.get();
		user1.setUserName(user.getUserName());
		user1.setPassword(user.getPassword());
		user1.setUserType(user.getUserType());
		userRepository.save(user1);
		return user;
	}
	//update Password
	@Override
	public UserDTO updatePassword(UserDTO user,String newPassword) throws UserNotFoundException {
		Optional<User> optional = userRepository.findById(user.getUserId());
		optional.orElseThrow(() -> new UserNotFoundException("Service.USER_NOT_FOUND"));
		User user1=optional.get();
		user1.setPassword(newPassword);
		userRepository.save(user1);
		return user;
	}
	//Remove User
	@Override
	public UserDTO removeUser(Integer userId) throws UserNotFoundException {
		Optional<User> optional = userRepository.findById(userId);
		optional.orElseThrow(() -> new UserNotFoundException("Service.USER_NOT_FOUND"));
        userRepository.deleteById(userId);
        UserDTO user1 = new UserDTO();
		user1.setUserId(optional.get().getUserId());
		user1.setUserName(optional.get().getUserName());
		user1.setPassword(optional.get().getPassword());
		user1.setUserType(optional.get().getUserType());
		return user1;
	}
	
}