package com.ronnie.sys.sysshortcutmenu.service;

import com.ronnie.common.pojo.Result;
import com.ronnie.common.service.CommonService;
import com.ronnie.sys.sysshortcutmenu.pojo.SysShortcutMenu;
import com.ronnie.sys.sysshortcutmenu.vo.SysShortcutMenuVo;

import java.util.List;

public interface SysShortcutMenuService extends CommonService<SysShortcutMenuVo, SysShortcutMenu, String> {
    Result<List<SysShortcutMenuVo>> findByUserId(String userId);
}
