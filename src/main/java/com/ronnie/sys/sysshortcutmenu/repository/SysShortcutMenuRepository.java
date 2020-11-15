package com.ronnie.sys.sysshortcutmenu.repository;

import com.ronnie.common.repository.CommonRepository;
import com.ronnie.sys.sysshortcutmenu.pojo.SysShortcutMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysShortcutMenuRepository extends CommonRepository<SysShortcutMenu, String> {
    List<SysShortcutMenu> findByUserId(String userId);
}
