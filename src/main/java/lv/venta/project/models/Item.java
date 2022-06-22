package lv.venta.project.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="ItemTable")

public class Item {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="Item_ID")
	private int itemID;
	
	@Column(name="Item_SubType")
	private String itemSubType;

	@Column(name="Item_Name")
	private String itemName;
	
	@Column(name="Pattern_IDs")
	@Min(value = 0)
	@Max(value = 1000)
	private int patternIDs;
	
	@Column(name="Item_Float")
	@Min(value = 0)
	@Max(value = 1)
	private float itemFloat;
	
	@Column(name="Item_Suggested_Price")
	@Min(value = 0)
	@Max(value = 1000000)
	private double itemSuggestedPrice;
	
	@Column(name="Item_Sale_Price")
	@Min(value = 0)
	@Max(value = 1000000)
	private double itemSalePrice;
	
	@Column(name= "ItemType")
	private ItemType itemType;
	
	@Column(name= "ItemRarity")
	private ItemRarity itemRarity;
	
	@Column(name= "ItemQuality")
	private ItemQuality itemQuality;
	
	//Saite uz inventory
	@ManyToOne
    @JoinColumn(name="Inventory_ID")
    private Inventory inventory;
	
	//Saite uz market
	@ManyToOne
	@JoinColumn(name="Market_ID")
	private Market market;
	
	//Saite uz ShoppingCart
	@ManyToMany
	@JoinTable(joinColumns=@JoinColumn(name="Item_ID"),
	inverseJoinColumns=@JoinColumn(name="Cart_ID"))
	private Collection<ShoppingCart> carts = new ArrayList<ShoppingCart>();

	public Item(String itemSubType, String itemName, int patternIDs, float itemFloat,
			double itemSuggestedPrice, double itemSalePrice, ItemType itemType,
			ItemRarity itemRarity, ItemQuality itemQuality) {
		super();
		this.itemSubType = itemSubType;
		this.itemName = itemName;
		this.patternIDs = patternIDs;
		this.itemFloat = itemFloat;
		this.itemSuggestedPrice = itemSuggestedPrice;
		this.itemSalePrice = itemSalePrice;
		
		this.itemType = itemType;
		this.itemRarity = itemRarity;
		this.itemQuality = itemQuality;
	}
	
	
}
