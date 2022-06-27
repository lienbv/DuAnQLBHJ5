package com.asm.responsitory;

import com.asm.entity.Account;
import com.asm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Long>, JpaSpecificationExecutor<Account> {
    Account findByUsername(String username);
    Account findByUsernameAndPassword(String username, String password);
    Account findByPassword(String password);
    //SELECT user.email FROM user JOIN account on user.id = account.user_id WHERE account.username="lienptph306"

}