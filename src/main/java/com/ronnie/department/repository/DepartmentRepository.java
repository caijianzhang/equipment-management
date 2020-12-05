package com.ronnie.department.repository;

import com.ronnie.common.repository.CommonRepository;
import com.ronnie.department.pojo.Department;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CommonRepository<Department, Long> {
}
