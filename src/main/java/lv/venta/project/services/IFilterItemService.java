package lv.venta.project.services;

import java.util.ArrayList;

import lv.venta.project.models.Item;
import lv.venta.project.models.ItemQuality;
import lv.venta.project.models.ItemRarity;
import lv.venta.project.models.ItemType;

public interface IFilterItemService {
		public ArrayList<Item> getAllItemByItemType(ItemType name);
		
		public ArrayList<Item> getAllItemByItemQuality(ItemQuality name);
		
		public ArrayList<Item> getAllItemByItemRarity(ItemRarity name);
		
	    public ArrayList<Item> filterItemByItemSalePriceGreaterThan(float priceThreshold);
	    
	    public ArrayList<Item> filterItemByItemSalePriceLessThan(float priceThreshold);
	    
	    
	    
	    
}
