package com.ronnie.equipment.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "equipment_component")
@Data
public class EquipmentComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 设备ID */
    private Long equipmentId;

    /** 组件名称 */
    private String name;

    /** 组件编号 */
    private String code;

    /** 组件数量 */
    private String number;

    /** 备注 */
    private String remarks;

    /** 创建日期 */
    private Date gmtCreated;

    /** 修改日期 */
    private Date gmtModified;
}
