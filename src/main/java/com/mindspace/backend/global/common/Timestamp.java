package com.mindspace.backend.global.common;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity 클래스들이 해당 추상 클래스를 상속할 경우 createAt, updatedAt 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class) // 해당 클래스에 Auditing 기능을 포함
public class Timestamp {
    @CreatedDate // Entity가 생성되어 저장될 때 시간 자동 저장
    private LocalDateTime createAt;

    @LastModifiedDate // Entity의 값을 변경할 때 시간 자동 저장
    private LocalDateTime updatedAt;
}
