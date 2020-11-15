package com.ronnie.user.service;

import com.ronnie.common.pojo.Result;
import com.ronnie.sys.sysuser.vo.SysUserVo;

public interface UserService {
    Result<SysUserVo> updatePassword(String oldPassword, String newPassword);

    Result<SysUserVo> updateUser(SysUserVo sysUserVo);
}
