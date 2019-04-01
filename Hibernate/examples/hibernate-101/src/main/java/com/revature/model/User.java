package com.revature.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/*
 * Welcome to your first Hibernate application 
 * When mapping hibernate entities with annotations, we only 
 * NEED to use two annotations, @Entity - which maps the class
 * as an entity, and @Id - which indicates its unique id val
 */

@Entity
@Table(name="BLOG_USER")
public class User {
	
	@Id //identifies this column as PK
	@Column(name="USER_ID") //not necessary, can use to apply different name or apply constraints
	//More on @SequenceGenerator at: https://docs.oracle.com/javaee/5/api/javax/persistence/SequenceGenerator.html
	//name(required), optional: allocationSize, initialValue, sequenceName
	@SequenceGenerator(name="U_SEQ_GEN", sequenceName="BLOG_USER_SEQ", allocationSize=1)
	//more on @GeneratedValue at https://www.objectdb.com/java/jpa/entity/generated
	@GeneratedValue(generator="U_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	
	
	//change name of col and apply constraints
	//@Column attributes can be found at https://docs.jboss.org/hibernate/jpa/2.1/api/javax/persistence/Column.html
	@Column(nullable=false, unique=true)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="FOLLOWING", //@JoinTable is used to define the junction table
	joinColumns=@JoinColumn(name="USER_ID"), //specify the column with the main entity
	inverseJoinColumns=@JoinColumn(name="FOLLOWS")) //inverse side of the relationship 
	private Set<User> following = new HashSet<User>(); //will represent people I follow 
	
	public User() {}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

	
}
