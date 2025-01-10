package com.example.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import javax.mail.*;
import javax.mail.internet.*;


public class HelloWorldTasklet implements Tasklet {
	
	private String Name;
	private String Gmail;
	private long Ph_No;
	private String Status;


    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {

    	
    	String host="smtp.gmail.com";  
    	  final String user="msdkishore38@gmail.com";
    	  final String password="theq zdwr hsjq gswz";  
    	    
    	  String to="kishoremohan925@gmail.com";  
    	  String to1="logeshkumar1509@gmail.com";  

    	  
    	   
    	   
    	  Properties props = new Properties();
    	  props.put("mail.smtp.host", host);
    	  props.put("mail.smtp.starttls.enable", "true");
    	  props.put("mail.smtp.ssl.protocols", "TLSv1.2");
    	  props.put("mail.smtp.port", 587);
    	  props.put("mail.smtp.auth", "true");
    	  
    	   Session session = Session.getInstance(props, new javax.mail.Authenticator() {  
    	      protected javax.mail.PasswordAuthentication getPasswordAuthentication() {  
    	    return new javax.mail.PasswordAuthentication(user,password);  
    	      }  
    	    });  
    	  
    	    try {  
    	     MimeMessage message = new MimeMessage(session);  
    	     message.setFrom(new InternetAddress(user)); 
    	     String SelectQuery = "Select * from tasklet";
    	        try (Connection conn = ConnectionsJdbc.getConnection();
    	             PreparedStatement pstmt = conn.prepareStatement(SelectQuery)) {
    	            ResultSet rs = pstmt.executeQuery();

    				if (rs.next()) {
    	                    		    	    
    		    	
    		    	     if(rs.getString("Status").equals("Activate")) {
    		    	    	 message.addRecipient(Message.RecipientType.TO,new InternetAddress(rs.getString("Gmail")));  
    		    	    	 message.setSubject("Your Account is 'Activated'");  
        		    	     message.setText("Hi, "+ rs.getString("Name") + ". Your Account is working");  
        		    	     Transport.send(message);  
    		    	     } else {
    		    	    	 message.addRecipient(Message.RecipientType.TO,new InternetAddress(rs.getString("Gmail")));  
    		    	    	 message.setSubject("Your Account is 'Deactivated'");  
        		    	     message.setText("Hi, "+ rs.getString("Name") + ". Your Account is still not Active");  
        		    	     Transport.send(message);  
    		    	     }
    		    	     
    				}
    				else {
    					System.out.println("Not Completed : Something is Wrong");
    				}
    				conn.close();

    	           
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	     
    	  
    	     System.out.println("message sent successfully...");  
    	   


    	     } catch (MessagingException e) {e.printStackTrace();}  
    	   
    	  
    	return RepeatStatus.FINISHED;
    }
}


