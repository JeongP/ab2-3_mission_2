package com.example.team.mission2.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name="category_tbl")
@Getter @Setter
public class CategoryTBL {

    @Id @Column(name = "category_id")
    private String categoryId;

    @Column(nullable = true, length = 255)
    private String parentCategoryId;

    @Column(nullable = true, length = 65000)
    private String categoryName;

    @Column(nullable = true, length = 65000)
    private String description;

    @Column(nullable = true, length = 255)
    private String categoryType;


}
