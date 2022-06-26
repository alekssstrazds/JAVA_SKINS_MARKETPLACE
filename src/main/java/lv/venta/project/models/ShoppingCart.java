package lv.venta.project.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	@OneToMany(mappedBy="shoppingCart")
	@ToString.Exclude
	private Collection<Item> cartItems = new ArrayList<Item>();
	
	public void addItemToCart(Item item) {
		this.cartItems.add(item);
	}

	public ShoppingCart(GameType gameType) {
		super();
		this.gameType = gameType;
	}

	@Override
	public String toString() {
		return "ShoppingCart [cartID=" + cartID + ", gameType=" + gameType + ", cartItems=" + cartItems + "]";
	}
	
	
}
