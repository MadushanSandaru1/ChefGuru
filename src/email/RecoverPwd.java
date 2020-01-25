/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Random;

/**
 *
 * @author sanda
 */
public class RecoverPwd {

    public static void sendMail(String recepient) throws Exception {
        Random rand = new Random();
        
        System.out.println("Preparing to send email...");
        
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccountEmail = "tg2017233@gmail.com";
        String password = "Sandaru@1";
        
        int randNum = rand.nextInt(1000);
        
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                
                return new PasswordAuthentication(myAccountEmail, password); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        Message message = prepareMessage(session, myAccountEmail, recepient, randNum);
        
        Transport.send(message);
        System.out.println("Message sent successfully...");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient, int randNum) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("TECMIS Recovery Code");
            //message.setText("hey there");
            String htmlCode = "<h3>TECMIS Recovery Code</h3><br><br><p><b>"+randNum+"</b> is Your TECMIS recovery code</p><br><br><br><pre>Admin,<br>Faculty of Technology,<br>University of Ruhuna,<br>Matara, Sri Lanka.</pre>";
            message.setContent(htmlCode, "text/html");
            return message;
                    
        } catch (Exception ex) {
            Logger.getLogger(RecoverPwd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
