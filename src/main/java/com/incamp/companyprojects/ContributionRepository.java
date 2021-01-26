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

    @Query(value = "" +
            "select " +
            "* " +
            "from contribution as c " +
            "where c.person_id = :personId " +
            "and c.project_id = :projectId", nativeQuery = true)
    Iterable<Contribution> findByPersonAndProject(
            @Param("personId") Integer personId,
            @Param("projectId") Integer projectId);

    @Query(value = "" +
            "select " +
            "count(*) " +
            "from contribution as c " +
            "where c.person_id = :personId " +
            "and c.project_id = :projectId", nativeQuery = true)
    Long countByPersonAndProject(
            @Param("personId") Integer personId,
            @Param("projectId") Integer projectId);

    @Query(value = "" +
            "select " +
            "* " +
            "from contribution as c " +
            "where c.project_id = :projectId", nativeQuery = true)
    Iterable<Contribution> findByProject(@Param("projectId") Integer projectId);
}
