package com.example.team.mission2.repository;

import com.example.team.mission2.domain.CategoryTBL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoryRepository {

    @PersistenceContext
    EntityManager em;

    public String save(CategoryTBL category) {
        em.persist(category);
        return category.getCategoryId();
    }

    public CategoryTBL find(String id) {
        return em.find(CategoryTBL.class, id);
    }
    public List<CategoryTBL> findAll() {
        return em.createQuery("select c from CategoryTBL c", CategoryTBL.class).getResultList();
    }
}
