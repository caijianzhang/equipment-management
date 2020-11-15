package com.ronnie.department.repository;

import com.ronnie.common.repository.CommonRepository;
import com.ronnie.department.pojo.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CommonRepository<Employee, Long> {
}
