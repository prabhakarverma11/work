/**
 * 
 */
package com.dq.arq.sme.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author prabhakar
 *
 */
@Entity
@Table(name = "user", catalog = "eventmate")
public class ContactDo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String password;
	private String emailId;
	private String phoneNumber;
	private boolean isLoggedIn;
	public ContactDo(){
		
	}
	public ContactDo(String name, String password,String emailId,String phoneNumber){
		this.name = name;
		this.password = password;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "email_id")
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Column(name = "phone_number")
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Column(name = "is_logged_in")
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
}
