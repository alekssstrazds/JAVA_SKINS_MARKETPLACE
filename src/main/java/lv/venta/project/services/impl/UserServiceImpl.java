package lv.venta.project.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.project.models.User;
import lv.venta.project.repos.IUserRepo;
import lv.venta.project.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserRepo userRepo;

	@Override
	public User getUserById(int id) throws Exception {
		if(userRepo.existsById(id)) {
			return userRepo.findById(id).get();
		} throw new Exception("ID nav atrasts...");
		
	}

	@Override
	public User insertNewUser(User user) {
		User newUser = new User(user.getEmail(), user.getUsername(), user.getPassword(),
				user.getAddress(), user.getActive(), user.getBalance(), user.getInventory(), user.getShoppingCart());
		User userFromDB = userRepo.save(newUser);
		return userFromDB;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		return (ArrayList<User>) userRepo.findAll();
	}

	@Override
	public void updateUserById(int id, User temp) throws Exception {
		if(userRepo.existsById(id)) 
        {
            User user = userRepo.findById(id).get();
            if(!user.getEmail().equals(temp.getEmail())) {
                user.setEmail(temp.getEmail());
            }
            if(!user.getAddress().equals(temp.getAddress())) {
                user.setAddress(temp.getAddress());
            }
            userRepo.save(user);
        } throw new Exception("ID nav atrasts...");
	}

	@Override
	public void deleteUserById(int id) throws Exception {
		boolean isFound = false;
        if(userRepo.existsById(id)) {
            userRepo.deleteById(id);
            isFound = true;
        } 
        if(!isFound) {
            throw new Exception("ID nav atrasts...");
        }
	}
}
