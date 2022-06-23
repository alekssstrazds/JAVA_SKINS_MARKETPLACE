package lv.venta.project.services;


import org.springframework.data.jpa.domain.Specification;

import lv.venta.project.models.Item;

public interface IMarketService {
	//atrast iekš marketa item pēc itemName
	public Specification<Item> searchItemNameSpecification(String search) throws Exception;
	//pievienot item no market
	public void cancelItemByIdFromMarketByIdToInventoryById(int itemID, int inventoryID, int marketID) throws Exception;
	
}
