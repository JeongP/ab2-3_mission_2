package com.example.team.mission2.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class CategoryTBL {

    @Id @GeneratedValue
    private Long id;
    private String a;
    private String b;
    private String c;
    private String d;


}
