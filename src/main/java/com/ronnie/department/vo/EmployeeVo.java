package com.ronnie.department.vo;

import com.ronnie.annotation.Like;
import com.ronnie.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EmployeeVo extends PageCondition implements Serializable {
    private Long id;

    private Long departmentId;

    @Like
    private String name;

    private Integer age;

    private String phone;

    private String education;

    private Date gmtCreated;

    private Date gmtModified;
}
