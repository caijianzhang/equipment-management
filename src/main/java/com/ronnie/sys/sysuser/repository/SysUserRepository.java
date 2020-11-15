package com.ronnie.sys.sysuser.repository;

import com.ronnie.common.repository.CommonRepository;
import com.ronnie.sys.sysuser.pojo.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository extends CommonRepository<SysUser, String> {
    SysUser findByLoginName(String username);
}
