package com.ronnie.equipment.service.impl;

import com.ronnie.common.pojo.PageInfo;
import com.ronnie.common.pojo.Result;
import com.ronnie.common.service.CommonServiceImpl;
import com.ronnie.equipment.pojo.EquipmentComponent;
import com.ronnie.equipment.repository.EquipmentComponentRepository;
import com.ronnie.equipment.service.EquipmentComponentService;
import com.ronnie.equipment.vo.EquipmentComponentVo;
import com.ronnie.util.CopyUtil;
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
public class EquipmentComponentServiceImpl extends CommonServiceImpl<EquipmentComponentVo, EquipmentComponent, Long> implements EquipmentComponentService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private EquipmentComponentRepository equipmentInfoRepository;

    @Override
    public Result<PageInfo<EquipmentComponentVo>> page(EquipmentComponentVo entityVo) {
        //根据实体、Vo直接拼接全部SQL
        StringBuilder sql = SqlUtil.joinSqlByEntityAndVo(EquipmentComponent.class, entityVo);

        //设置SQL、映射实体，以及设置值，返回一个Query对象
        Query query = em.createNativeQuery(sql.toString(), EquipmentComponent.class);

        //分页设置，page从0开始
        PageRequest pageRequest = PageRequest.of(entityVo.getPage() - 1, entityVo.getRows());

        //获取最终分页结果
        Result<PageInfo<EquipmentComponentVo>> result = Result.of(PageInfo.of(PageInfo.getJPAPage(query,pageRequest, em), EquipmentComponentVo.class));
        return result;
    }

    @Override
    public Result<List<EquipmentComponentVo>> list(EquipmentComponentVo entityVo) {
        return super.list(entityVo);
    }

    @Override
    public Result<EquipmentComponentVo> get(Long id) {
        return super.get(id);
    }

    @Override
    public Result<EquipmentComponentVo> getByEquipmentId(Long equipmentId) {
        Result<EquipmentComponentVo> result = Result.of(CopyUtil.copy(equipmentInfoRepository.getByEquipmentId(equipmentId).getData(), EquipmentComponentVo.class));
        return result;
    }

    @Override
    public Result<EquipmentComponentVo> save(EquipmentComponentVo entityVo) {
        return super.save(entityVo);
    }

    @Override
    public Result<Long> delete(Long id) {
        return super.delete(id);
    }
}
