package com.emresutisna.siar.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.twmacinta.util.MD5;

/**
 * Entity to hold application user data - first name, last name, etc.
 *
 * @author Nanang Sutisna
 */
@Entity
@Table(name="T_User")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = -2420785595245179365L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="firstname", length=50, nullable=false)
    private String firstName;
	
	@Column(name="lastname", length=50, nullable=false)
    private String lastName;
    
	@Column(name="username", length=50, nullable=false, unique=true)
	private String username;
    
	@Column(name="password", length=200, nullable=false)
	private String password;
    
	@ManyToOne
	@JoinColumn(name="idSubUnitKerja",nullable=false)
	private SubUnitKerja subUnitKerja;
	
	@ManyToMany
	@JoinTable(name="T_User_Role", joinColumns=@JoinColumn(name="idUser"), 
	inverseJoinColumns=@JoinColumn(name="idRole"))
	private List<Role> roles;

	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private StatusUser status;
	
    public String getFirstName() {
    	return firstName;
    }
       
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }
       
    public String getLastName() {
    	return lastName;
    }
       
    public void setLastName(String lastName) {
    	this.lastName = lastName;
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
    	String pass = new MD5(new String(password)).asHex();
        this.password = pass;
    }

	public SubUnitKerja getSubUnitKerja() {
		return subUnitKerja;
	}

	public void setSubUnitKerja(SubUnitKerja subUnitKerja) {
		this.subUnitKerja = subUnitKerja;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public StatusUser getStatus() {
		return status;
	}

	public void setStatus(StatusUser status) {
		this.status = status;
	}
}

