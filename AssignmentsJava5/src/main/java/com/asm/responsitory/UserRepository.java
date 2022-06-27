package com.asm.responsitory;

import com.asm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    User findByEmail(String email);
    User findByPhoneNumber(String phone);
    @Query(value = "SELECT user.*, account.username, account.role_id, account.user_id,account.id FROM user JOIN account on user.id = account.user_id WHERE user.email= ?1", nativeQuery = true)
    User findEmailByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = "SELECT DISTINCT bill.id AS idBill,user.id, user.fullname,bill.create_date, user.email, user.phone_number, user.address, bill.total, bill.id_user FROM user join bill on user.id = bill.id_user join bill_detail on bill.id = bill_detail.id_bill WHERE user.id =bill.id_user AND bill.status= \"waiting\"" +
            "GROUP BY bill.id", nativeQuery = true)
    List<Object[]> findUserByStatus();
    @Transactional
    @Modifying
    @Query(value = "SELECT DISTINCT bill.id AS idBill,user.id, user.fullname,bill.create_date, user.email, user.phone_number, user.address, bill.total, bill.id_user FROM user join bill on user.id = bill.id_user join bill_detail on bill.id = bill_detail.id_bill WHERE user.id =bill.id_user AND bill.status= \"confirm\"" +
            "GROUP BY bill.id", nativeQuery = true)
    List<Object[]> findUserByStatusConfirm();
    @Transactional
    @Modifying
    @Query(value = "SELECT DISTINCT bill.id AS idBill,user.id, user.fullname,bill.create_date, user.email, user.phone_number, user.address, bill.total, bill.id_user FROM user join bill on user.id = bill.id_user join bill_detail on bill.id = bill_detail.id_bill WHERE user.id =bill.id_user AND bill.status= \"cancel\"" +
            "GROUP BY bill.id", nativeQuery = true)
    List<Object[]> findUserByStatusCancel();
}