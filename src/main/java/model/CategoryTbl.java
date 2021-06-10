package model;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category_tbl")
@Component
public class CategoryTbl {
    @Id
    @Column(name="category_id")
    private String id;

    private String parentCategoryId;
}
