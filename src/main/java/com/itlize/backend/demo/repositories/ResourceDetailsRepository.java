package com.itlize.backend.demo.repositories;

import com.itlize.backend.demo.entities.Project;
import com.itlize.backend.demo.entities.Resource;
import com.itlize.backend.demo.entities.ResourceDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResourceDetailsRepository extends JpaRepository<ResourceDetails, Integer> {

    List<ResourceDetails> findByResource(Resource resource);
    Optional<ResourceDetails> findByResourceAndProjectColumn_ProjectAndProjectColumn_ColumnName(Resource resource, Project project, String columnName);
}
