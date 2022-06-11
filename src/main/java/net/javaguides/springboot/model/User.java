package net.javaguides.springboot.model;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name ="Persons")
public class User {

	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Long id;
	
	@Column(name="person_id")
	private int PersonId;
	
	@Column(name="user_name")
	private String UserName;
	
	@Column(name="Password")
	private String Password;
	
	@Column(name="type")
	private String type;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Address")
	private String Address;
	
	@Column(name="Phone")
	private String PhoneNumber;
	
	
	public User(){
		
	}

	public int getPersonId() {
		return PersonId;
	}


	public void setPersonId(int personId) {
		PersonId = personId;
	}


	public String getUserName() {
		return UserName;
	}


	public void setUserName(String userName) {
		UserName = userName;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getPhoneNumber() {
		return PhoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}



	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User(int personId, String userName, String password, String type, String email, String address,
			String phoneNumber) {
		super();
		PersonId = personId;
		UserName = userName;
		Password = password;
		this.type = type;
		this.email = email;
		Address = address;
		PhoneNumber = phoneNumber;
	}

	public boolean checklogin(Object O)
	{
		User u=(User)O;
		return Objects.equals(this.getEmail(), u.getEmail()) && Objects.equals(this.getPassword(), u.getPassword());
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User u = (User) o;
		return 
			Objects.equals(this.UserName, u.UserName) &&
			Objects.equals(this.PersonId, u.PersonId) &&
			Objects.equals(this.Password, this.Password) &&
			Objects.equals(this.Address, u.Address) &&
			Objects.equals(this.PhoneNumber, u.PhoneNumber) &&
			Objects.equals(this.email, u.email);
	}
	@Override
	public int hashCode() {

		return Objects.hash( UserName, PersonId, email, Password, Address, PhoneNumber);
	}
	@Override
	public String toString() {
		return "User{" +
			", userName='" + UserName + '\'' +
			", Address='" + Address + '\'' +
			", PhoneNumber='" + PhoneNumber + '\'' +
			", email='" + email + '\'' +
			", Password='" + Password + '\'' +
			", PersonId='" + PersonId + '\'' +
			'}';
	}
	public User(User obj) {
		super();
		PersonId = obj.getPersonId();
		UserName = obj.getUserName();
		Password = obj.getPassword();
		this.email = obj.getEmail();
		Address = obj.getAddress();
		PhoneNumber = obj.getPassword();
	}
	public void copy(User obj) {
		
		this.PersonId = obj.getPersonId();
		this.UserName = obj.getUserName();
		this.Password = obj.getPassword();
		this.email = obj.getEmail();
		this.Address = obj.getAddress();
		this.PhoneNumber = obj.getPassword();
		this.type= obj.getType();
	}
	public void print()
	{
		System.out.println(this.Address);
		System.out.println(this.email);
		System.out.println(this.Password);
		System.out.println(this.PersonId);
		System.out.println(this.PhoneNumber);
		System.out.println(this.UserName);
	}
}
