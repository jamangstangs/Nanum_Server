package com.nanum.nanumserver.common.persistence;

import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public abstract class UnmodifiableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected UnmodifiableEntity() {

    }
}
