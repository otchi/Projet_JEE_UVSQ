package fr.uvsq.acsis.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * class qui contient la methode d'envoi de mail
 * 
 * @author amine
 *
 */
public abstract class EnvoiEmail {
	public static final String MAIL_MSG="votre mot de pass est:";
	public static final String BOITE_ENVOI="ouchihaamine@gmail.com";
	public static final String MOT_DE_PASS="********";
	
	public static Boolean envoiEmail(String destinataire,String password,String prenom) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(BOITE_ENVOI, MOT_DE_PASS);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(BOITE_ENVOI));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinataire));
			message.setSubject("incription Agriotes Info");
			message.setText("Bonjour "+prenom+", \n votre mot de pass est : "+password);

			Transport.send(message);
			System.out.println("fait");
			return true;

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	public static void main(String args[]){
		EnvoiEmail.envoiEmail("amineouchiha@hotmail.com", "123", "amine");
	}
}
