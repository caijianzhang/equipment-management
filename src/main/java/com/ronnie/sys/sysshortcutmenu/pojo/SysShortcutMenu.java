package com.ronnie.sys.sysshortcutmenu.pojo;

import com.ronnie.annotation.UUID;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sys_shortcut_menu")
@Data
public class SysShortcutMenu implements Serializable {
    @Id
    @UUID
    private String shortcutMenuId;//用户快捷菜单id

    private String shortcutMenuName;//用户快捷菜单名称

    private String shortcutMenuPath;//用户快捷菜单路径

    private String userId;//用户id

    private String shortcutMenuParentId;//上级id

    private Date gmtCreated;//创建时间

    private Date gmtModified;//修改时间

}
