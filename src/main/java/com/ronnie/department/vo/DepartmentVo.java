package com.ronnie.department.vo;

import com.ronnie.annotation.Like;
import com.ronnie.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DepartmentVo extends PageCondition implements Serializable {
    private Long id;

    @Like
    private String name;

    private Date gmtCreated;

    private Date gmtModified;
}
