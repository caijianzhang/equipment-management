package com.ronnie.sys.sysuserauthority.repository;

import com.ronnie.common.repository.CommonRepository;
import com.ronnie.sys.sysuserauthority.pojo.SysUserAuthority;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserAuthorityRepository extends CommonRepository<SysUserAuthority, String> {
    List<SysUserAuthority> findByUserId(String userId);
}
