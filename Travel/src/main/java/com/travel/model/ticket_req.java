package com.travel.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="ticket_req")
public class ticket_req {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
int sno;
String status;
String published_at;
String request_Type;
String priority;
String travel_City;
String from_Location_City;
String travel_Start_Date;
String travel_End_Date;
String passport_Number;
String project_Name;
String expense_Borne_by;
@JsonIgnore
String travel_Approver_Name;
@JsonIgnore
String duration_of_Travel;
@JsonIgnore
String upper_bound;
String any_Additional_Details;
String comments;
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}
public ticket_req(int sno, String status, String published_at, String request_Type, String priority, String travel_City,
		String from_Location_City, String travel_Start_Date, String travel_End_Date, String passport_Number,
		String project_Name, String expense_Borne_by, String travel_Approver_Name, String duration_of_Travel,
		String upper_bound, String any_Additional_Details, String comments, TravelModel modl) {
	super();
	this.sno = sno;
	this.status = status;
	this.published_at = published_at;
	this.request_Type = request_Type;
	this.priority = priority;
	this.travel_City = travel_City;
	this.from_Location_City = from_Location_City;
	this.travel_Start_Date = travel_Start_Date;
	this.travel_End_Date = travel_End_Date;
	this.passport_Number = passport_Number;
	this.project_Name = project_Name;
	this.expense_Borne_by = expense_Borne_by;
	this.travel_Approver_Name = travel_Approver_Name;
	this.duration_of_Travel = duration_of_Travel;
	this.upper_bound = upper_bound;
	this.any_Additional_Details = any_Additional_Details;
	this.comments = comments;
	this.modl = modl;
}
@ManyToOne
@JsonIgnore
@JoinColumn(name = "ticket_id", referencedColumnName = "userid")
private TravelModel modl;

public ticket_req() {
	super();
}
public TravelModel getModl() {
	return modl;
}
public void setModl(TravelModel modl) {
	this.modl = modl;
}
public int getSno() {
	return sno;
}
public String getPublished_at() {
	return published_at;
}
public void setPublished_at(String published_at) {
	this.published_at = published_at;
}

public void setSno(int sno) {
	this.sno = sno;
}

//public Date getPublished_at() {
//	return published_at;
//}
//public void setPublished_at(Date published_at) {
//	this.published_at = published_at;
//}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getRequest_Type() {
	return request_Type;
}
public void setRequest_Type(String request_Type) {
	this.request_Type = request_Type;
}
public String getPriority() {
	return priority;
}
public void setPriority(String priority) {
	this.priority = priority;
}
public String getTravel_City() {
	return travel_City;
}
public void setTravel_City(String travel_City) {
	this.travel_City = travel_City;
}
public String getFrom_Location_City() {
	return from_Location_City;
}
public void setFrom_Location_City(String from_Location_City) {
	this.from_Location_City = from_Location_City;
}
public String getTravel_Start_Date() {
	return travel_Start_Date;
}
public void setTravel_Start_Date(String travel_Start_Date) {
	this.travel_Start_Date = travel_Start_Date;
}
public String getTravel_End_Date() {
	return travel_End_Date;
}
public void setTravel_End_Date(String travel_End_Date) {
	this.travel_End_Date = travel_End_Date;
}
public String getPassport_Number() {
	return passport_Number;
}
public void setPassport_Number(String passport_Number) {
	this.passport_Number = passport_Number;
}
public String getProject_Name() {
	return project_Name;
}
public void setProject_Name(String project_Name) {
	this.project_Name = project_Name;
}
public String getExpense_Borne_by() {
	return expense_Borne_by;
}
public void setExpense_Borne_by(String expense_Borne_by) {
	this.expense_Borne_by = expense_Borne_by;
}
public String getTravel_Approver_Name() {
	return travel_Approver_Name;
}
public void setTravel_Approver_Name(String travel_Approver_Name) {
	this.travel_Approver_Name = travel_Approver_Name;
}
public String getDuration_of_Travel() {
	return duration_of_Travel;
}
public void setDuration_of_Travel(String duration_of_Travel) {
	this.duration_of_Travel = duration_of_Travel;
}
public String getAny_Additional_Details() {
	return any_Additional_Details;
}
public void setAny_Additional_Details(String any_Additional_Details) {
	this.any_Additional_Details = any_Additional_Details;
}
public String getUpper_bound() {
	return upper_bound;
}
public void setUpper_bound(String upper_bound) {
	this.upper_bound = upper_bound;
}

public ticket_req(int sno, String status, String request_Type, String priority, String travel_City,
		String from_Location_City, String travel_Start_Date, String travel_End_Date, String passport_Number,
		String project_Name, String expense_Borne_by, String travel_Approver_Name, String duration_of_Travel,
		String upper_bound, String any_Additional_Details, TravelModel modl) {
	super();
	this.sno = sno;
	this.status = status;
	this.request_Type = request_Type;
	this.priority = priority;
	this.travel_City = travel_City;
	this.from_Location_City = from_Location_City;
	this.travel_Start_Date = travel_Start_Date;
	this.travel_End_Date = travel_End_Date;
	this.passport_Number = passport_Number;
	this.project_Name = project_Name;
	this.expense_Borne_by = expense_Borne_by;
	this.travel_Approver_Name = travel_Approver_Name;
	this.duration_of_Travel = duration_of_Travel;
	this.upper_bound = upper_bound;
	this.any_Additional_Details = any_Additional_Details;
	this.modl = modl;
}
@Override
public String toString() {
	return "ticket_req [sno=" + sno + ", status=" + status + ", request_Type=" + request_Type + ", priority=" + priority
			+ ", travel_City=" + travel_City + ", from_Location_City=" + from_Location_City + ", travel_Start_Date="
			+ travel_Start_Date + ", travel_End_Date=" + travel_End_Date + ", passport_Number=" + passport_Number
			+ ", project_Name=" + project_Name + ", expense_Borne_by=" + expense_Borne_by + ", travel_Approver_Name="
			+ travel_Approver_Name + ", duration_of_Travel=" + duration_of_Travel + ", upper_bound=" + upper_bound
			+ ", any_Additional_Details=" + any_Additional_Details + ", ticket_id=" + modl + "]";
}
}