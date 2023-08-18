package com.playstudy.comm.domain.model;

import com.playstudy.comm.domain.SignUpForm;
import lombok.*;
import org.hibernate.envers.AuditOverride;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AuditOverride(forClass = BaseEntity.class)
public class Customer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)  // 이메일 중복 방지
    private String email;

    private String name;
    private String password;
    private String phone;
    private LocalDate birth;

    // 이메일 인증 코드를 위한 필드
    private LocalDateTime verifyExpiredAt;  // 코드 유효기한
    private String verificationCode;    // 코드
    private boolean verify;    // 인증 여부

    // signUpForm 타입으로 회원가입을 받으면 -> Customer 타입으로 변경하는 메소드
    public static Customer from(SignUpForm form) {
        return Customer.builder()
                .email(form.getEmail().toLowerCase(Locale.ROOT))    // 이메일 중복체크를 위해 소문자로 통일
                .password(form.getPassword())
                .name(form.getName())
                .birth(form.getBirth())
                .phone(form.getPhone())
                .build();
    }

}


