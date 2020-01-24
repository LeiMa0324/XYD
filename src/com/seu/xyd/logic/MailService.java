package com.seu.xyd.logic;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.tn17.logic.LogicException;

/**
 * a Mail Service.
 * Not contain BG logic.
 * Not consider about Thread.
 * @author TaurusNing
 *
 */
public abstract class MailService {

	public static final String SMTP_HOST = "smtp.163.com";
	public static final int SMTP_PORT = 25;
	public static final boolean SUPPORT_SSL = false;
	public static final String SMTP_ACCOUNT = "seuxyd";
	public static final String SMTP_ACCOUNT_MAIL_ADDR = "seuxyd@163.com";
	public static final String SMTP_PASSWORD = "seuxyd123456";
	
	/**
	 * From 是固定的
	 * @param title
	 * @param content 纯文本，或不含<html><body>的html片段
	 * @param toMailAddr
	 * @throws LogicException
	 */
	public static void sendMail(String title, String content, String toMailAddr) throws LogicException {
		HtmlEmail email = new HtmlEmail();
		email.setHostName(SMTP_HOST);
		email.setSmtpPort(SMTP_PORT);
		email.setSSLOnConnect(SUPPORT_SSL);
		//email.setAuthenticator(new DefaultAuthenticator(SMTP_ACCOUNT, SMTP_PASSWORD));
		email.setAuthentication(SMTP_ACCOUNT, SMTP_PASSWORD);
		email.setCharset("UTF-8");
		
		email.setSubject(title);
		try {
			email.setFrom(SMTP_ACCOUNT_MAIL_ADDR);
			email.addTo(toMailAddr);
			email.setMsg(content);
			
			//TODO 163 support HTML Msg好像有问题，待查
			//email.setHtmlMsg("<html><body>" + content + "</body></html>");
			
			email.send();
		} catch (EmailException e1) {
			System.out.println(e1.toString());
			throw new LogicException(e1.getMessage());
		}	
	}
}
