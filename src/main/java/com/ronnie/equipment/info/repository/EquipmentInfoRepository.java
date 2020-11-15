package com.ronnie.equipment.info.repository;

import com.ronnie.common.repository.CommonRepository;
import com.ronnie.equipment.info.pojo.EquipmentInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentInfoRepository extends CommonRepository<EquipmentInfo, Long> {
}
