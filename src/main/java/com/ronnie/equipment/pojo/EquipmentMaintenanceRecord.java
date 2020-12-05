package com.ronnie.equipment.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "equipment_maintenance_record")
@Data
public class EquipmentMaintenanceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
