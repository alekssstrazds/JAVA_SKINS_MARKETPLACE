package lv.venta.project.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.project.models.Inventory;

@Repository
public interface IInventoryRepo extends CrudRepository<Inventory, Integer> {
	Inventory findByInventoryItems(int inventoryID);

}
