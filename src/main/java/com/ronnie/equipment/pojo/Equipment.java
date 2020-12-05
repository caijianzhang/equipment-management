package com.ronnie.equipment.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "equipment")
@Data
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 部门ID */
    private Long departmentId;

    /** 设备名称 */
    private String name;

    /** 设备编号 */
    private String number;

    /** 设备类型 */
    private String type;

    /** 原值 */
    private String value;

    /** 厂商 */
    private String manufacturer;

    /** 出厂编号 */
    private String factoryNumber;

    /** 出厂日期 */
    private String factoryDate;

    /** 安装位置 */
    private String position;

    /** 创建日期 */
    private Date gmtCreated;

    /** 修改日期 */
    private Date gmtModified;
}
