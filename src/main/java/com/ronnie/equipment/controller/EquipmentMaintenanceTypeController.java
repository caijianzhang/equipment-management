package com.ronnie.equipment.controller;

import com.ronnie.common.controller.CommonController;
import com.ronnie.equipment.pojo.EquipmentMaintenanceType;
import com.ronnie.equipment.service.EquipmentMaintenanceTypeService;
import com.ronnie.equipment.vo.EquipmentMaintenanceTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/equipment/maintenance/type/")
public class EquipmentMaintenanceTypeController extends CommonController<EquipmentMaintenanceTypeVo, EquipmentMaintenanceType, Long> {
    @Autowired
    private EquipmentMaintenanceTypeService equipmentMaintenanceTypeService;

    @GetMapping("view")
    public ModelAndView view() {
        ModelAndView modelAndView = new ModelAndView("equipment/equipment_maintenance_type");
        return modelAndView;
    }
}
