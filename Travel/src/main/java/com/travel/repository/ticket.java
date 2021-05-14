package com.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.travel.model.TravelModel;
import com.travel.model.ticket_req;

public interface ticket extends JpaRepository<ticket_req,Integer > {

	List<ticket_req> findByModl(TravelModel user);
	@Modifying
    @Query("delete from ticket_req u where u.modl = ?1")
	void deleteticketByUser(TravelModel user);
	@Modifying
    @Query("update ticket_req t set t.status=?1, t.comments=?4 where t.published_at = ?2 and t.modl=?3")
	void updateStatusByPlublishedAtAndUserid(String status, String published_at, TravelModel user, String string);
    @Query("SELECT t from ticket_req t where t.published_at = ?2 and t.modl=?1")
	ticket_req findByModlAndPublished_at(TravelModel user, String publishedat);
}
