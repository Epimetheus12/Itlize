package com.itlize.backend.demo.repositories;

import com.itlize.backend.demo.entities.Project;
import com.itlize.backend.demo.entities.ProjectResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ProjectResourceRepository extends JpaRepository<ProjectResource, Integer> {

    Optional<ProjectResource> findByProject_IdAndResource_Id(int pid, int rid);

    @Modifying
    @Query("select p.resource.id from ProjectResource p where p.project.id = :id")
    List<Integer> findAllResourceIdByProjectId(@Param(value = "id") int id);

    @Modifying
    @Query("select p.project.id from ProjectResource p where p.resource.id = :id")
    List<Integer> findAllProjectIdByResourceId(@Param(value = "id") int id);

    void deleteAllByProject_Id(int id);

    void deleteAllByResource_Id(int id);

    Boolean existsAllByProject_Id(int id);

    Boolean existsAllByResource_Id(int id);

    Boolean existsDistinctByProject_IdAndResource_Id(int p_id, int r_id);

//    ProjectResource findDistinctByProject_IdAndResource_Id(int p_id, int r_id);
}
