package com.kasun.integrator.repository;

import com.kasun.integrator.model.AuditLog;
import org.springframework.data.repository.CrudRepository;

public interface AuditLogRepository extends CrudRepository<AuditLog, Integer> {

}
