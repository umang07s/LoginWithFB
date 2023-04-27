package com.example.registrationlogindemo.utils;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Data
public class GenericFields {

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private Date modifiedAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private UUID modifiedBy;

}
