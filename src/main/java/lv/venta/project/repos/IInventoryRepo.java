package lv.venta.project.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.project.models.Inventory;
import lv.venta.project.models.Item;

public interface IInventoryRepo extends CrudRepository<Inventory, Integer> {
	Inventory findByInventoryItems(int inventoryID);

}
