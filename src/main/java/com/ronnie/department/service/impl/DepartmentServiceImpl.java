package com.ronnie.department.service.impl;

import com.ronnie.common.pojo.PageInfo;
import com.ronnie.common.pojo.Result;
import com.ronnie.common.service.CommonService;
import com.ronnie.common.service.CommonServiceImpl;
import com.ronnie.department.pojo.Department;
import com.ronnie.department.service.DepartmentService;
import com.ronnie.department.vo.DepartmentVo;
import com.ronnie.sys.sysuser.pojo.SysUser;
import com.ronnie.sys.sysuser.vo.SysUserVo;
import com.ronnie.util.SqlUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class DepartmentServiceImpl extends CommonServiceImpl<DepartmentVo, Department, Long> implements DepartmentService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Result<PageInfo<DepartmentVo>> page(DepartmentVo entityVo) {
        //根据实体、Vo直接拼接全部SQL
        StringBuilder sql = SqlUtil.joinSqlByEntityAndVo(Department.class, entityVo);

        //设置SQL、映射实体，以及设置值，返回一个Query对象
        Query query = em.createNativeQuery(sql.toString(), Department.class);

        //分页设置，page从0开始
        PageRequest pageRequest = PageRequest.of(entityVo.getPage() - 1, entityVo.getRows());

        //获取最终分页结果
        Result<PageInfo<DepartmentVo>> result = Result.of(PageInfo.of(PageInfo.getJPAPage(query,pageRequest, em), DepartmentVo.class));
        return result;
    }

    @Override
    public Result<List<DepartmentVo>> list(DepartmentVo entityVo) {
        return super.list(entityVo);
    }

    @Override
    public Result<DepartmentVo> get(Long id) {
        return super.get(id);
    }

    @Override
    public Result<DepartmentVo> save(DepartmentVo entityVo) {
        return super.save(entityVo);
    }

    @Override
    public Result<Long> delete(Long id) {
        return super.delete(id);
    }
}
