package org.serratec.backend.borracharia.service;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.serratec.backend.borracharia.DTO.BorrachariaDTO;
import org.serratec.backend.borracharia.exception.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;
	
	@Value("${spring.mail.username}")
	private String userName;
	
	@Value("${spring.mail.host}")
	private String host;
	
	@Value("${spring.mail.password}")
	private String senha;
	
	@Value("${spring.mail.email.remetente}")
	private String emailRemetente;

	
	
	public JavaMailSender javaMailSender() {

		JavaMailSenderImpl enviarEmail = new JavaMailSenderImpl();
		Properties prop = new Properties();

		enviarEmail.setHost(host);
		enviarEmail.setPort(465);
		enviarEmail.setUsername(userName);
		enviarEmail.setPassword(senha);
		enviarEmail.setProtocol("smtp");
		enviarEmail.setDefaultEncoding("UTF-8");
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.ssl.enable", true);
		enviarEmail.setJavaMailProperties(prop);
		return enviarEmail;

	}

	public void sendMessage(String to, String subject, String text) throws MessagingException, EmailException{

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(emailRemetente);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}

	public void emailTeste(BorrachariaDTO borrachariaDTO) throws EmailException, MessagingException{
			
			this.emailSender = javaMailSender();
			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			
			try {
				helper.setFrom("tthurler10@gmail.com");
				helper.setTo(emailRemetente);
				
				helper.setSubject("Assunto do Email");
				
				StringBuilder sBuilder = new StringBuilder();
				sBuilder.append("<html>\r\n"
										+ "<body>\r\n"		
										+"<div>\r\n"
								        +"<br/>"
								        +"***********<br/>"
								        +"* 16 BITS *<br/>"
								        +"***********<br/>"
								        +"-------------------<br/>"
								        +"Produto: " +borrachariaDTO.getData() +  "<br/>" 
								        +"Quantidade: " +borrachariaDTO.getServico() +  "<br/>"
								        +"Valor: R$" +borrachariaDTO.getIdCarro()  + "<br/>"
								        +"<br/>"
								        +"-------------------<br/>"
								        +"<br/>"
								        +"Att: 16 Bits <br/>"
								        +"</div>\r\n"
									+"</body>\r\n"
								+"</html>\r\n");
				helper.setText(sBuilder.toString(),true);
				
				emailSender.send(message);
			}catch (Exception e) {
				throw new EmailException("Houve um erro"+ e.getMessage());
			}
		}
}