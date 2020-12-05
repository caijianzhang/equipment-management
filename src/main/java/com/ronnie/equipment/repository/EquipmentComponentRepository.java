package com.ronnie.equipment.repository;

import com.ronnie.common.pojo.Result;
import com.ronnie.common.repository.CommonRepository;
import com.ronnie.equipment.pojo.EquipmentComponent;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentComponentRepository extends CommonRepository<EquipmentComponent, Long> {
   Result<EquipmentComponent> getByEquipmentId(Long equipmentId);
}
