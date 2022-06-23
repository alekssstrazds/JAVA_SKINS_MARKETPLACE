package lv.venta.project.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.project.models.Item;
import lv.venta.project.repos.IItemRepo;
import lv.venta.project.repos.IShoppingCartRepo;
import lv.venta.project.services.IShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements IShoppingCartService{
	
	@Autowired
	private IShoppingCartRepo shoppingCartRepo;
	
	@Autowired
	private IItemRepo itemRepo;
	
	@Override
	public ArrayList<Item> selectAllItemInShoppingCartByCartID(int id) throws Exception {
		  if(shoppingCartRepo.existsById(id) && shoppingCartRepo.findById(id).get().equals(id)) {
	          return (ArrayList<Item>) itemRepo.findAll();
	      } throw new Exception("ID nav atrasts..."); 
	}
	@Override
	public float getSUMItemSalePriceByCartID(int id) {
		return itemRepo.calculateSUMItemSalePriceByCartID(id);
	}
	
}
