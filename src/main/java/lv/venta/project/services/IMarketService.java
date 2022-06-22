package lv.venta.project.services;

import java.util.ArrayList;

import lv.venta.project.models.Item;

public interface IMarketService {
	//Atgriezt visus item
	public ArrayList<Item> getAllItems();
	//atrast iekš marketa item pēc itemName
	public ArrayList<Item> getAllItemsByItemName(String itemName) throws Exception;
}
