package com.travel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class joinData {
	String status;
	int userid;
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
    public String firstname;
    public String email;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPublished_at() {
		return published_at;
	}
	public void setPublished_at(String published_at) {
		this.published_at = published_at;
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

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public joinData(String firstname,int userid,String email,String status,String published_at,String request_Type,String priority,String travel_City,String from_Location_City,String travel_Start_Date,String travel_End_Date,String passport_Number,String project_Name,String expense_Borne_by,String travel_Approver_Name,String duration_of_Travel) {
		super();
		this.status = status;
		this.userid = userid;
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
		this.firstname = firstname;
		this.email = email;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public joinData() {
		super();
	}
	@Override
	public String toString() {
		return "joinData [status=" + status + ", userid=" + userid + ", published_at=" + published_at
				+ ", request_Type=" + request_Type + ", priority=" + priority + ", travel_City=" + travel_City
				+ ", from_Location_City=" + from_Location_City + ", travel_Start_Date=" + travel_Start_Date
				+ ", travel_End_Date=" + travel_End_Date + ", passport_Number=" + passport_Number + ", project_Name="
				+ project_Name + ", expense_Borne_by=" + expense_Borne_by + ", travel_Approver_Name="
				+ travel_Approver_Name + ", duration_of_Travel=" + duration_of_Travel + ", firstname=" + firstname
				+ ", email=" + email + ", getStatus()=" + getStatus() + ", getPublished_at()=" + getPublished_at()
				+ ", getRequest_Type()=" + getRequest_Type() + ", getPriority()=" + getPriority()
				+ ", getTravel_City()=" + getTravel_City() + ", getFrom_Location_City()=" + getFrom_Location_City()
				+ ", getTravel_Start_Date()=" + getTravel_Start_Date() + ", getTravel_End_Date()="
				+ getTravel_End_Date() + ", getPassport_Number()=" + getPassport_Number() + ", getProject_Name()="
				+ getProject_Name() + ", getExpense_Borne_by()=" + getExpense_Borne_by()
				+ ", getTravel_Approver_Name()=" + getTravel_Approver_Name() + ", getDuration_of_Travel()="
				+ getDuration_of_Travel() + ", getFirstname()=" + getFirstname() + ", getEmail()=" + getEmail()
				+ ", getUserid()=" + getUserid() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
    
}
