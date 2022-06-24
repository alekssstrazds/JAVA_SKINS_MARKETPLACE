package lv.venta.project.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name="InventoryTable")

public class Inventory {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="InventoryID")
	private int inventoryID;
	
	@Column(name= "GameType")
	private GameType gameType;
	
	//Saite uz user
	@OneToOne(mappedBy="inventory")
	@ToString.Exclude
	private User user;
	
	//Saite uz item
	@OneToMany(mappedBy="inventoryItem")
	@ToString.Exclude
	private Collection<Item> inventoryItems = new ArrayList<Item>();
	
	public void addItemToInventory(Item item) {
		this.inventoryItems.add(item);
	}

	public Inventory(GameType gameType) {
		super();
		this.gameType = gameType;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryID=" + inventoryID + ", gameType=" + gameType + ", user=" + user + "]";
	}



	

}
