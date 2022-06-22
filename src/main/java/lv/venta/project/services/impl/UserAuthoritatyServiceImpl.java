package lv.venta.project.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lv.venta.project.models.User;
import lv.venta.project.repos.IUserRepo;
import lv.venta.project.services.IUserAuthorityService;

public class UserAuthoritatyServiceImpl implements IUserAuthorityService {
	
	/*@Autowired
    private IUserRepo userRepo;

	@Override
	public User loadUserByUserNameAndPassword(String username, String password) throws UsernameNotFoundException {
	 
		System.out.println(username);
		User user = userRepo.findByUsernameAndPassword(username, password);
		System.out.println(user.getAuthorities().size()); 
	    if (user == null) {
	    	throw new UsernameNotFoundException("Lietotajs nav atrasts...");
	    }
	    System.out.println(user.getUserID() + " " + user.getUsername());
	    return new User(user);
	}*/

}
