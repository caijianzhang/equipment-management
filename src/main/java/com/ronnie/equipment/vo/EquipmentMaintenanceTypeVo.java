package com.ronnie.equipment.vo;

import com.ronnie.common.pojo.PageCondition;

import java.io.Serializable;
import java.util.Date;

public class EquipmentMaintenanceTypeVo extends PageCondition implements Serializable {
    private Long id;

    /** 类型名 */
    private String name;

    /** 创建日期 */
    private Date gmtCreated;

    /** 修改日期 */
    private Date gmtModified;
}
