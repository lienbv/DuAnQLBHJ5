package com.asm.responsitory;

import com.asm.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long>, JpaSpecificationExecutor<Bill> {
    @Transactional
    @Modifying
    @Query(value = "SELECT bill.id , drinkingcups.name, drinkingcups.price, bill_detail.amount, bill.id_user FROM bill_detail JOIN bill ON bill.id = bill_detail.id_bill join drinkingcups on drinkingcups.id= bill_detail.id_drinking_cup \n" +
            "WHERE bill.id= ?1", nativeQuery = true)
    List<Object[]> findDrinkingByidUser(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE bill SET bill.status =\"confirm\" WHERE bill.id= ?1", nativeQuery = true)
    void DrinkingByidUserConfirm(Long idBill);
    @Transactional
    @Modifying
    @Query(value = "UPDATE bill SET bill.status =\"cancel\" WHERE bill.id_user=?1 AND bill.id = ?2", nativeQuery = true)
    void DrinkingByidUserCancel(Long idUser, Long idBill);

    @Transactional
    @Modifying
    @Query(value = "SELECT bill.id , drinkingcups.name, drinkingcups.price, bill_detail.amount, bill.id_user FROM bill_detail JOIN bill ON bill.id = bill_detail.id_bill join drinkingcups on drinkingcups.id= bill_detail.id_drinking_cup \n" +
            "WHERE bill.id_user= ?1 AND bill.status=\"confirm\" ", nativeQuery = true)
    List<Object[]> findDrinkingByidUserAndStatusConfirm(Long id);

    @Transactional
    @Modifying
    @Query(value = "SELECT bill.id , drinkingcups.name, drinkingcups.price, bill_detail.amount, bill.id_user FROM bill_detail JOIN bill ON bill.id = bill_detail.id_bill join drinkingcups on drinkingcups.id= bill_detail.id_drinking_cup \n" +
            "WHERE bill.id_user= ?1 AND bill.status=\"cancel\" ", nativeQuery = true)
    List<Object[]> findDrinkingByidUserAndStatusCancel(Long id);
    List<Bill> findByIdUser(Long idUser);

    //SELECT bill.id , drinkingcups.name, drinkingcups.price, bill_detail.amount  FROM bill JOIN account on bill.id_user = account.id JOIN bill_detail on bill_detail.id_bill= bill.id JOIN drinkingcups on drinkingcups.id = bill_detail.id_drinking_cup  WHERE bill.id_user=2 AND bill.status="waiting"
    @Transactional
    @Modifying
    @Query(value = "SELECT bill.id , drinkingcups.name, drinkingcups.price, bill_detail.amount  FROM bill JOIN account on bill.id_user = account.id JOIN bill_detail on bill_detail.id_bill= bill.id JOIN drinkingcups on drinkingcups.id = bill_detail.id_drinking_cup  WHERE bill.id_user= ?1 AND bill.status=\"confirm\"\n", nativeQuery = true)
    List<Object[]> findBillUser(Long id);
}