package com.kanghao.eduservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
private String testId;
private Boolean isPriceempty;
private BigDecimal testPrice;
private String testFood;
private LocalDateTime gmtCreate;
private LocalDateTime gmtModified;

}
