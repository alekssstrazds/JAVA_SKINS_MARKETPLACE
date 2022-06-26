package lv.venta.project.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.project.models.User;

@Repository
public interface IUserRepo extends CrudRepository<User, Integer>{
	public User findByUsernameAndPassword(String username, String password);

	public boolean existsByUsername(String username);
	public boolean existsByUsernameAndPassword(String username, String password);

	public User findByUserID(int id);
}
