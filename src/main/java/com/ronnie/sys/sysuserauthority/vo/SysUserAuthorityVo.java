package com.ronnie.sys.sysuserauthority.vo;

import com.ronnie.common.pojo.PageCondition;
import com.ronnie.sys.sysauthority.vo.SysAuthorityVo;
import com.ronnie.sys.sysuser.vo.SysUserVo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysUserAuthorityVo extends PageCondition implements Serializable {
    private String userAuthorityId;//用户权限表id

    private String userId;//用户id

    private String authorityId;//权限id

    private SysUserVo sysUser;//用户

    private SysAuthorityVo sysAuthority;//权限

    private Date gmtCreated;//创建时间

    private Date gmtModified;//修改时间

    private String authorityIdList;//新增、修改用户权限时权限id集合
}
