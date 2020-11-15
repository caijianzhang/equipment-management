package com.ronnie.department.controller;

import com.ronnie.common.controller.CommonController;
import com.ronnie.department.pojo.Department;
import com.ronnie.department.vo.DepartmentVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/department/")
public class DepartmentController extends CommonController<DepartmentVo, Department, Long> {
    @GetMapping("info")
    public ModelAndView authority(){
        return new ModelAndView("department/info");
    }
}
