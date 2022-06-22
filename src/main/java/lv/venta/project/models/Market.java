package lv.venta.project.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
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
@Table(name="MarketTable")

public class Market {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="MarketID")
	private int marketID;
	
	@Column(name= "GameType")
	private GameType gameType;
	
	//Saite uz item
	@OneToMany(mappedBy="market")
	@ToString.Exclude
	private Collection<Item> items;

	public Market(GameType gameType) {
		super();
		this.gameType = gameType;
	}
}
