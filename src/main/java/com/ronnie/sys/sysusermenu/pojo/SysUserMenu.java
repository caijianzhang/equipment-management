package com.ronnie.sys.sysusermenu.pojo;

import com.ronnie.annotation.UUID;
import com.ronnie.sys.sysmenu.pojo.SysMenu;
import com.ronnie.sys.sysuser.pojo.SysUser;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sys_user_menu")
@Data
public class SysUserMenu implements Serializable {
    @Id
    @UUID
    private String userMenuId;//用户菜单表id

    private String userId;//用户id

    private String menuId;//菜单id

    private Date gmtCreated;//创建时间

    private Date gmtModified;//修改时间

    @OneToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId", insertable = false, updatable = false)
    @NotFound(action= NotFoundAction.IGNORE)
    private SysUser sysUser;//用户

    @OneToOne
    @JoinColumn(name = "menuId",referencedColumnName = "menuId", insertable = false, updatable = false)
    @NotFound(action= NotFoundAction.IGNORE)
    private SysMenu sysMenu;//菜单
}
