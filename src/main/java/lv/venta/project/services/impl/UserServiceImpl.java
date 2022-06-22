package lv.venta.project.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.project.models.User;
import lv.venta.project.repos.IUserRepo;
import lv.venta.project.services.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	IUserRepo userRepo;
	
	@Override
	public boolean registerUser(User user) {
		//Ja tāds lietotājs jau eksistē sistēmā
		if(!userRepo.existsByUserNameAndEmail(user.getUsername(), user.getEmail())) {
			userRepo.save(user);
			return true;
		}
		return false;
	}

	@Override
	public boolean authoriseUser(User user) {
		if(userRepo.existsByUserNameAndPassword(user.getUsername(), user.getPassword())) {
			return true;
		}
		return false;
	}
	
}
