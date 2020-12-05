package com.ronnie.equipment.controller;

import com.ronnie.common.controller.CommonController;
import com.ronnie.common.pojo.PageInfo;
import com.ronnie.common.pojo.Result;
import com.ronnie.equipment.pojo.EquipmentMaintenancePlan;
import com.ronnie.equipment.service.EquipmentMaintenancePlanService;
import com.ronnie.equipment.vo.EquipmentMaintenancePlanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/equipment/maintenance/plan/")
public class EquipmentMaintenancePlanController extends CommonController<EquipmentMaintenancePlanVo, EquipmentMaintenancePlan, Long> {
    @Autowired
    private EquipmentMaintenancePlanService equipmentMaintenancePlanService;

    @GetMapping("view")
    public ModelAndView view(@RequestParam(name = "equipmentId") Long equipmentId, @RequestParam(name = "departmentId") Long departmentId) {
        ModelAndView modelAndView = new ModelAndView("equipment/equipment_maintenance_plan");
        modelAndView.addObject("equipmentId", equipmentId);
        modelAndView.addObject("departmentId", departmentId);
        return modelAndView;
    }

    @PostMapping("page/condition")
    public Result<PageInfo<EquipmentMaintenancePlanVo>> page(EquipmentMaintenancePlanVo entityVo, @RequestParam(name = "equipmentId") Long equipmentId) {
        return equipmentMaintenancePlanService.page(entityVo, equipmentId);
    }
}
