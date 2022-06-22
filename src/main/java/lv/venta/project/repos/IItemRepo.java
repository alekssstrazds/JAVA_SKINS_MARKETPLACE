package lv.venta.project.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.project.models.Item;

public interface IItemRepo extends CrudRepository<Item, Integer> {

}
