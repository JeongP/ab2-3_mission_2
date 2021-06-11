package com.example.team.mission2.repository;

import com.example.team.mission2.domain.CategoryTBL;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired CategoryRepository categoryRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void 카테고리삽입() {
        //given
        CategoryTBL category = new CategoryTBL();
        category.setCategoryId("e");
        category.setParentCategoryId("a");
        category.setCategoryName("b");
        category.setDescription("c");
        category.setCategoryType("d");

        //when
        String savedId = categoryRepository.save(category);

        //then
        CategoryTBL findCategory = categoryRepository.find(savedId);
        Assertions.assertThat(findCategory.getCategoryId()).isEqualTo(category.getCategoryId());
        Assertions.assertThat(findCategory.getParentCategoryId()).isEqualTo(category.getParentCategoryId());
    }

    @Test
    @Transactional
//    @Rollback(value = false)
    public void readAll() {
//        CategoryTBL categoryTBL1 = new CategoryTBL();
//        categoryTBL1.setCategoryId("e");
//        categoryTBL1.setParentCategoryId("a");
//        categoryTBL1.setCategoryName("b");
//        categoryTBL1.setDescription("c");
//        categoryTBL1.setCategoryType("d");
//        categoryRepository.save(categoryTBL1);
//
//        CategoryTBL categoryTBL2 = new CategoryTBL();
//        categoryTBL2.setCategoryId("z");
//        categoryTBL2.setParentCategoryId("a");
//        categoryTBL2.setCategoryName("b");
//        categoryTBL2.setDescription("c");
//        categoryTBL2.setCategoryType("d");
//        categoryRepository.save(categoryTBL2);

        List<CategoryTBL> result = categoryRepository.findAll();
        System.out.println(result.size());
//        Assertions.assertThat(result.size()).isEqualTo(2);
    }

}