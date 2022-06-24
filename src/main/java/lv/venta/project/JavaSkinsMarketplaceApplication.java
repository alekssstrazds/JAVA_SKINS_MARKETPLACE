package lv.venta.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.project.models.GameType;
import lv.venta.project.models.Inventory;
import lv.venta.project.models.Item;
import lv.venta.project.models.ItemQuality;
import lv.venta.project.models.ItemRarity;
import lv.venta.project.models.ItemSubType;
import lv.venta.project.models.ItemType;
import lv.venta.project.models.Market;
import lv.venta.project.models.User;
import lv.venta.project.repos.IInventoryRepo;
import lv.venta.project.repos.IItemRepo;
import lv.venta.project.repos.IMarketRepo;
import lv.venta.project.repos.IShoppingCartRepo;
import lv.venta.project.repos.IUserRepo;

@SpringBootApplication
@EnableAutoConfiguration

public class JavaSkinsMarketplaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSkinsMarketplaceApplication.class, args);
	}
	@Bean
	public CommandLineRunner testdb(IUserRepo userRepo, IInventoryRepo inventoryRepo, IMarketRepo marketRepo, IItemRepo itemRepo, IShoppingCartRepo shoppingCartRepo) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				User user1 = new User("peteris.inukels@gmail.com", "Inkulens", "snelukni111", "liepu iela 4", true, 0.0);
				User user2 = new User("marks.iemesls@gmail.com", "Mar1ks", "11markusins", "sportu iela 1", true, 100.0);
				User user3 = new User("grieta.skata@gmail.com", "Grietas", "grieta.111", "auzu iela 6", true, 1.0);
				userRepo.save(user1);
				userRepo.save(user2);
				userRepo.save(user3);
				
				Inventory inventory1 = new Inventory(GameType.CSGO, user1);
				Inventory inventory2 = new Inventory(GameType.CSGO, user2);
				Inventory inventory3 = new Inventory(GameType.CSGO, user3);
				inventoryRepo.save(inventory1);
				inventoryRepo.save(inventory2);
				inventoryRepo.save(inventory3);
				
				Market marketCSGO = new Market(GameType.CSGO);
				Market marketDOTA = new Market(GameType.DOTA);
				Market marketRUST = new Market(GameType.RUST);
				marketRepo.save(marketCSGO);
				marketRepo.save(marketDOTA);
				marketRepo.save(marketRUST);
				
				Item item1 = new Item(ItemSubType.AK_47, "Redline", 473, 0.33958610, 13.01, 12.55, ItemType.Rifle, ItemRarity.Classified, ItemQuality.Field_Tested);
				Item item2 = new Item(ItemSubType.AK_47, "Redline", 245, 0.22051441, 13.01, 15.60, ItemType.Rifle, ItemRarity.Classified, ItemQuality.Field_Tested);
				Item item3 = new Item(ItemSubType.AK_47, "Redline", 303, 0.16571485, 14.81, 12.55, ItemType.Rifle, ItemRarity.Classified, ItemQuality.Field_Tested);
				Item item4 = new Item(ItemSubType.AWP, "Wildfire", 582, 0.06752524, 109.20, 95.18, ItemType.Rifle, ItemRarity.Covert, ItemQuality.Factory_New);
				Item item5 = new Item(ItemSubType.AWP, "Wildfire", 606, 0.09571485, 70.58 , 65.50, ItemType.Rifle, ItemRarity.Covert, ItemQuality.Minimal_Wear);
				Item item6 = new Item(ItemSubType.AWP, "Wildfire", 783, 0.56571485, 27.19, 33.23, ItemType.Rifle, ItemRarity.Covert, ItemQuality.Battle_Scarred);
				Item item7 = new Item(ItemSubType.KNIFE, "Butterfly Knife | Tiger Tooth", 75, 0.02571485, 1159.08, 1024.99, ItemType.Knife, ItemRarity.Extraordinary, ItemQuality.Factory_New);
				Item item8 = new Item(ItemSubType.KNIFE, "Karambit | Tiger Tooth", 851, 0.05671485, 738.08, 626.99, ItemType.Knife, ItemRarity.Extraordinary, ItemQuality.Factory_New);
				Item item9 = new Item(ItemSubType.KNIFE, "M9 Bayonet | Tiger Tooth", 514, 0.02881485, 607.15, 549.90, ItemType.Knife, ItemRarity.Extraordinary, ItemQuality.Factory_New);
				itemRepo.save(item1);
				itemRepo.save(item2);
				itemRepo.save(item3);
				itemRepo.save(item4);
				itemRepo.save(item5);
				itemRepo.save(item6);
				itemRepo.save(item7);
				itemRepo.save(item8);
				itemRepo.save(item9);
				
				/*inventory1.addItemToInventory(item1);
				inventory2.addItemToInventory(item2);
				inventory3.addItemToInventory(item3);
				inventory1.addItemToInventory(item4);
				inventory2.addItemToInventory(item5);
				inventory3.addItemToInventory(item6);
				inventory1.addItemToInventory(item7);
				inventory2.addItemToInventory(item8);
				inventory3.addItemToInventory(item9);
				inventoryRepo.save(inventory1);
				inventoryRepo.save(inventory2);
				inventoryRepo.save(inventory3);*/
				
				
			}
		};
	}
}
