package com.ronnie.equipment.service.impl;

import com.ronnie.common.pojo.PageInfo;
import com.ronnie.common.pojo.Result;
import com.ronnie.common.service.CommonServiceImpl;
import com.ronnie.equipment.pojo.EquipmentUpkeepPlan;
import com.ronnie.equipment.repository.EquipmentUpkeepPlanRepository;
import com.ronnie.equipment.service.EquipmentUpkeepPlanService;
import com.ronnie.equipment.vo.EquipmentUpkeepPlanVo;
import com.ronnie.util.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
@Transactional
public class EquipmentUpkeepPlanServiceImpl extends CommonServiceImpl<EquipmentUpkeepPlanVo, EquipmentUpkeepPlan, Long> implements EquipmentUpkeepPlanService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private EquipmentUpkeepPlanRepository equipmentUpkeepPlanRepository;

    @Override
    public Result<PageInfo<EquipmentUpkeepPlanVo>> page(EquipmentUpkeepPlanVo entityVo) {
        //根据实体、Vo直接拼接全部SQL
        StringBuilder sql = SqlUtil.joinSqlByEntityAndVo(EquipmentUpkeepPlan.class, entityVo);

        //设置SQL、映射实体，以及设置值，返回一个Query对象
        Query query = em.createNativeQuery(sql.toString(), EquipmentUpkeepPlan.class);

        //分页设置，page从0开始
        PageRequest pageRequest = PageRequest.of(entityVo.getPage() - 1, entityVo.getRows());

        //获取最终分页结果
        Result<PageInfo<EquipmentUpkeepPlanVo>> result = Result.of(PageInfo.of(PageInfo.getJPAPage(query,pageRequest, em), EquipmentUpkeepPlanVo.class));
        return result;
    }

    @Override
    public Result<List<EquipmentUpkeepPlanVo>> list(EquipmentUpkeepPlanVo entityVo) {
        return super.list(entityVo);
    }

    @Override
    public Result<EquipmentUpkeepPlanVo> get(Long id) {
        return super.get(id);
    }

    @Override
    public Result<EquipmentUpkeepPlanVo> save(EquipmentUpkeepPlanVo entityVo) {
        return super.save(entityVo);
    }

    @Override
    public Result<Long> delete(Long id) {
        return super.delete(id);
    }
}
