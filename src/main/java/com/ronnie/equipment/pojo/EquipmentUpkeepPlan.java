package com.ronnie.equipment.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "equipment_upkeep_plan")
@Data
public class EquipmentUpkeepPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
