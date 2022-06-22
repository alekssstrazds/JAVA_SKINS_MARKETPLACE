package lv.venta.project.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.project.models.Inventory;

public interface IInventoryRepo extends CrudRepository<Inventory, Integer> {

}
