package com.ronnie.equipment.vo;

import com.ronnie.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EquipmentComponentVo extends PageCondition implements Serializable {
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
