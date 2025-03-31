package com.demoqa.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class User {
    private String name;
    private String surName;
    private String email;
    private String phone;

}