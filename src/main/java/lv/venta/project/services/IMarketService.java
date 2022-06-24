package lv.venta.project.services;


import org.springframework.data.jpa.domain.Specification;

import lv.venta.project.models.Inventory;
import lv.venta.project.models.Item;
import lv.venta.project.models.Market;

public interface IMarketService {
	//atrast iekš marketa item pēc itemName
	public Specification<Item> searchItemNameSpecification(String search) throws Exception;
	//pievienot item from market
	public void cancelItemByIdFromMarketByIdToInventoryById(int itemID) throws Exception;
	//pievieno item to inventory
		public void addItemToInventory(Item item, Inventory inventory) throws Exception;
}
