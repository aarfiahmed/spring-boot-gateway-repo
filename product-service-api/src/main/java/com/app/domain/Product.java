package com.app.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Product {
    Integer id;
    String name;
    String price;
}
