package com.playstudy.comm.domain.model;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
public abstract class BaseEntity {

    @CreatedDate    // 만들어진 날짜 필드
    private LocalDateTime createdAt;

    @LastModifiedDate   // 마지막 수정 날짜 필드
    private LocalDateTime modifiedAt;
}


