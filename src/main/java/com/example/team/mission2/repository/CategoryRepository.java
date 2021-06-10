package com.example.team.mission2.repository;

import com.example.team.mission2.domain.CategoryTBL;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoryRepository {

    @PersistenceContext
    EntityManager em;

    public Long save(CategoryTBL category) {
        em.persist(category);
        return category.getId();
    }

    public CategoryTBL find(Long id) {
        return em.find(CategoryTBL.class, id);
    }
    public List<CategoryTBL> findAll() {
        return em.createQuery("select c from CategoryTBL c", CategoryTBL.class).getResultList();
    }
}
