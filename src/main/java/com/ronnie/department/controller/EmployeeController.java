package com.ronnie.department.controller;

import com.ronnie.common.controller.CommonController;
import com.ronnie.department.pojo.Employee;
import com.ronnie.department.vo.EmployeeVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/employee/")
public class EmployeeController extends CommonController<EmployeeVo, Employee, Long> {
    @GetMapping("info")
    public ModelAndView authority(){
        return new ModelAndView("employee/info");
    }
}
