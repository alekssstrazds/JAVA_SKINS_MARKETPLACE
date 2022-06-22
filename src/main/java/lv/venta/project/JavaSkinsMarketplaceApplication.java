package lv.venta.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.project.models.User;
import lv.venta.project.repos.IUserRepo;

@SpringBootApplication
@EnableAutoConfiguration

public class JavaSkinsMarketplaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSkinsMarketplaceApplication.class, args);
	}
	@Bean
	public CommandLineRunner testdb(IUserRepo userRepo) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				
				User us1 = new User("a", "a", true);
			}
		};
	}
}
