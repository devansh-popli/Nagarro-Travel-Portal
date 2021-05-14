package com.travel.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.model.TravelModel;
import com.travel.model.ticket_req;
import com.travel.repository.ticket;

@Service
public class ticketService {
@Autowired
ticket ticketrepo;


	public ticket_req getLatestTicket(TravelModel user) {
		List<ticket_req> tickets=ticketrepo.findByModl(user);
		List<LocalDateTime> dates=new ArrayList<>();
		ticket_req latestticket=null;
		LocalDateTime prevdate=null;
		for(ticket_req ticket :tickets)
		{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
		LocalDateTime newDate = LocalDateTime.parse(ticket.getPublished_at(), formatter);
		if(prevdate==null)
		{
			prevdate=newDate;
			latestticket=ticket;
		}
		else if(newDate.isAfter(prevdate))
		{
			prevdate=newDate;
			latestticket=ticket;
		}
		dates.add(newDate);		
	}
		return latestticket;
}
}
