package com.ronnie.equipment.controller;

import com.ronnie.common.controller.CommonController;
import com.ronnie.equipment.pojo.Equipment;
import com.ronnie.equipment.service.EquipmentService;
import com.ronnie.equipment.vo.EquipmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/equipment/")
public class EquipmentController extends CommonController<EquipmentVo, Equipment, Long> {
    @Autowired
    private EquipmentService equipmentService;

    @GetMapping("view")
    public ModelAndView view(){
        return new ModelAndView("equipment/equipment");
    }
}