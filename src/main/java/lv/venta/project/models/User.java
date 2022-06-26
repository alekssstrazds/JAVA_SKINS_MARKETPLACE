package lv.venta.project.models;

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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="UserTable")

public class User {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="UserID")
	private int userID;
	
	@Column(name="Email")
	//@Pattern(regexp="[a-zA-Z\\s]+$")
	private String email;
	
	@Column(name="UserName")
	//@Pattern(regexp="[a-zA-Z\\s]+$")
	private String username;
	
	@Column(name="Password")
	//@Pattern(regexp="[a-zA-Z\\s]+$")
	private String password;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="Active")
	private boolean active;
	
	//Lietotāja balanss
	
	@Column(name="Balance")
	@Min(value = 0)
	@Max(value = 10000)
	private double balance;

	//Saite uz inventory
	@OneToOne
	@JoinColumn(name="InventoryID")
	private Inventory inventory;

	//Saite uz shoppingCart
	@OneToOne
	@JoinColumn(name="CartID")
	private ShoppingCart shoppingCart;
	
	@ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "userRole", joinColumns = @JoinColumn(name = "userId"))
	@Enumerated(EnumType.STRING)
	private Set<Roles> role;

	public User(String email, String username, String password, String address, boolean active, double balance, Inventory inventory, ShoppingCart shoppingCart) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.address = address;
		this.active = active;
		this.balance = balance;
		
		this.inventory = inventory;
		this.shoppingCart = shoppingCart;
	}
	public boolean getActive() {
		return this.active;
	}
	
	@Override
	public String toString() {
		return "User [userID=" + userID + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", address=" + address + ", active=" + active + ", balance=" + balance + "]";
	}

	
}
