package com.ronnie.sys.sysauthority.pojo;

import com.ronnie.annotation.UUID;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sys_authority")
@Data
public class SysAuthority implements Serializable {
    @Id
    @UUID
    private String authorityId;//权限id

    private String authorityName;//权限名称，ROLE_开头，全大写

    private String authorityContent;//权限内容，可访问的url，多个时用,隔开

    private String authorityRemark;//权限描述

    private Date gmtCreated;//创建时间

    private Date gmtModified;//修改时间

}
