package com.ronnie.sys.sysmenu.repository;

import com.ronnie.common.repository.CommonRepository;
import com.ronnie.sys.sysmenu.pojo.SysMenu;
import org.springframework.stereotype.Repository;

@Repository
public interface SysMenuRepository extends CommonRepository<SysMenu, String> {
}
