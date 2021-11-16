package com.itlize.backend.demo.services.impl;

import com.itlize.backend.demo.entities.Project;
import com.itlize.backend.demo.entities.Resource;
import com.itlize.backend.demo.entities.ResourceDetails;
import com.itlize.backend.demo.repositories.ResourceDetailsRepository;
import com.itlize.backend.demo.services.ResourceDetailsService;
import com.itlize.backend.demo.utils.dto.ResourceDetailsDto;
import com.itlize.backend.demo.utils.mapper.ResourceDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceDetailsImpl implements ResourceDetailsService {

    private final ResourceDetailsRepository repository;
    private final ResourceDetailsMapper mapper = ResourceDetailsMapper.INSTANCE;

    @Autowired
    public ResourceDetailsImpl(ResourceDetailsRepository repository) {
        this.repository = repository;
    }



    @Override
    public List<ResourceDetails> findByResource(Resource resource) {
        return repository.findByResource(resource);
    }

    @Override
    public ResourceDetails create(ResourceDetails resourceDetails) {
        return repository.save(resourceDetails);
    }

    @Override
    public ResourceDetails update(ResourceDetailsDto dto) {
        ResourceDetails resourceDetails = repository.findById(dto.getId()).orElse(null);
        assert resourceDetails != null;
        mapper.updateResourceDetailsFromDto(dto, resourceDetails);
        return repository.save(resourceDetails);
    }

    @Override
    public ResourceDetails findValue(Resource resource, Project project, String columnName) {
        return repository.findByResourceAndProjectColumn_ProjectAndProjectColumn_ColumnName(
                resource, project, columnName).orElse(null);
    }
}
