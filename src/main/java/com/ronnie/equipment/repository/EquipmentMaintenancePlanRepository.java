package com.ronnie.equipment.repository;

import com.ronnie.common.repository.CommonRepository;
import com.ronnie.equipment.pojo.EquipmentMaintenancePlan;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentMaintenancePlanRepository extends CommonRepository<EquipmentMaintenancePlan, Long> {
}
