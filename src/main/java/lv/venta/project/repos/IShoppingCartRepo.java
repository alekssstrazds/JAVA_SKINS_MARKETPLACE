package lv.venta.project.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.project.models.ShoppingCart;

@Repository
public interface IShoppingCartRepo extends CrudRepository<ShoppingCart, Integer>{

	

}
