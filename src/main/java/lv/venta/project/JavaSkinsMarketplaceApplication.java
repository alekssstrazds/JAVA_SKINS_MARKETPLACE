package lv.venta.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.project.repos.IInventoryRepo;
import lv.venta.project.repos.IItemRepo;
import lv.venta.project.repos.IMarketRepo;
import lv.venta.project.repos.IShoppingCartRepo;
//import lv.venta.project.repos.IUserAuthorityRepo;
import lv.venta.project.repos.IUserRepo;

@SpringBootApplication
@EnableAutoConfiguration

public class JavaSkinsMarketplaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSkinsMarketplaceApplication.class, args);
	}
	@Bean
	public CommandLineRunner testdb(IInventoryRepo inventoryRepo, IItemRepo itemRepo,
			IMarketRepo marketRepo, IShoppingCartRepo shoppingCartRepo,
			IUserRepo userRepo) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				
				
			}
		};
	}
}
