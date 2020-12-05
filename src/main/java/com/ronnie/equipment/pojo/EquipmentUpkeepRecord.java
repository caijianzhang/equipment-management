package com.ronnie.equipment.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "equipment_upkeep_record")
@Data
public class EquipmentUpkeepRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
