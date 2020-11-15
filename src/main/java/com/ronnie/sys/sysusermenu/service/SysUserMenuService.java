package com.ronnie.sys.sysusermenu.service;

import com.ronnie.common.pojo.Result;
import com.ronnie.common.service.CommonService;
import com.ronnie.sys.sysmenu.vo.SysMenuVo;
import com.ronnie.sys.sysusermenu.pojo.SysUserMenu;
import com.ronnie.sys.sysusermenu.vo.SysUserMenuVo;

import java.util.List;

public interface SysUserMenuService extends CommonService<SysUserMenuVo, SysUserMenu, String> {
    Result<List<SysMenuVo>> findByUserId(String userId);

    Result<Boolean> saveAllByUserId(String userId, String menuIdList);
}
