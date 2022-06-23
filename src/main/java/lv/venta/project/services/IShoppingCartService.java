package lv.venta.project.services;

import java.util.ArrayList;

import lv.venta.project.models.Item;

public interface IShoppingCartService {
	//pievienot item no market
	//dzēst item no groza
	
	//izvēlās visus item konkrētajā grozā
	public ArrayList<Item> selectAllItemInShoppingCartByCartID(int id) throws Exception;
	
	//aprekina kopejo summu ieks konkreta groza
	public float getSUMItemSalePriceByCartID(int id);
	//pērkot item ieks groza tas parversas balansa
	
}
