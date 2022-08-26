package com.example.hotelsmail.hotelsmail.service;

import com.example.hotelsmail.hotelsmail.dto.MailDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class MailService {

    private final JavaMailSender javaMailSender;

    private final String sender = "kafeinhotel@gmail.com";

    public void sendMail(MailDTO mailDTO) {

        try {

            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo(mailDTO.getTo());
            mailMessage.setText(mailDTO.getContext());
            mailMessage.setSubject(mailDTO.getSubject());

            javaMailSender.send(mailMessage);
            log.info("Mail sent successfully");
        }catch (Exception e) {
            log.error("Error occurred when try to send mail!");
        }

    }
}
