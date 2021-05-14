package com.travel.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TravelModel",uniqueConstraints=@UniqueConstraint(columnNames={"email","username","telephone","userid"}))
public class TravelModel implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userid;
	@Column(length=50,unique=true)
	private String username;
	
	@Column(length=50)
    public String firstname;
	 @Column(length=50)
    public String lastname;
    @Column(length=50)
    public String businessunit;
    @Column(length=50)
    public String title;
    @Column(length=50,unique=true)
    public String email;
    @Column(length=50)
    public String password;
    @Column(length=120,unique=true)
    public String telephone;
    @Column(length=120)
    public String address1;
    @Column(length=50)
    @JsonIgnore
    public String address2;
    @Column(length=50)
    public String city;
    @Column(length=50)
    public String state;
    @Column(length=50)
    public String zip;
    @Column(length=50)
    public String country;
    @OneToMany(mappedBy = "modl",targetEntity=ticket_req.class)
    @JsonIgnore
    private List<TravelModel> tickets=new ArrayList<>();
    
    public List<TravelModel> getTickets() {
		return tickets;
	}

	public void setTickets(List<TravelModel> tickets) {
		this.tickets = tickets;
	}

	public TravelModel(String username, int userid, String firstname, String lastname, String businessunit,
			String title, String email, String password, String telephone, String address1, String address2,
			String city, String state, String zip, String country, ticket_req ticket) {
		super();
		this.username = username;
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.businessunit = businessunit;
		this.title = title;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
//		this.ticket = ticket;
	}
	
//	  public ticket_req getTicket() {
//		return ticket;
//	}
	public void setTicket(ticket_req ticket) {
//		this.ticket = ticket;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public TravelModel(String username, int userid, String firstname, String lastname, String businessunit,
			String title, String email, String password, String telephone, String address1, String address2,
			String city, String state, String zip, String country) {
		super();
		this.username = username;
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.businessunit = businessunit;
		this.title = title;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getBusinessunit() {
		return businessunit;
	}
	public void setBusinessunit(String businessunit) {
		this.businessunit = businessunit;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public TravelModel(String username, String firstname, String lastname, String businessunit, String title,
			String email, String password, String telephone, String address1, String address2, String city,
			String state, String zip, String country) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.businessunit = businessunit;
		this.title = title;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}
	public TravelModel() {
		super();
	}
    
}