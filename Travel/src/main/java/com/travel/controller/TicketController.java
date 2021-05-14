package com.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travel.model.TravelModel;
import com.travel.model.joinData;
import com.travel.model.ticket_req;
import com.travel.repository.TravelRepository;
import com.travel.repository.ticket;
import com.travel.service.ticketService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {
@Autowired
ticket ticketrepo;
@Autowired
TravelRepository tr;
@Autowired
ticketService ticketservice;
	@PostMapping("/newticket/{username}")
	public ResponseEntity<?> newTicket(@RequestBody ticket_req ticke,@PathVariable("username") String username) {
		System.out.println(ticke.toString());
		System.out.println(username);
		TravelModel model=tr.findByUsername(username);
		ticke.setModl(model);
		ticketrepo.save(ticke);
		return new ResponseEntity<Object>(202,HttpStatus.OK);	
	}
	@Transactional
	@PutMapping("/update-ticket/{email}")
	public ResponseEntity<?> upadteTicket(@RequestBody ticket_req ticke,@PathVariable("email") String email) {
		System.out.println(ticke.toString());
		System.out.println(email);
		TravelModel user=tr.findByEmail(email);
		ticket_req latestticket=ticketservice.getLatestTicket(user);
		ticketrepo.delete(latestticket);
		ticke.setModl(user);
		ticketrepo.save(ticke);
		return new ResponseEntity<Object>(202,HttpStatus.OK);	
	}
	@Transactional
	@PutMapping("/update-ticket-admin/{userid}")
	public ResponseEntity<?> updateTicketadmin(@RequestBody ticket_req ticke,@PathVariable("userid") String userid) {
		System.out.println(ticke.toString());
		TravelModel user=tr.findByUserid(Integer.parseInt(userid));
		System.out.println("status"+ticke.getStatus());
		ticketrepo.updateStatusByPlublishedAtAndUserid(ticke.getStatus(),ticke.getPublished_at(),user,ticke.getComments());
		return new ResponseEntity<Object>(202,HttpStatus.OK);	
	}
	@GetMapping("/getticket/{email}")
	public ticket_req confirmUserbyusername(@PathVariable("email") String email) {
		System.out.println("emailforticket"+email);
		TravelModel user=tr.findByEmail(email);
		ticket_req latestticket=ticketservice.getLatestTicket(user);
		System.out.println(latestticket.toString());
		return latestticket;
	}
	@GetMapping("/get-ticket-admin/{userid}/{publishedat}")
	public ticket_req confirmUserbyusername(@PathVariable("userid") String userid,@PathVariable("publishedat") String publishedat) {
		TravelModel user=tr.findByUserid(Integer.parseInt(userid));
		return  ticketrepo.findByModlAndPublished_at(user,publishedat);
	}
	@GetMapping("/getalltickets")
	public List<joinData> getAllTickets() {
		List<joinData> tickets=tr.JoinAndFindData();
		for(joinData ticket:tickets)
		{
			System.out.println(ticket.toString());
		}
		return tickets;
	}
	@GetMapping("/gettickets/{email}")
	public List<ticket_req> getAllTickets(@PathVariable("email") String email) {
		System.out.println("emailforticket"+email);
		TravelModel user=tr.findByEmail(email);
		List<ticket_req> tickets=ticketrepo.findByModl(user);
		return tickets;
	}
	
}
