package com.asm.responsitory;

import com.asm.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Category> {
    List<Category> findByNameLike(String name);
    @Transactional
    @Modifying
    @Query(value = "UPDATE categories c SET c.status=0 WHERE c.id=?", nativeQuery = true)
    void updtate(long id);
}