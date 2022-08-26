package com.example.hotelsmail.hotelsmail.controller;

import com.example.hotelsmail.hotelsmail.dto.MailDTO;
import com.example.hotelsmail.hotelsmail.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/main")
public class MailController {

    private final MailService mailService;

    @PostMapping("/send")
    public void sendMail(@RequestBody MailDTO mailDTO) {
        mailService.sendMail(mailDTO);
    }

}
