package com.playstudy.comm.client;

import com.playstudy.comm.client.mailgun.SendMailForm;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class MailgunClientTest {

    @Autowired
    private final MailgunClient mailgunClient;

    MailgunClientTest(MailgunClient mailgunClient) {
        this.mailgunClient = mailgunClient;
    }

    @Test
    void EmailTest() {
        //given
        SendMailForm form = SendMailForm.builder()
                .from("yeonjuminju@naver.com")
                .to("yeonjuminju@naver.com")
                .subject("Test email from playstudy.comm project")
                .text("my text")
                .build();

        //when
        ResponseEntity<String> response = mailgunClient.sendEmail(form);

        //then
        Assertions.assertThat(response.getBody());
    }

}