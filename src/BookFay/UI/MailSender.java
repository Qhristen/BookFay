package BookFay.UI;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import javax.swing.JOptionPane;

public class MailSender
{
final String senderEmailID = "odeyxtian@gmail.com";
final String senderPassword = "themanger";
final String emailSMTPserver = "smtp.gmail.com";
final String emailServerPort = "465";
String receiverEmailID = null;
static String emailSubject;
static String emailBody;
public MailSender(String receiverEmailID, String emailSubject, String emailBody)
{
this.receiverEmailID=receiverEmailID;
this.emailSubject=emailSubject;
this.emailBody=emailBody;
Properties props = new Properties();
props.put("mail.smtp.user",senderEmailID);
props.put("mail.smtp.host", emailSMTPserver);
props.put("mail.smtp.port", emailServerPort);
props.put("mail.smtp.starttls.enable", "true");
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.socketFactory.port", emailServerPort);
props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
props.put("mail.smtp.socketFactory.fallback", "false");
SecurityManager security = System.getSecurityManager();
try
{
Authenticator auth = new SMTPAuthenticator();
Session session = Session.getInstance(props, auth);
MimeMessage msg = new MimeMessage(session);
msg.setText(emailBody);
msg.setSubject(emailSubject);
msg.setFrom(new InternetAddress(senderEmailID));
msg.addRecipient(Message.RecipientType.TO,
new InternetAddress(receiverEmailID));


int confirmAction =  JOptionPane.showConfirmDialog(null, "Send Notification?", "Confirm action", JOptionPane.YES_NO_OPTION);
          if(confirmAction == 0){
             Transport.send(msg); 
             JOptionPane.showMessageDialog(null, "Message Sent successfully....");
          }

System.out.println("Message send Successfully:)");

}
catch (Exception mex)
{
mex.printStackTrace();
}
}
public class SMTPAuthenticator extends javax.mail.Authenticator
{
public PasswordAuthentication getPasswordAuthentication()
{
return new PasswordAuthentication(senderEmailID, senderPassword);
}
}

}