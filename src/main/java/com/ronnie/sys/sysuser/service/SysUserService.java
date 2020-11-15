package com.ronnie.sys.sysuser.service;

import com.ronnie.common.pojo.Result;
import com.ronnie.common.service.CommonService;
import com.ronnie.sys.sysuser.pojo.SysUser;
import com.ronnie.sys.sysuser.vo.SysUserVo;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

public interface SysUserService extends CommonService<SysUserVo, SysUser, String> {
    Result<SysUserVo> findByLoginName(String username);
    Result<SysUserVo> resetPassword(String userId);
    PersistentTokenRepository getPersistentTokenRepository2();
}
