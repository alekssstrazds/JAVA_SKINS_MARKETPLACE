package lv.venta.project.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.project.models.User;

public interface IUserRepo extends CrudRepository<User, Integer>{
	public User findByUsernameAndPassword(String username, String password);

	public boolean existsByUsername(String username);
	public boolean existsByUsernameAndPassword(String username, String password);
}
