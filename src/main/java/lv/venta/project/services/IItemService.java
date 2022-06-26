package lv.venta.project.services;

import java.util.ArrayList;

import lv.venta.project.models.Inventory;
import lv.venta.project.models.Item;
import lv.venta.project.models.Market;
import lv.venta.project.models.User;

public interface IItemService {
	//iegūt visus item
	public ArrayList<Item> getAllItem() throws Exception;
	//izveidot item
	public Item getItemById(int id) throws Exception;
	//ievietot jaunu user
	public Item insertNewItem(Item item);
	//samainīt item datus pec id
	public void updateItemById(int id, Item temp) throws Exception;
	//izdzēst item pēc id
	public void deleteItemById(int id) throws Exception;
	//change item holder
	public void changeItemByIdInventoryById(int itemID, int inventoryID) throws Exception;
	//izdzēš item no inventory
    public void deleteItemByIdFromInventoryById(int itemID, int inventoryID) throws Exception;
    //izdzēš item no market
    public void deleteItemByIdFromMarketById(int itemID, int marketID) throws Exception;
    //saskaita item daudzumu iekš repo
    public long getItemCount();
  
}
