package lv.venta.project.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.project.models.Item;
import lv.venta.project.models.ItemQuality;
import lv.venta.project.models.ItemRarity;
import lv.venta.project.models.ItemType;
import lv.venta.project.repos.IItemRepo;
import lv.venta.project.services.IFilterItemService;

@Service
public class FilterItemServiceImpl implements IFilterItemService {
	@Autowired
	private IItemRepo itemRepo;
	
	@Override
	public ArrayList<Item> getAllItemByItemType(ItemType name) {
		return itemRepo.findAllByItemType(name);
	}
	@Override
	public ArrayList<Item> getAllItemByItemQuality(ItemQuality name) {
		return itemRepo.findAllByItemQuality(name);
	}
	@Override
	public ArrayList<Item> getAllItemByItemRarity(ItemRarity name) {
		return itemRepo.findAllByItemRarity(name);
	}
	
	@Override
    public ArrayList<Item> filterItemByItemSalePriceLessThan(float priceThreshold) {
		ArrayList<Item> filtredItems = itemRepo.findByItemSalePriceLessThan(priceThreshold);
        return filtredItems;
	}
	@Override
    public ArrayList<Item> filterItemByItemSalePriceGreaterThan(float priceThreshold) {
		ArrayList<Item> filtredItems = itemRepo.findByItemSalePriceGreaterThan(priceThreshold);
        return filtredItems;
	}
	
	
	    
}
