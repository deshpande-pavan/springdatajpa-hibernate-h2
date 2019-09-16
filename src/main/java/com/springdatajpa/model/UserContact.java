package com.springdatajpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_contact")
public class UserContact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_contact_id")
	private Long id;
	private Long phoneNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_contact_id", referencedColumnName = "user_id")
	private Users user;

	public UserContact() {
		
		//
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

}
