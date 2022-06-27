package com.asm.responsitory;

import com.asm.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {
    @Query(value = "SELECT role.name FROM role JOIN account on role.id= account.role_id WHERE account.id= ?1",  nativeQuery = true)
    List<String> findByRole(long idUserRole);

}