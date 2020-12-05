package com.ronnie.equipment.service.impl;

import com.ronnie.common.pojo.PageInfo;
import com.ronnie.common.pojo.Result;
import com.ronnie.common.service.CommonServiceImpl;
import com.ronnie.equipment.pojo.EquipmentMaintenanceType;
import com.ronnie.equipment.repository.EquipmentMaintenanceTypeRepository;
import com.ronnie.equipment.service.EquipmentMaintenanceTypeService;
import com.ronnie.equipment.vo.EquipmentMaintenanceTypeVo;
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
public class EquipmentMaintenanceTypeServiceImpl extends CommonServiceImpl<EquipmentMaintenanceTypeVo, EquipmentMaintenanceType, Long> implements EquipmentMaintenanceTypeService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private EquipmentMaintenanceTypeRepository equipmentMaintenanceTypeRepository;

    @Override
    public Result<PageInfo<EquipmentMaintenanceTypeVo>> page(EquipmentMaintenanceTypeVo entityVo) {
        //根据实体、Vo直接拼接全部SQL
        StringBuilder sql = SqlUtil.joinSqlByEntityAndVo(EquipmentMaintenanceType.class, entityVo);

        //设置SQL、映射实体，以及设置值，返回一个Query对象
        Query query = em.createNativeQuery(sql.toString(), EquipmentMaintenanceType.class);

        //分页设置，page从0开始
        PageRequest pageRequest = PageRequest.of(entityVo.getPage() - 1, entityVo.getRows());

        //获取最终分页结果
        Result<PageInfo<EquipmentMaintenanceTypeVo>> result = Result.of(PageInfo.of(PageInfo.getJPAPage(query,pageRequest, em), EquipmentMaintenanceTypeVo.class));
        return result;
    }

    @Override
    public Result<List<EquipmentMaintenanceTypeVo>> list(EquipmentMaintenanceTypeVo entityVo) {
        return super.list(entityVo);
    }

    @Override
    public Result<EquipmentMaintenanceTypeVo> get(Long id) {
        return super.get(id);
    }

    @Override
    public Result<EquipmentMaintenanceTypeVo> save(EquipmentMaintenanceTypeVo entityVo) {
        return super.save(entityVo);
    }

    @Override
    public Result<Long> delete(Long id) {
        return super.delete(id);
    }
}
