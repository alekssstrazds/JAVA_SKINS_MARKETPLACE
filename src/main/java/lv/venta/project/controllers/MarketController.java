package lv.venta.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lv.venta.project.services.IInventoryService;
import lv.venta.project.services.IItemService;
import lv.venta.project.services.IMarketService;

@Controller
@RequestMapping("/") //localhost:8080/
public class MarketController {
	@Autowired
	private IMarketService marketService;
	@Autowired
	private IInventoryService inventoryService;
	@Autowired
	private IItemService itemService;
	
	@GetMapping("/")
	public String main(Model model) {
		try
		{
			model.addAttribute("package-all", itemService.getAllItem());
			return "market-page";
		}
		catch (Exception e) {
			model.addAttribute("errorMsg", e.getMessage());
			return "error-page";
		}
	}
	@GetMapping("/search/{name}")
	public String getSearchedItemName(@RequestParam(name="name") String name, Model model) {
		try {
            model.addAttribute("package-search", marketService.searchItemNameSpecification(name));
            return "market-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page"; 
        }
	}
}

