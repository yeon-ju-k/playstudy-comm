package com.playstudy.comm.service.test;

import com.playstudy.comm.client.MailgunClient;
import com.playstudy.comm.client.mailgun.SendMailForm;
import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSendService {

    private final MailgunClient mailgunClient;

    public ResponseEntity<String> sendEmail() {

        SendMailForm form = SendMailForm.builder()
                        .from("yeonjuminju@naver.com")
                        .to("yeonjuminju@naver.com")
                        .subject("Test email from playstudy.comm project")
                        .text("my text")
                        .build();

        ResponseEntity<String> response = mailgunClient.sendEmail(form);
        return response;
    }

}


