package lv.venta.project.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.project.models.Item;
import lv.venta.project.repos.IItemRepo;
import lv.venta.project.repos.IMarketRepo;
import lv.venta.project.services.IMarketService;

@Service
public class MarketServiceImpl implements IMarketService{
	@Autowired
	private IMarketRepo marketRepo;
	@Autowired
	private IItemRepo itemRepo;
	
	@Override
	public ArrayList<Item> getAllItems(){
		return(ArrayList<Item>) itemRepo.findAll();
	}
	
	@Override
	public ArrayList<Item> getAllItemsByItemName(String name) throws Exception {
		return marketRepo.findByItemName(name);
	}

	
}
