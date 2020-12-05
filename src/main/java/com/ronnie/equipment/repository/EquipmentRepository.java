package com.ronnie.equipment.repository;

import com.ronnie.common.repository.CommonRepository;
import com.ronnie.equipment.pojo.Equipment;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends CommonRepository<Equipment, Long> {

}
