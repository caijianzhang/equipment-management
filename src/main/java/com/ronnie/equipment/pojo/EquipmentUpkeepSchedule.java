package com.ronnie.equipment.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "equipment_upkeep_schedule")
@Data
public class EquipmentUpkeepSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 设备ID */
    private Long equipmentId;

    /** 保养计划ID */
    private Long upkeepPlanId;

    /** 维护人员 */
    private Long operator;

    /** 工单状态 */
    private ScheduleStatus status;

    /** 创建日期 */
    private Date gmtCreated;

    /** 修改日期 */
    private Date gmtModified;
}
