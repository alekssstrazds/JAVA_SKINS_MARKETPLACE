package lv.venta.project.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lv.venta.project.models.Item;
import lv.venta.project.models.User;
import lv.venta.project.services.IInventoryService;
import lv.venta.project.services.IItemService;
import lv.venta.project.services.IMarketService;

@Controller
//@RequestMapping("/market") //localhost:8080/market
public class MarketController {
	@Autowired
	private IMarketService marketService;
	@Autowired
	private IInventoryService inventoryService;
	@Autowired
	private IItemService itemService;
	
	@GetMapping("/market")
	public String AllItems(Model model) {
		try
		{
			ArrayList<Item> list = itemService.getAllItem();
			int id = 17;
		    Item temp = itemService.getItemById(id);
			
			model.addAttribute("packageitemall", list);
			model.addAttribute("packageitem", temp);
			model.addAttribute("packagecount", itemService.getItemCount());
			return "market-page";
		}
		catch (Exception e) {
			model.addAttribute("errorMsg", e.getMessage());
			return "error-page";
		}
	}
	@GetMapping("/search/{name}")
	public String SearchedItemName(@RequestParam(name="name") String name, Model model) {
		try {
            model.addAttribute("packagesearch", marketService.searchItemNameSpecification(name));
            return "market-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page"; 
        }
	}
}

