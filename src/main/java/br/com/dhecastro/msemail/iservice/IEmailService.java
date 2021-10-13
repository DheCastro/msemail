package br.com.dhecastro.msemail.iservice;

import br.com.dhecastro.msemail.entities.Email;

public interface IEmailService {

	public Email sendEmail(Email emailModel);
}
