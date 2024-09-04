package com.app.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order {
    Integer orderId;
    Integer productId;
    String orderAmount;
}
