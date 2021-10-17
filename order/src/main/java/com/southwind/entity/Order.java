package com.southwind.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private long id;
    private Admin admin;
    private Menu menu;
    private User user;
    private Date date;
    private int state;
}
