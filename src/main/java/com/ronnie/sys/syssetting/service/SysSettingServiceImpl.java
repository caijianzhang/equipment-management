package com.ronnie.sys.syssetting.service;

import com.ronnie.common.pojo.Result;
import com.ronnie.common.service.CommonServiceImpl;
import com.ronnie.sys.syssetting.pojo.SysSetting;
import com.ronnie.sys.syssetting.repository.SysSettingRepository;
import com.ronnie.sys.syssetting.vo.SysSettingVo;
import com.ronnie.util.SysSettingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class SysSettingServiceImpl extends CommonServiceImpl<SysSettingVo, SysSetting, String> implements SysSettingService{

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SysSettingRepository sysSettingRepository;

    @Override
    public Result<SysSettingVo> save(SysSettingVo entityVo) {
        //调用父类
        Result<SysSettingVo> result = super.save(entityVo);

        //更新系统设置时同步更新公用静态集合sysSettingMap
        SysSettingUtil.setSysSettingMap(result.getData());

        return result;
    }
}
