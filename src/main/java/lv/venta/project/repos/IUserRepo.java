package lv.venta.project.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.project.models.User;

public interface IUserRepo extends CrudRepository<User, Integer>{
	public User findByUserNameAndPassword(String username, String password);

	public boolean existsByUserNameAndEmail(String username, String email);
	public boolean existsByUserNameAndPassword(String username, String password);
}
