package lv.venta.project.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.project.models.Inventory;
import lv.venta.project.models.Item;
import lv.venta.project.models.Market;
import lv.venta.project.repos.IInventoryRepo;
import lv.venta.project.repos.IItemRepo;
import lv.venta.project.repos.IMarketRepo;
import lv.venta.project.services.IInventoryService;
import lv.venta.project.services.IItemService;

@Service
public class InventoryServiceImpl implements IInventoryService{

	@Autowired
	private IItemRepo itemRepo;
	@Autowired
	private IInventoryRepo inventoryRepo;
	
	@Autowired 
	private IMarketRepo marketRepo;
	
	@Autowired
	private IItemService itemService;
	
	
	@Override
	public void saleItemByIdFromInventoryByIdToMarketById(int itemID, int inventoryID, int marketID) throws Exception {
		Item item = itemRepo.findById(itemID).get();
		Market market = marketRepo.findById(marketID).get();
		itemService.deleteItemByIdFromInventoryById(itemID, item.getInventoryItem().getInventoryID());
		if(marketRepo.existsById(marketID)) {
			market.addNewItemToMarket(item);
		} throw new Exception("ID nav atrasts...");
	}
	
}