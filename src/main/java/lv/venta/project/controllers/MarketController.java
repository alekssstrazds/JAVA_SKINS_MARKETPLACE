package lv.venta.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lv.venta.project.services.IMarketService;

@Controller
@RequestMapping("/market")
public class MarketController {
	@Autowired
	private IMarketService marketService;
	
	@GetMapping("/")
	public String main(Model model) {
		try
		{
			model.addAttribute("package", marketService.getAllItems());
			return "market-page";
		}
		catch (Exception e) {
			model.addAttribute("errorMsg", e.getMessage());
			return "error-page";
		}
	}
	@GetMapping("/search")
	public String getSearchedItemName(@RequestParam(name="name") String name, Model model) {
		try {
            model.addAttribute("package", marketService.getAllItemsByItemName(name));
            return "market-page" + name;
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page"; 
        }
	}
}

