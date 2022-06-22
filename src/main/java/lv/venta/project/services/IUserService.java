package lv.venta.project.services;

import lv.venta.project.models.User;

public interface IUserService {
	public boolean registerUser(User user);
	public boolean authoriseUser(User user);
	
}
