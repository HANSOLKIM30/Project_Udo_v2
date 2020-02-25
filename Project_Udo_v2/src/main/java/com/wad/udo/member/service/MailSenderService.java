package com.wad.udo.member.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailSenderService")
public class MailSenderService {

	@Autowired
	private JavaMailSender sender;
	
	// 이메일 인증 진행
	public void sendVerifyMail(HttpServletRequest request, String uId, String code) {
	
		MimeMessage message = sender.createMimeMessage();
		
		try {
			
			// 메일 제목 설정
			message.setSubject("[UDO] 계정을 인증해 주세요.", "UTF-8");
			
			// 이메일 인증을 위한 링크 주소 host 설정
			String scheme = request.getScheme() + "://";
			String serverName = request.getServerName();
			String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
			String contextPath = request.getContextPath();
			
			// 메일 본문 설정
			String htmlMsg = "<h1>[UDO] 회원가입을 축하드립니다.</h1>";
			htmlMsg += "<h3>안녕하세요.<br> 이메일 계정을 인증 받으시려면 아래 링크를 클릭해주세요.</h3><br><h3><a href='"+scheme+serverName+serverPort+contextPath+"/member/verify?uId="+uId+"&code="+code+"'>이메일 인증하기</a></h3>";
			message.setText(htmlMsg, "UTF-8", "html");
			
			message.addRecipient(RecipientType.TO, new InternetAddress(uId, "고객", "UTF-8"));

			sender.send(message);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 인증 이메일 재송부
	public void reSendVerifyMail(HttpServletRequest request, String uId, String code) {
		
		MimeMessage message = sender.createMimeMessage();
		
		try {
			// 메일 제목 설정
			message.setSubject("[UDO] 계정을 인증해 주세요.", "UTF-8");
			
			// 이메일 인증을 위한 링크 주소 host 설정
			String scheme = request.getScheme() + "://";
		    String serverName = request.getServerName();
		    String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
		    String contextPath = request.getContextPath();
		    
		    // 메일 본문 설정
		    String htmlMsg = "<h1>[UDO] 이메일 계정을 인증해주세요.</h1>";
		 	htmlMsg += "<h3>안녕하세요.<br> 이메일 계정을 인증 받으시려면 아래 링크를 클릭해주세요.</h3><br><h3><a href='"+scheme+serverName+serverPort+contextPath+"/member/verify?uId="+uId+"&code="+code+"'>이메일 인증하기</a></h3>";
		 	message.setText(htmlMsg, "UTF-8", "html");
		 			
		 	message.addRecipient(RecipientType.TO, new InternetAddress(uId, "고객", "UTF-8"));

		 	sender.send(message);
		    
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 임시 비밀번호 발급
	public void sendTempPW(String tempPW, String uId) {
		
		MimeMessage message = sender.createMimeMessage();
		
		try {
			message.setSubject("[UDO] 임시 비밀번호 발급", "UTF-8");
			
			String htmlMsg = "<h1>[UDO] 임시비밀번호가 발급되었습니다.</h1>";
			htmlMsg += "<h3>임시비밀번호는 다음과 같습니다.</h3>";
			htmlMsg += "<h3>"+ tempPW +"</h3>";
			message.setText(htmlMsg, "UTF-8", "html");
			
			message.addRecipient(RecipientType.TO, new InternetAddress(uId, "고객님", "UTF-8"));
		
			sender.send(message);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
