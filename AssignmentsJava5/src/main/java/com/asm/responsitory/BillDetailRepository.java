package com.asm.responsitory;

import com.asm.entity.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BillDetailRepository extends JpaRepository<BillDetail, Long>, JpaSpecificationExecutor<BillDetail> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE bill_detail SET bill_detail.status=\"confirm\" WHERE bill_detail.id= ?1", nativeQuery = true)
    void updateConfirm(Long id);
    @Transactional
    @Modifying
    @Query(value = "UPDATE bill_detail SET bill_detail.status=\"cancel\" WHERE bill_detail.id= ?1", nativeQuery = true)
    void updateCancel(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE bill SET bill.status=\"confirm\" WHERE bill.id= ?1", nativeQuery = true)
    void updateBillConfirm(Long id);
}