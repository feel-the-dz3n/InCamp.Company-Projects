package com.incamp.companyprojects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
    @Query(value = "SELECT company_id as companyId, id as projectId, name as projectName FROM project WHERE company_id = :companyId", nativeQuery = true)
    Iterable<CompanyProjectDTO> getCompanyProjects(@Param("companyId") Integer companyId);
}
