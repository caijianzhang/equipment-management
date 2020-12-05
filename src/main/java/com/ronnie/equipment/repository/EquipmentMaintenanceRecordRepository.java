package com.ronnie.equipment.repository;

import com.ronnie.common.repository.CommonRepository;
import com.ronnie.equipment.pojo.EquipmentMaintenanceRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentMaintenanceRecordRepository extends CommonRepository<EquipmentMaintenanceRecord, Long> {
}
