package com.ronnie.equipment.vo;

import com.ronnie.common.pojo.PageCondition;

import java.io.Serializable;
import java.util.Date;

public class EquipmentUpkeepPlanVo extends PageCondition implements Serializable {
    private Long id;

    /** 设备ID */
    private Long equipmentId;

    /** 保养人员 */
    private Long upkeepOperator;

    /** 保养内容 */
    private String upkeepContent;

    /** 工作标准 */
    private String workStandard;

    /** 保养周期 */
    private String schedule;

    /** 创建日期 */
    private Date gmtCreated;

    /** 修改日期 */
    private Date gmtModified;
}
