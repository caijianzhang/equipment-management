package com.ronnie.sys.sysmenu.service;

import com.ronnie.common.pojo.Result;
import com.ronnie.common.service.CommonService;
import com.ronnie.sys.sysmenu.pojo.SysMenu;
import com.ronnie.sys.sysmenu.vo.SysMenuVo;

import java.util.List;

public interface SysMenuService extends CommonService<SysMenuVo, SysMenu, String> {
    Result<List<SysMenuVo>> listByTier(SysMenuVo entityVo);
}
