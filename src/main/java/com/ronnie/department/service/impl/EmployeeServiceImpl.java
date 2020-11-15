package com.ronnie.department.service.impl;

import com.ronnie.common.pojo.PageInfo;
import com.ronnie.common.pojo.Result;
import com.ronnie.common.service.CommonServiceImpl;
import com.ronnie.department.pojo.Department;
import com.ronnie.department.pojo.Employee;
import com.ronnie.department.service.EmployeeService;
import com.ronnie.department.vo.DepartmentVo;
import com.ronnie.department.vo.EmployeeVo;
import com.ronnie.util.SqlUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class EmployeeServiceImpl extends CommonServiceImpl<EmployeeVo, Employee, Long> implements EmployeeService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Result<PageInfo<EmployeeVo>> page(EmployeeVo entityVo) {
        //根据实体、Vo直接拼接全部SQL
        StringBuilder sql = SqlUtil.joinSqlByEntityAndVo(Employee.class, entityVo);

        //设置SQL、映射实体，以及设置值，返回一个Query对象
        Query query = em.createNativeQuery(sql.toString(), Employee.class);

        //分页设置，page从0开始
        PageRequest pageRequest = PageRequest.of(entityVo.getPage() - 1, entityVo.getRows());

        //获取最终分页结果
        Result<PageInfo<EmployeeVo>> result = Result.of(PageInfo.of(PageInfo.getJPAPage(query,pageRequest, em), EmployeeVo.class));
        return result;
    }
}
