package lv.venta.project.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.project.models.ShoppingCart;

public interface IShoppingCartRepo extends CrudRepository<ShoppingCart, Integer>{

	@Query(value = "SELECT SUM(m.tests) FROM report_data m", nativeQuery = true)
	public float calculateSUMItemSalePriceByCartID(int id);

}
