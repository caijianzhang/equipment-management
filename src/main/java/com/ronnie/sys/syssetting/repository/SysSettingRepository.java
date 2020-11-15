package com.ronnie.sys.syssetting.repository;

import com.ronnie.common.repository.CommonRepository;
import com.ronnie.sys.syssetting.pojo.SysSetting;
import org.springframework.stereotype.Repository;

@Repository
public interface SysSettingRepository extends CommonRepository<SysSetting, String> {
}
