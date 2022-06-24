package lv.venta.project.services;

import java.util.ArrayList;

import lv.venta.project.models.User;

public interface IUserService {
	//iegūt user pēc id
	public User getUserById(int id) throws Exception;
	//ievietot jaunu user
	public User insertNewUser(User user);
	//iegūt visus user
	public ArrayList<User> getAllUsers();
	//samainīt user datus pec id (addres, email)
	public void updateUserById(int id, User temp) throws Exception;
	//izdzēst user pēc id
	public void deleteUserById(int id) throws Exception;
	//atjaunot user balansu
	
	
	
}
