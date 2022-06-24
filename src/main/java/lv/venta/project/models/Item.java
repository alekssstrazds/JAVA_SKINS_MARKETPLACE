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
@Table(name="ItemTable")

public class Item {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="ItemID")
	private int itemID;

	@Column(name="ItemName")
	private String itemName;
	
	@Column(name="PatternIDs")
	@Min(value = 0)
	@Max(value = 1000)
	private int patternIDs;
	
	@Column(name="ItemFloat")
	@Min(value = 0)
	@Max(value = 1)
	private double itemFloat;
	
	@Column(name="ItemSuggestedPrice")
	@Min(value = 0)
	@Max(value = 1000000)
	private double itemSuggestedPrice;
	
	@Column(name="ItemSalePrice")
	@Min(value = 0)
	@Max(value = 1000000)
	private double itemSalePrice;
	
	@Column(name= "ItemSubType")
	private ItemSubType itemSubType;
	
	@Column(name= "ItemType")
	private ItemType itemType;
	
	@Column(name= "ItemRarity")
	private ItemRarity itemRarity;
	
	@Column(name= "ItemQuality")
	private ItemQuality itemQuality;
	
	//Saite uz inventory
	@ManyToOne
    @JoinColumn(name="InventoryID")
    private Inventory inventoryItem;
	
	//Saite uz market
	@ManyToOne
	@JoinColumn(name="MarketID")
	private Market market;
	
	//Saite uz ShoppingCart
	@ManyToMany
	@JoinTable(joinColumns=@JoinColumn(name="ItemID"),
	inverseJoinColumns=@JoinColumn(name="CartID"))
	private Collection<ShoppingCart> carts = new ArrayList<ShoppingCart>();

	public Item(ItemSubType itemSubType, String itemName, int patternIDs, double itemFloat,
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
