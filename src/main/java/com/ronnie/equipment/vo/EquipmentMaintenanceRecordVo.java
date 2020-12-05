package com.ronnie.equipment.vo;

import com.ronnie.common.pojo.PageCondition;

import java.io.Serializable;
import java.util.Date;

public class EquipmentMaintenanceRecordVo extends PageCondition implements Serializable {
    private Long id;

    /** 设备ID */
    private Long equipmentId;

    /** 维护计划ID */
    private Long maintenancePlanId;

    /** 维护人员 */
    private Long maintenanceOperator;

    /** 维护记录 */
    private String description;

    /** 创建日期 */
    private Date gmtCreated;

    /** 修改日期 */
    private Date gmtModified;
}
