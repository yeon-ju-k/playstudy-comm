package com.playstudy.comm.domain.service;

import com.playstudy.comm.domain.SignUpForm;
import com.playstudy.comm.domain.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDate;

@SpringBootTest
class SignUpCustomerServiceTest {


    private final SignUpCustomerService service;

    @Autowired
    SignUpCustomerServiceTest(SignUpCustomerService service) {
        this.service = service;
    }

    @Test
    void signUp() {

        SignUpForm form = SignUpForm.builder()
                .name("name")
                .birth(LocalDate.now())
                .email("abc@gmail.com")
                .password("1")
                .phone("01000000000")
                .build();
        Customer c = service.signUp(form);

        Assert.isTrue(service.signUp(form).getId()!=null);

    }
}


