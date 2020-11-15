package com.ronnie.sys.sysuserauthority.service;

import com.ronnie.common.pojo.Result;
import com.ronnie.common.service.CommonService;
import com.ronnie.sys.sysuserauthority.pojo.SysUserAuthority;
import com.ronnie.sys.sysuserauthority.vo.SysUserAuthorityVo;

import java.util.List;

public interface SysUserAuthorityService extends CommonService<SysUserAuthorityVo, SysUserAuthority, String> {
    Result<List<SysUserAuthorityVo>> findByUserId(String userId);

    Result<Boolean> saveAllByUserId(String userId, String authorityIdList);
}
