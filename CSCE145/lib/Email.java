import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Email {
  public static void main(String[] args) {
    System.getProperties().setProperty("mail.smtp.host", "localhost");

    Session session = Session.getDefaultInstance(System.getProperties());

    MimeMessage message = new MimeMessage(session);

    message.setFrom(new InternetAddress("heath@heath.com"));
    
    message.addRecipient(Message.RecipientType.TO, new InternetAddress("carrollh@email.sc.edu"));

    message.setSubject("Hw 4 results");
    
    String hw4Results = "blaah blah";
    message.setText(hw4Results);

    Transport.send(message);   
  }
}
