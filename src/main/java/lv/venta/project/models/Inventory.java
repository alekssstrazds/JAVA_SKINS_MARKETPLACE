package lv.venta.project.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name="InventoryTable")

public class Inventory {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="Inventory_ID")
	private int inventoryID;
	
	@Column(name= "gameType")
	private GameType gameType;
	
	//Saite uz user
	@OneToOne(mappedBy="inventory")
	@ToString.Exclude
	private User user;
	
	//Saite uz item
	@OneToMany(mappedBy="inventory")
	@ToString.Exclude
	private Collection<Item> items;

	public Inventory(GameType gameType) {
		super();
		this.gameType = gameType;
	}
}
