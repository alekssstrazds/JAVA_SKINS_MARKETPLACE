package lv.venta.project.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name="UserAuthority")

public class UserAuthority {
	@Column(name="Authority_ID")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int authorityID;
	
	@Column(name="Authority_UserName")
	private String authorityUserName;
	
	@Column(name="Authority_Password")
	private String authorityPassword;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "user_authorities", joinColumns = @JoinColumn(name = "Authority_ID"), 
			  inverseJoinColumns = @JoinColumn(name = "User_ID"))
	private Collection<User> users;

	public UserAuthority(Collection<User> users) {
		super();
		this.users = users;
	}

	public UserAuthority(String authorityUserName, String authorityPassword, Collection<User> users) {
		super();
		this.authorityUserName = authorityUserName;
		this.authorityPassword = authorityPassword;
		this.users = users;
	}

	public UserAuthority(String authorityUserName, String authorityPassword) {
		super();
		users = new ArrayList<User>();
		this.authorityUserName = authorityUserName;
		this.authorityPassword = authorityPassword;
	}

	public void setUser(User user)
	{
		users.add(user);
	}
}
