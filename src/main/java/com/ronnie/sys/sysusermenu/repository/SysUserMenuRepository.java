package com.ronnie.sys.sysusermenu.repository;

import com.ronnie.common.repository.CommonRepository;
import com.ronnie.sys.sysusermenu.pojo.SysUserMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMenuRepository extends CommonRepository<SysUserMenu, String> {
    List<SysUserMenu> findByUserId(String userId);
}
