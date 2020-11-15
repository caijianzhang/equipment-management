package com.ronnie.equipment.info.service;

import com.ronnie.common.pojo.PageInfo;
import com.ronnie.common.pojo.Result;
import com.ronnie.common.service.CommonServiceImpl;
import com.ronnie.equipment.info.pojo.EquipmentInfo;
import com.ronnie.equipment.info.repository.EquipmentInfoRepository;
import com.ronnie.equipment.info.vo.EquipmentInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EquipmentInfoServiceImpl extends CommonServiceImpl<EquipmentInfoVo, EquipmentInfo, Long> implements EquipmentInfoService {
    @Autowired
    private EquipmentInfoRepository equipmentInfoRepository;

    @Override
    public Result<PageInfo<EquipmentInfoVo>> page(EquipmentInfoVo entityVo) {
        return super.page(entityVo);
    }

    @Override
    public Result<List<EquipmentInfoVo>> list(EquipmentInfoVo entityVo) {
        return super.list(entityVo);
    }

    @Override
    public Result<EquipmentInfoVo> get(Long id) {
        return super.get(id);
    }

    @Override
    public Result<EquipmentInfoVo> save(EquipmentInfoVo entityVo) {
        return super.save(entityVo);
    }

    @Override
    public Result<Long> delete(Long id) {
        return super.delete(id);
    }
}
