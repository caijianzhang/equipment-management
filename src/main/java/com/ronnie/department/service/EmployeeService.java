package com.ronnie.department.service;

import com.ronnie.common.pojo.PageInfo;
import com.ronnie.common.pojo.Result;
import com.ronnie.common.service.CommonService;
import com.ronnie.department.pojo.Employee;
import com.ronnie.department.vo.EmployeeVo;

public interface EmployeeService extends CommonService<EmployeeVo, Employee, Long> {
    /**
     * 根据部门ID查找员工
     * @param entityVo
     * @param departmentId
     * @return
     */
    Result<PageInfo<EmployeeVo>> page(EmployeeVo entityVo, Long departmentId);
}
