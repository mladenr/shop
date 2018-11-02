package com.sw.shop.domain;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    private String uc;

    private LocalDateTime dc;

    private String um;

    private LocalDateTime dm;
}
