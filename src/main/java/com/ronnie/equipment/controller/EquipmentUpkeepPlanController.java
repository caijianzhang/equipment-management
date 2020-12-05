package com.ronnie.equipment.controller;

import com.ronnie.common.controller.CommonController;
import com.ronnie.equipment.pojo.EquipmentUpkeepPlan;
import com.ronnie.equipment.service.EquipmentUpkeepPlanService;
import com.ronnie.equipment.vo.EquipmentUpkeepPlanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/equipment/upkeep/plan/")
public class EquipmentUpkeepPlanController extends CommonController<EquipmentUpkeepPlanVo, EquipmentUpkeepPlan, Long> {
    @Autowired
    private EquipmentUpkeepPlanService equipmentUpkeepPlanService;

    @GetMapping("view")
    public ModelAndView view(@RequestParam(name = "equipmentId") Long equipmentId, @RequestParam(name = "departmentId") Long departmentId) {
        ModelAndView modelAndView = new ModelAndView("equipment/equipment_upkeep_plan");
        modelAndView.addObject("equipmentId", equipmentId);
        modelAndView.addObject("departmentId", departmentId);
        return modelAndView;
    }
}
