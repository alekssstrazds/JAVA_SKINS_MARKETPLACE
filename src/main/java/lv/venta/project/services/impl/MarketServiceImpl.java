package lv.venta.project.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import lv.venta.project.models.Inventory;
import lv.venta.project.models.Item;
import lv.venta.project.models.Market;
import lv.venta.project.repos.IInventoryRepo;
import lv.venta.project.repos.IItemRepo;
import lv.venta.project.repos.IMarketRepo;
import lv.venta.project.services.IItemService;
import lv.venta.project.services.IMarketService;

@Service
public class MarketServiceImpl implements IMarketService{
	@Autowired
	private IItemRepo itemRepo;
	
	@Autowired 
	private IMarketRepo marketRepo;
	
	@Autowired
	private IInventoryRepo inventoryRepo;
	
	@Autowired
	private IItemService itemService;
	
	public Specification<Item> searchItemNameSpecification(String search) throws Exception {
		Specification<Item> searchResult = itemRepo.findByItemNameContainingIgnoreCase(search);
	    if(searchResult != null){
	    	throw new Exception("ID nav atrasts...");
	    }
	    return searchResult;
	}
	
	@Override
	public void addItemToInventory(Item item, Inventory inventory) throws Exception {
		if(!inventoryRepo.existsById(item.getInventoryItem().getInventoryID())) {
			inventory.addItemToInventory(item);
		} throw new Exception("itemID jau eksistē...");
	}

	@Override
	public void cancelItemByIdFromMarketByIdToInventoryById(int itemID) throws Exception {
		if(itemRepo.existsById(itemID)) {
			Item item = itemRepo.findById(itemID).get();
			//Inventory inventory = inventoryRepo.findById().get();
			Inventory inventory = inventoryRepo.findByInventoryItems(item.getInventoryItem().getInventoryID());
			itemService.deleteItemByIdFromMarketById(itemID, item.getMarket().getMarketID());
			if(inventoryRepo.existsById(inventory.getInventoryID())) {
				addItemToInventory(item, inventory);
			} 
		} throw new Exception("ID nav atrasts...");	
	}
}
