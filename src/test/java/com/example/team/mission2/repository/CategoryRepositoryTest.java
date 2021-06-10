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
//    @Rollback(value = false)
    public void 카테고리삽입() {
        //given
        CategoryTBL category = new CategoryTBL();
        category.setA("a");
        category.setB("b");
        category.setC("c");
        category.setD("d");

        //when
        Long savedId = categoryRepository.save(category);

        //then
        CategoryTBL findCategory = categoryRepository.find(savedId);
        Assertions.assertThat(findCategory.getId()).isEqualTo(category.getId());
        Assertions.assertThat(findCategory.getA()).isEqualTo(category.getA());
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void readAll() {
        CategoryTBL categoryTBL1 = new CategoryTBL();
        categoryTBL1.setA("a");
        categoryTBL1.setB("b");
        categoryTBL1.setC("c");
        categoryTBL1.setD("d");
        categoryRepository.save(categoryTBL1);

        CategoryTBL categoryTBL2 = new CategoryTBL();
        categoryTBL2.setA("a");
        categoryTBL2.setB("b");
        categoryTBL2.setC("c");
        categoryTBL2.setD("d");
        categoryRepository.save(categoryTBL2);

        List<CategoryTBL> result = categoryRepository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }

}