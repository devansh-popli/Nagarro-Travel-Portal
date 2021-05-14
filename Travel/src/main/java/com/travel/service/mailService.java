package com.travel.service;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class mailService {

	@Autowired
	JavaMailSender mailSender;
	Random random=new Random();
	public boolean sendEmail(String username, String password, String subject, String to){
		boolean flag=false;
		MimeMessage m1 = mailSender.createMimeMessage();
		MimeMessageHelper m = new MimeMessageHelper(m1);
		try {
			m.setFrom("dvpopli@gmail.com");
			m.setTo(to);
			m.setSubject(subject);
			String mailcontent="<p>You have requested your user name and password for your access to Nagarro Travel Portal</p>";
			
			mailcontent+="<br><br>Username: "+username;
			mailcontent+="<br>Password: "+password;
			mailcontent+="<br><br>Please Contact the Travel team if you have any questions.<br>";
			mailcontent+="<br><br>Thankyou,<br>";
			mailcontent+="Nagarro Travel Team";
			m.setText(mailcontent,true);
			mailSender.send(m1);
		    flag=true;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return flag;
	}

	public String generatePassword() {
		String letters="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String numbers="0123456789";
		String splchars="@#$%&";
	String pwd=letters+numbers+splchars;
	char[] newpass=new char[8];
		for(int i=0;i<8;i++)
		{
			newpass[i]=pwd.charAt(random.nextInt(pwd.length()));
		}
		return newpass.toString();
	}

	public String createUsername(String firstname) {
		String res=firstname+random.nextInt(10000);
		return res;
	}

}
