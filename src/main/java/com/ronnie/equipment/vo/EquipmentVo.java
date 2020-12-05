package com.ronnie.equipment.vo;

import com.ronnie.annotation.Like;
import com.ronnie.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EquipmentVo extends PageCondition implements Serializable {
    private Long id;

    /** 部门ID */
    private Long departmentId;

    /** 设备名称 */
    @Like
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
