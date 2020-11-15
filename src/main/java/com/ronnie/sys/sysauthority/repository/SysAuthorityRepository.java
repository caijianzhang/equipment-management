package com.ronnie.sys.sysauthority.repository;

import com.ronnie.common.repository.CommonRepository;
import com.ronnie.sys.sysauthority.pojo.SysAuthority;
import org.springframework.stereotype.Repository;

@Repository
public interface SysAuthorityRepository extends CommonRepository<SysAuthority, String> {
}
