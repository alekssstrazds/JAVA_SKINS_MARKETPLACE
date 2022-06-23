package lv.venta.project.services;

import lv.venta.project.models.Market;

public interface IInventoryService {
	//pardot item no inventori uz market
	public void saleItemByIdFromInventoryByIdToMarketById(int itemID, int inventoryID, int marketID) throws Exception;
}
