package com.travel.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.travel.model.TravelModel;
import com.travel.model.admin;
import com.travel.model.jwtReponseModel;
import com.travel.repository.TravelRepository;
import com.travel.repository.adminrepository;
import com.travel.service.JwtUserDetailsService;
import com.travel.service.mailService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TravelController {
	@Autowired
	mailService mailservice;
	@Autowired
	TravelRepository trepo;
     @Autowired
     adminrepository adminrepo;
     //@Autowired
   //  private JwtTokenUtil jwtUtil;
     //@Autowired
//     private JwtUserDetailsService userService;
//     @Autowired
     //private JwtTokenUtil tokenService;
     @GetMapping("/welcome")
     public String getUserss()
     {
    	 return "Hello Welcome this is just testing";
    	 
     }
	@PostMapping("/login")
	public TravelModel getUser(@RequestBody TravelModel model) throws Exception {	
		//try {
		//return trepo.findByUsernameAndPassword(model.getUsername(), model.getPassword());
			System.out.println("step1"+model.getUsername()+model.getPassword());
	//authManager.authenticate(new UsernamePasswordAuthenticationToken(model.getUsername(), model.getPassword()));
//		}
//		catch(UsernameNotFoundException e) {
//			System.out.println("step 2");
//			throw new Exception("Bad Credentials");
//		}
//		catch(BadCredentialsException e){
//			e.printStackTrace();
//			throw new Exception("Bad Credentials");
//		}
		System.out.println("getting userdetails");
		
	//UserDetails userDetails=this.userService.loadUserByUsername(model.getUsername());
	//System.out.println("userdetails"+userDetails);
	//String token=this.jwtUtil.generateToken(userDetails);
	//System.out.println("token"+token);
	//return ResponseEntity.ok(new jwtReponseModel(token));
	return trepo.findByUsernameAndPassword(model.getUsername(), model.getPassword());
	
	}
	
	@GetMapping("/register/{username}")
	public TravelModel confirmUser(@PathVariable("username") String username) {
		System.out.println("uname"+username);
		return trepo.findByUsername(username);
	}
		@PostMapping("/admin-login")
	public admin getUser(@RequestBody admin admin) {
		return adminrepo.findByUsernameAndPassword(admin.getUsername(), admin.getPassword());
	}	
@PutMapping("/update")
@Transactional
public ResponseEntity<?> updateuser(@RequestBody TravelModel model)
{
	trepo.deleteUsersByUsername(model.getUsername());
	System.out.println("email"+model.getUsername());
	String pass = mailservice.generatePassword();
	model.setPassword(pass);
	System.out.println(model.getTitle());
	String fn = model.getFirstname();
	String newusername = mailservice.createUsername(fn);
	while (trepo.findByUsername(newusername) != null) {
		System.out.println(newusername);
		newusername = mailservice.createUsername(fn);
	}
	model.setUsername(newusername);
	try {
		trepo.save(model);
	} catch (Exception ex) {
		System.out.println("email already used");
		return ResponseEntity.status(HttpStatus.FORBIDDEN)
				.body("Email Address or Phone Number Already in use Please Try Another one");
	}
	boolean res = mailservice.sendEmail(newusername, pass, "Nagarro Travel Portal Information", model.getEmail());
	System.out.print("this is response" + res);
	if (res == true) {

		return new ResponseEntity<Object>(202, HttpStatus.OK);
	} else {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error try Again");
	}
}
@Transactional
@PostMapping("newpassword")
public ResponseEntity<?> newPassword(@RequestBody String email)
{
	String pass = mailservice.generatePassword();
	trepo.updateByEmail(email,pass);
	TravelModel user=trepo.findByEmail(email);
	System.out.println("password"+pass+"username"+user.getUsername());
	boolean res = mailservice.sendEmail(user.getUsername(), pass, "Nagarro Travel Portal Information",email);
	if(res==true)
	return new ResponseEntity<Object>(202, HttpStatus.OK);
	return new ResponseEntity<Object>(404, HttpStatus.BAD_REQUEST);
}
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody TravelModel model) {
		String pass = mailservice.generatePassword();
		model.setPassword(pass);
		String fn = model.getFirstname();
		String newusername = mailservice.createUsername(fn);
		while (trepo.findByUsername(newusername) != null) {
			System.out.println(newusername);
			newusername = mailservice.createUsername(fn);
		}
		model.setUsername(newusername);
		trepo.save(model);
//		try {
//			trepo.save(model);
//		} catch (Exception ex) {
//			System.out.println("email already used");
//			return ResponseEntity.status(HttpStatus.FORBIDDEN)
//					.body("Email Address or Phone Number Already in use Please Try Another one");
//		}
		boolean res = mailservice.sendEmail(newusername, pass, "Nagarro Travel Portal Information", model.getEmail());
		System.out.print("this is response" + res);
		if (res == true) {

			return new ResponseEntity<Object>(202, HttpStatus.OK);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error try Again");
		}
	}
}
