package com.ronnie.equipment.vo;

import com.ronnie.common.pojo.PageCondition;

import java.io.Serializable;
import java.util.Date;

public class EquipmentUpkeepRecordVo extends PageCondition implements Serializable {
    private Long id;

    /** 设备ID */
    private Long equipmentId;

    /** 保养计划ID */
    private Long upkeepPlanId;

    /** 保养人员 */
    private Long upkeepOperator;

    /** 保养记录 */
    private String description;

    /** 创建日期 */
    private Date gmtCreated;

    /** 修改日期 */
    private Date gmtModified;
}
