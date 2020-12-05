package com.ronnie.equipment.service.impl;

import com.ronnie.common.pojo.PageInfo;
import com.ronnie.common.pojo.Result;
import com.ronnie.common.service.CommonServiceImpl;
import com.ronnie.equipment.pojo.EquipmentMaintenanceSchedule;
import com.ronnie.equipment.repository.EquipmentMaintenanceScheduleRepository;
import com.ronnie.equipment.service.EquipmentMaintenanceScheduleService;
import com.ronnie.equipment.vo.EquipmentMaintenanceScheduleVo;
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
public class EquipmentMaintenanceScheduleServiceImpl extends CommonServiceImpl<EquipmentMaintenanceScheduleVo, EquipmentMaintenanceSchedule, Long> implements EquipmentMaintenanceScheduleService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private EquipmentMaintenanceScheduleRepository equipmentMaintenanceScheduleRepository;

    @Override
    public Result<PageInfo<EquipmentMaintenanceScheduleVo>> page(EquipmentMaintenanceScheduleVo entityVo) {
        //根据实体、Vo直接拼接全部SQL
        StringBuilder sql = SqlUtil.joinSqlByEntityAndVo(EquipmentMaintenanceSchedule.class, entityVo);

        //设置SQL、映射实体，以及设置值，返回一个Query对象
        Query query = em.createNativeQuery(sql.toString(), EquipmentMaintenanceSchedule.class);

        //分页设置，page从0开始
        PageRequest pageRequest = PageRequest.of(entityVo.getPage() - 1, entityVo.getRows());

        //获取最终分页结果
        Result<PageInfo<EquipmentMaintenanceScheduleVo>> result = Result.of(PageInfo.of(PageInfo.getJPAPage(query,pageRequest, em), EquipmentMaintenanceScheduleVo.class));
        return result;
    }

    @Override
    public Result<List<EquipmentMaintenanceScheduleVo>> list(EquipmentMaintenanceScheduleVo entityVo) {
        return super.list(entityVo);
    }

    @Override
    public Result<EquipmentMaintenanceScheduleVo> get(Long id) {
        return super.get(id);
    }

    @Override
    public Result<EquipmentMaintenanceScheduleVo> save(EquipmentMaintenanceScheduleVo entityVo) {
        return super.save(entityVo);
    }

    @Override
    public Result<Long> delete(Long id) {
        return super.delete(id);
    }
}
