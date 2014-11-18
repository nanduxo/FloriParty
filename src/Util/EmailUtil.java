package Util;

import java.util.Date;
import java.util.Properties;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {
	
	public static void enviarEmail(String destinatario, String assunto, String conteudo) throws AddressException, MessagingException {
		Authenticator authenticator = getAuthenticator();
		InternetAddress remetente = new InternetAddress(getFrom()); 
		InternetAddress destinatarioEmail = new InternetAddress(destinatario);
		Properties properties = getProperties();
		
		Session session = Session.getDefaultInstance(properties, authenticator);
		
		Message msg = new MimeMessage(session);
		
		msg.setFrom(remetente);
		msg.setSentDate(new Date());
		
		msg.setRecipient(Message.RecipientType.TO, destinatarioEmail);
		msg.setSubject(assunto);
		msg.setText(conteudo);
		
//		session.setDebug(true);
		Transport.send(msg);
	}

	private static String getFrom() {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		return context.getInitParameter("usuario");
	}

	private static Authenticator getAuthenticator() {
		final ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		
		return new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(context.getInitParameter("usuario"),
						context.getInitParameter("senha"));
			}
		};
	}

	private static Properties getProperties() {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		
		Properties properties = new Properties();
		properties.put("mail.smtp.host", context.getInitParameter("servidor"));
		properties.put("mail.smtp.port", context.getInitParameter("porta"));
		properties.put("mail.smtp.auth", context.getInitParameter("auth"));
		properties.put("mail.smtp.starttls.enable", context.getInitParameter("tls"));

//		properties.put("mail.smtp.debug", "true");
		
		return properties;
	}
}
