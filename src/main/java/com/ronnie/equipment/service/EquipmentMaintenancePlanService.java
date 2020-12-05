package com.ronnie.equipment.service;

import com.ronnie.common.pojo.PageInfo;
import com.ronnie.common.pojo.Result;
import com.ronnie.common.service.CommonService;
import com.ronnie.equipment.pojo.EquipmentMaintenancePlan;
import com.ronnie.equipment.vo.EquipmentMaintenancePlanVo;

public interface EquipmentMaintenancePlanService extends CommonService<EquipmentMaintenancePlanVo, EquipmentMaintenancePlan, Long> {
    /**
     * 根据设备Id查找设备维修记录
     * @param entityVo
     * @param equipmentId
     * @return
     */
    Result<PageInfo<EquipmentMaintenancePlanVo>> page(EquipmentMaintenancePlanVo entityVo, Long equipmentId);
}
