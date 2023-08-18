package com.playstudy.comm.domain.service;

import com.playstudy.comm.domain.SignUpForm;
import com.playstudy.comm.domain.model.Customer;
import com.playstudy.comm.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpCustomerService {

    // Repository와 연결
    private final CustomerRepository customerRepository;


    // # 1. 회원가입
    public Customer signUp(SignUpForm form) {

        // 1) SignUpForm 타입을 -> Customer 타입으로 변경
        Customer customer = Customer.from(form);

        // 2) DB에 저장
        customerRepository.save(customer);

        return customer;
    }
}

