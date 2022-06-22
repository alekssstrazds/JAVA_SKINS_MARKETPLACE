package lv.venta.project.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="ShoppingCartTable")

public class ShoppingCart {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="CartID")
	private int cartID;
	
	@Column(name= "GameType")
	private GameType gameType;
	
	//Saite uz user
	@OneToOne(mappedBy="shoppingCart")
	@ToString.Exclude
	private User user;
	
	//Saite uz item
	@ManyToMany(mappedBy="carts")
	private Collection<Item> items;

	public ShoppingCart(GameType gameType) {
		super();
		this.gameType = gameType;
	}
}
