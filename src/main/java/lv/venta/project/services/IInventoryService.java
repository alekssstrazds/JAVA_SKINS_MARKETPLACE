package lv.venta.project.services;

import lv.venta.project.models.Inventory;
import lv.venta.project.models.Item;
import lv.venta.project.models.Market;

public interface IInventoryService {
	//pardot item no inventori uz market
	public void saleItemByIdFromInventoryByIdToMarketById(int itemID) throws Exception;
	//pievieno item to market
	public void addItemToMarket(Item item, Market market) throws Exception;
}
