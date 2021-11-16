package com.itlize.backend.demo.services;

import com.itlize.backend.demo.entities.Project;
import com.itlize.backend.demo.entities.Resource;
import com.itlize.backend.demo.entities.ResourceDetails;
import com.itlize.backend.demo.utils.dto.ResourceDetailsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResourceDetailsService {
    List<ResourceDetails> findByResource(Resource resource);

    ResourceDetails create(ResourceDetails resourceDetails);

    ResourceDetails update(ResourceDetailsDto dto);

    ResourceDetails findValue(Resource resource, Project project, String columnName);
}
