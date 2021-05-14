package com.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.travel.model.TravelModel;
import com.travel.model.joinData;

public interface TravelRepository extends JpaRepository<TravelModel,String> {
	TravelModel findByUsernameAndPassword(String username, String password);
       TravelModel findByUsername(String username);
    @Modifying
    @Query("delete from TravelModel u where u.username = ?1")
	void deleteUsersByUsername(String username);
    @Modifying
    @Query("update TravelModel u set u.password=?2 where u.email = ?1")
	void updateByEmail(String email,String Password);
    @Query("SELECT new com.travel.model.joinData(c.firstname,c.userid,c.email,p.status,p.published_at,p.request_Type,p.priority,p.travel_City,p.from_Location_City,p.travel_Start_Date,p.travel_End_Date,p.passport_Number,p.project_Name,p.expense_Borne_by,p.travel_Approver_Name,p.duration_of_Travel) FROM TravelModel c JOIN c.tickets p")
	List<joinData> JoinAndFindData();
	TravelModel findByUserid(int i);
	TravelModel findByEmail(String email);

}
