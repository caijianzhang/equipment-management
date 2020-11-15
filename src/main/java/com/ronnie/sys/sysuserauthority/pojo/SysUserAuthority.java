package com.ronnie.sys.sysuserauthority.pojo;

import com.ronnie.annotation.UUID;
import com.ronnie.sys.sysauthority.pojo.SysAuthority;
import com.ronnie.sys.sysuser.pojo.SysUser;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sys_user_authority")
@Data
public class SysUserAuthority implements Serializable {
    @Id
    @UUID
    private String userAuthorityId;//用户权限表id

    private String userId;//用户id

    private String authorityId;//权限id

    private Date gmtCreated;//创建时间

    private Date gmtModified;//修改时间

    @OneToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId", insertable = false, updatable = false)
    @NotFound(action= NotFoundAction.IGNORE)
    private SysUser sysUser;//用户

    @OneToOne
    @JoinColumn(name = "authorityId",referencedColumnName = "authorityId", insertable = false, updatable = false)
    @NotFound(action= NotFoundAction.IGNORE)
    private SysAuthority sysAuthority;//权限
}
