package com.ronnie.equipment.service.impl;

import com.ronnie.common.pojo.PageInfo;
import com.ronnie.common.pojo.Result;
import com.ronnie.common.service.CommonServiceImpl;
import com.ronnie.equipment.pojo.EquipmentMaintenancePlan;
import com.ronnie.equipment.repository.EquipmentMaintenancePlanRepository;
import com.ronnie.equipment.service.EquipmentMaintenancePlanService;
import com.ronnie.equipment.vo.EquipmentMaintenancePlanVo;
import com.ronnie.util.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EquipmentMaintenancePlanServiceImpl extends CommonServiceImpl<EquipmentMaintenancePlanVo, EquipmentMaintenancePlan, Long> implements EquipmentMaintenancePlanService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private EquipmentMaintenancePlanRepository equipmentMaintenancePlanRepository;

    @Override
    public Result<PageInfo<EquipmentMaintenancePlanVo>> page(EquipmentMaintenancePlanVo entityVo) {
        //根据实体、Vo直接拼接全部SQL
        StringBuilder sql = SqlUtil.joinSqlByEntityAndVo(EquipmentMaintenancePlan.class, entityVo);

        //设置SQL、映射实体，以及设置值，返回一个Query对象
        Query query = em.createNativeQuery(sql.toString(), EquipmentMaintenancePlan.class);

        //分页设置，page从0开始
        PageRequest pageRequest = PageRequest.of(entityVo.getPage() - 1, entityVo.getRows());

        //获取最终分页结果
        Result<PageInfo<EquipmentMaintenancePlanVo>> result = Result.of(PageInfo.of(PageInfo.getJPAPage(query,pageRequest, em), EquipmentMaintenancePlanVo.class));
        return result;
    }

    @Override
    public Result<PageInfo<EquipmentMaintenancePlanVo>> page(EquipmentMaintenancePlanVo entityVo, Long equipmentId) {
        //根据实体、Vo直接拼接全部SQL
        Map<String, Object> conditions = new HashMap<>(2);
        conditions.put("equipment_id", equipmentId);
        StringBuilder sql = SqlUtil.joinSqlByEntityAndVo(EquipmentMaintenancePlan.class, entityVo, conditions);

        //设置SQL、映射实体，以及设置值，返回一个Query对象
        Query query = em.createNativeQuery(sql.toString(), EquipmentMaintenancePlan.class);

        //分页设置，page从0开始
        PageRequest pageRequest = PageRequest.of(entityVo.getPage() - 1, entityVo.getRows());

        //获取最终分页结果
        Result<PageInfo<EquipmentMaintenancePlanVo>> result = Result.of(PageInfo.of(PageInfo.getJPAPage(query,pageRequest, em), EquipmentMaintenancePlanVo.class));
        return result;
    }

    @Override
    public Result<List<EquipmentMaintenancePlanVo>> list(EquipmentMaintenancePlanVo entityVo) {
        return super.list(entityVo);
    }

    @Override
    public Result<EquipmentMaintenancePlanVo> get(Long id) {
        return super.get(id);
    }

    @Override
    public Result<EquipmentMaintenancePlanVo> save(EquipmentMaintenancePlanVo entityVo) {
        return super.save(entityVo);
    }

    @Override
    public Result<Long> delete(Long id) {
        return super.delete(id);
    }
}
