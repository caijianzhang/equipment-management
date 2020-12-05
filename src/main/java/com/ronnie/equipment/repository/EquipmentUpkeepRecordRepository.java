package com.ronnie.equipment.repository;

import com.ronnie.common.repository.CommonRepository;
import com.ronnie.equipment.pojo.EquipmentUpkeepRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentUpkeepRecordRepository extends CommonRepository<EquipmentUpkeepRecord, Long> {
}
