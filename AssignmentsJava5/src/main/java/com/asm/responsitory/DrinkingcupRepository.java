package com.asm.responsitory;

import com.asm.entity.Drinkingcup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DrinkingcupRepository extends JpaRepository<Drinkingcup, Long>, JpaSpecificationExecutor<Drinkingcup> {
    Page<Drinkingcup> findByNameLike(String name, Pageable pageable);

    //UPDATE drinkingcups SET drinkingcups.amount WHERE drinkingcups.id=2
    @Transactional
    @Modifying
    @Query(value = "UPDATE drinkingcups a SET a.img , a.name, a.id_category, a.description, a.price, a.promotion, a.color, a.size, a.volume, a.material, a.status WHERE a.id= ?1", nativeQuery = true)
    void updateDrinkingCup();

    @Modifying
    @Query(value = "UPDATE drinkingcups a SET a.status = 0 WHERE a.id= ?1", nativeQuery = true)
    void deleteDrinkingCup();

    @Query(value = "SELECT drinkingcups.id_category FROM drinkingcups WHERE drinkingcups.id= ?1", nativeQuery = true)
    Object findCategoryByProduct(Long id);

    @Query(value = "SELECT drinkingcups.* FROM drinkingcups LEFT join categories ON drinkingcups.id_category = categories.id WHERE categories.id= ?1", nativeQuery = true)
    List<Drinkingcup> loadProductByCategory(Long idiCategory);

//    @Query(value = "SELECT drinkingcups.id,drinkingcups.name FROM drinkingcups WHERE drinkingcups.status=1", nativeQuery = true)
//    Page<Object[]> getAllPage(Pageable pageable);


    @Transactional
    @Modifying
    @Query(value = "UPDATE drinkingcups SET drinkingcups.status=2 WHERE drinkingcups.id= ?1", nativeQuery = true)
    void updateAmount(Long id);

}