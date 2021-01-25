package com.incamp.companyprojects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ContributionRepository extends CrudRepository<Contribution, Integer> {
    @Query(value = "" +
            "select " +
            "* " +
            "from contribution as c " +
            "where c.person_id = :personId", nativeQuery = true)
    Iterable<Contribution> findByPerson(@Param("personId") Integer personId);
}
