package com.ronnie.equipment.repository;

import com.ronnie.common.repository.CommonRepository;
import com.ronnie.equipment.pojo.EquipmentUpkeepPlan;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentUpkeepPlanRepository extends CommonRepository<EquipmentUpkeepPlan, Long> {
}
