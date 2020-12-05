package com.ronnie.equipment.repository;

import com.ronnie.common.repository.CommonRepository;
import com.ronnie.equipment.pojo.EquipmentMaintenanceSchedule;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentMaintenanceScheduleRepository extends CommonRepository<EquipmentMaintenanceSchedule, Long> {
}
