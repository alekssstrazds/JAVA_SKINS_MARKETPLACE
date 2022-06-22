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
	
	@Column(name="Email")
	@Pattern(regexp="[a-zA-Z\\s]+$")
	private String email;
	
	@Column(name="Password")
	@Pattern(regexp="[a-zA-Z\\s]+$")
	private String password;
	
	@Column(name="UserName")
	@Pattern(regexp="[a-zA-Z\\s]+$")
	private String username;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="LoginStatus")
	private boolean loginStatus=true;
	
	//Lietotāja balanss
	
	@Column(name="Balance")
	@Min(value = 0)
	@Max(value = 10000)
	private double balance;
	
	@ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "userRole", joinColumns = @JoinColumn(name = "userId"))
	@Enumerated(EnumType.STRING)
	private Set<Roles> role;
	
	//Saite uz inventory
	@OneToOne
	@JoinColumn(name="InventoryID")
	private Inventory inventory;
	
	/*//Saite uz autentifikāciju
	@ManyToMany(mappedBy = "users", fetch=FetchType.EAGER)
	private Collection<UserAuthority> authorities;*/
	
	//Saite uz shoppingCart
	@OneToOne
	@JoinColumn(name="CartID")
	private ShoppingCart shoppingCart;

	public User(String email, String password, String username, String address,
			boolean loginStatus, double balance, Inventory inventory) {
		super();
		this.email = email;
		this.password = password;
		this.username = username;
		this.address = address;
		this.loginStatus = loginStatus;
		this.balance = balance;
		this.inventory = inventory;
		
		//this.authorities = new ArrayList<UserAuthority>();
	}
}
