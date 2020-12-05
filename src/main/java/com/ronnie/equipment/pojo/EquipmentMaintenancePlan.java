package com.ronnie.equipment.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "equipment_maintenance_plan")
@Data
public class EquipmentMaintenancePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 设备ID */
    private Long equipmentId;

    /** 维护类型ID */
    private Long maintenanceTypeId;

    /** 维护人员 */
    private Long maintenanceOperator;

    /** 维护位置，也就是说维护的动作发生在设备的那个部分 */
    private String part;

    /** 维护内容 */
    private String maintenanceContent;

    /** 工作标准 */
    private String workStandard;

    /** 维护周期 */
    private String schedule;

    /** 创建日期 */
    private Date gmtCreated;

    /** 修改日期 */
    private Date gmtModified;
}
