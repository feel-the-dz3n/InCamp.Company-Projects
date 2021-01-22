package com.incamp.companyprojects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ContributionRepository extends CrudRepository<Contribution, Integer> {
    @Query(value = "" +
            "select " +
            "c.id, " +
            "c.person_id as PersonId, " +
            "c.end_date as EndDate, " +
            "c.start_date as StartDate, " +
            "c.project_id as ProjectId, " +
            "p.name as ProjectName " +
            "from contribution as c " +
            "right join project as p on p.id = c.id " +
            "where c.person_id = :personId", nativeQuery = true)
    Iterable<ContributionProjectDTO> findContributionProjectByPerson(@Param("personId") Integer personId);
}
