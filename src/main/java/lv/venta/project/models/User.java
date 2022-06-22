package lv.venta.project.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="UserTable")

public class User {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="User_ID")
	private int userID;
	
	@Column(name="Email")
	@Pattern(regexp="[a-zA-Z\\s]+$")
	private String email;
	
	@Column(name="Password")
	@Pattern(regexp="[a-zA-Z\\s]+$")
	private String password;
	
	@Column(name="User_Name")
	@Pattern(regexp="[a-zA-Z\\s]+$")
	private String username;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="Login_Status")
	private boolean loginStatus=true;
	
	//Lietotāja balanss
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="Balance_ID")
	private int balanceID;
	
	@Column(name="Balance")
	@Min(value = 0)
	@Max(value = 10000)
	private double balance;
	
	//Saite uz inventory
	@OneToOne
	@JoinColumn(name="Inventory_ID")
	private Inventory inventory;
	
	//Saite uz autentifikāciju
	@ManyToMany(mappedBy = "users", fetch=FetchType.EAGER)
	private Collection<UserAuthority> authorities;
	
	//Saite uz shoppingCart
	@OneToOne
	@JoinColumn(name="Cart_ID")
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
		
		this.authorities = new ArrayList<UserAuthority>();
	}
}
