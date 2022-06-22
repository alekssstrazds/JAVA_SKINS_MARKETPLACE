package lv.venta.project.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
@Table(name="UserTable")

public class User {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="UserID")
	private int userID;
	
	@Column(name="UserName")
	@Pattern(regexp="[a-zA-Z\\s]+$")
	private String username;
	
	@Column(name="Password")
	@Pattern(regexp="[a-zA-Z\\s]+$")
	private String password;
	
	@Column(name="Active")
	private boolean active;
	
	@ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "userRole", joinColumns = @JoinColumn(name = "userId"))
	@Enumerated(EnumType.STRING)
	private Set<Roles> role;
	
	//Saite uz inventory
	@OneToOne
	@JoinColumn(name="InventoryID")
	private Inventory inventory;
	
	//Saite uz shoppingCart
	@OneToOne
	@JoinColumn(name="CartID")
	private ShoppingCart shoppingCart;

	public User(String username, String password, boolean active) {
		super();
		
		this.password = password;
		this.username = username;
		this.active = active;
		
	}
}
