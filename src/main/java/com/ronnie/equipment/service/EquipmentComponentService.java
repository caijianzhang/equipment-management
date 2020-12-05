package com.ronnie.equipment.service;

import com.ronnie.common.pojo.Result;
import com.ronnie.common.service.CommonService;
import com.ronnie.equipment.pojo.EquipmentComponent;
import com.ronnie.equipment.vo.EquipmentComponentVo;

public interface EquipmentComponentService extends CommonService<EquipmentComponentVo, EquipmentComponent, Long> {

    /**
     *
     * @param equipmentId
     * @return
     */
   Result<EquipmentComponentVo> getByEquipmentId(Long equipmentId);
}
