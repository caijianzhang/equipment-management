package com.ronnie.equipment.info.controller;

import com.ronnie.common.controller.CommonController;
import com.ronnie.equipment.info.pojo.EquipmentInfo;
import com.ronnie.equipment.info.service.EquipmentInfoService;
import com.ronnie.equipment.info.vo.EquipmentInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/equipment/info/")
public class EquipmentInfoController extends CommonController<EquipmentInfoVo, EquipmentInfo, Long> {
    @Autowired
    private EquipmentInfoService equipmentInfoService;

    @GetMapping("info")
    public ModelAndView authority(){
        return new ModelAndView("equipment/info/info");
    }

}