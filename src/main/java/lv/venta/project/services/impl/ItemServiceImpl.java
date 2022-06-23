package lv.venta.project.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.project.models.Inventory;
import lv.venta.project.models.Item;
import lv.venta.project.models.ItemQuality;
import lv.venta.project.models.ItemRarity;
import lv.venta.project.models.ItemType;
import lv.venta.project.models.User;
import lv.venta.project.repos.IInventoryRepo;
import lv.venta.project.repos.IItemRepo;
import lv.venta.project.repos.IMarketRepo;
import lv.venta.project.services.IItemService;

@Service
public class ItemServiceImpl implements IItemService{
	
	@Autowired 
	private IItemRepo itemRepo;
	
	@Autowired
	private IInventoryRepo inventoryRepo;
	
	@Autowired
	private IMarketRepo marketRepo;
	
	
	@Override
	public ArrayList<Item> getAllItem() throws Exception {
		return (ArrayList<Item>) itemRepo.findAll();
	}
	public void changeItemByIdInventoryById(int itemID, int inventoryID) throws Exception {
		  if(inventoryRepo.existsById(inventoryID)) 
	        {
	            Item item = itemRepo.findById(itemID).get();
	            Inventory inventory = inventoryRepo.findById(inventoryID).get();
	            deleteItemByIdFromInventoryById(itemID, item.getInventoryItem().getInventoryID());
	            inventory.addNewItemToInventory(item);
	            
	        } throw new Exception("ID nav atrasts...");
	}
	
	@Override
    public void deleteItemByIdFromInventoryById(int itemID, int inventoryID) throws Exception {
        boolean isFound = false;
        if(inventoryRepo.existsById(inventoryID)) {
            itemRepo.deleteById(itemID);
            isFound = true;
        } 
        if(!isFound) {
            throw new Exception("ID nav atrasts...");
        } 
    }
	@Override
	public Item getItemById(int id) throws Exception {
		if(itemRepo.existsById(id)) {
			return itemRepo.findById(id).get();
		} throw new Exception("ID nav atrasts...");
	}
	@Override
	public Item insertNewItem(Item item) {
		Item newItem = new Item(item.getItemSubType(), item.getItemName(), item.getPatternIDs(), item.getItemFloat(), item.getItemSuggestedPrice(),
				item.getItemSalePrice(), item.getItemType(), item.getItemRarity(), item.getItemQuality());
		Item itemFromDB = itemRepo.save(newItem);
		return itemFromDB;
	}
	@Override
	public void updateItemById(int id, Item temp) throws Exception {
		if(itemRepo.existsById(id)) 
        {
            Item item = itemRepo.findById(id).get();
            if(!item.getItemName().equals(temp.getItemName())) {
                item.setItemName(temp.getItemName());
            }
            if(item.getItemSuggestedPrice() != temp.getItemSuggestedPrice()) {
                item.setItemSuggestedPrice(temp.getItemSuggestedPrice());
            }
            if(item.getItemSalePrice() != temp.getItemSalePrice()) {
                item.setItemSalePrice(temp.getItemSalePrice());
            }
            itemRepo.save(item);
        } throw new Exception("ID nav atrasts...");
		
	}
	@Override
	public void deleteItemById(int id) throws Exception {
		boolean isFound = false;
        if(itemRepo.existsById(id)) {
            itemRepo.deleteById(id);
            isFound = true;
        } 
        if(!isFound) {
            throw new Exception("ID nav atrasts...");
        }
		
	}
	@Override
	public void deleteItemByIdFromMarketById(int itemID, int marketID) throws Exception {
		 boolean isFound = false;
	        if(marketRepo.existsById(marketID)) {
	            itemRepo.deleteById(itemID);
	            isFound = true;
	        } 
	        if(!isFound) {
	            throw new Exception("ID nav atrasts...");
	        } 
	}
}
