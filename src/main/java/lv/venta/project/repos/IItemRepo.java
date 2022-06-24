package lv.venta.project.repos;

import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.project.models.Item;
import lv.venta.project.models.ItemQuality;
import lv.venta.project.models.ItemRarity;
import lv.venta.project.models.ItemType;

public interface IItemRepo extends CrudRepository<Item, Integer>, JpaSpecificationExecutor<Item> {

	Specification<Item> findAllByitemName(String search);

	ArrayList<Item> findByItemSalePriceLessThan(float priceThreshold);

	ArrayList<Item> findByItemSalePriceGreaterThan(float priceThreshold);

	ArrayList<Item> findAllByItemType(ItemType name);

	ArrayList<Item> findAllByItemRarity(ItemRarity name);

	ArrayList<Item> findAllByItemQuality(ItemQuality name);
	//Iegūst item summu pēc CartID
	@Query(value = "SELECT SUM(m.tests) FROM report_data m", nativeQuery = true)
	public float calculateSUMItemSalePriceByCartID(int id);

	Specification<Item> findByItemNameContainingIgnoreCase(String search);

}
