package com.ronnie.equipment.repository;

import com.ronnie.common.repository.CommonRepository;
import com.ronnie.equipment.pojo.EquipmentUpkeepSchedule;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentUpkeepScheduleRepository extends CommonRepository<EquipmentUpkeepSchedule, Long> {
}
