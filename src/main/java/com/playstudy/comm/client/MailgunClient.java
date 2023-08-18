package com.playstudy.comm.client;

import com.playstudy.comm.client.mailgun.SendMailForm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "mailgun", url = "https://api.mailgun.net/v3/")
@Qualifier("mailgun")   // 여러개의 FeignClient를 사용하기 위해 구분!
public interface MailgunClient {

    @PostMapping("sandbox920208b287e44fdebfb74b372e0b08c9.mailgun.org/messages")
    ResponseEntity<String> sendEmail(@SpringQueryMap SendMailForm form);

}


