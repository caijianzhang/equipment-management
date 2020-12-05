package com.ronnie.department.controller;

import com.ronnie.common.controller.CommonController;
import com.ronnie.common.pojo.PageInfo;
import com.ronnie.common.pojo.Result;
import com.ronnie.department.pojo.Employee;
import com.ronnie.department.service.EmployeeService;
import com.ronnie.department.vo.EmployeeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/employee/")
public class EmployeeController extends CommonController<EmployeeVo, Employee, Long> {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("view")
    public ModelAndView view(){
        return new ModelAndView("employee/employee");
    }

    @PostMapping("page/condition")
    public Result<PageInfo<EmployeeVo>> page(EmployeeVo entityVo, @RequestParam(name = "departmentId") Long departmentId) {
        return employeeService.page(entityVo, departmentId);
    }
}
