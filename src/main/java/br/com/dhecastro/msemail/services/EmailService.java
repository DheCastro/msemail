package br.com.dhecastro.msemail.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.dhecastro.msemail.entities.Email;
import br.com.dhecastro.msemail.enums.EmailStatus;
import br.com.dhecastro.msemail.iservice.IEmailService;
import br.com.dhecastro.msemail.repositories.EmailRepository;

@Service
public class EmailService implements IEmailService {

	@Autowired
	private EmailRepository emailRepository;
	
	@Autowired
    private JavaMailSender emailSender;

	public Email sendEmail(Email emailModel) {
        emailModel.setSendDateEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            emailSender.send(message);

            emailModel.setStatusEmail(EmailStatus.SENT);
        } catch (MailException e){
            emailModel.setStatusEmail(EmailStatus.ERROR);
        } finally {
            emailModel = emailRepository.save(emailModel);
        }
        
        return emailModel;
    }

    public Page<Email> findAll(Pageable pageable) {
        return  emailRepository.findAll(pageable);
    }

    public Optional<Email> findById(UUID emailId) {
        return emailRepository.findById(emailId);
    }
}
