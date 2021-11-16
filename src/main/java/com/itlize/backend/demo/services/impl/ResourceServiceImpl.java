package com.itlize.backend.demo.services.impl;

import com.itlize.backend.demo.entities.Resource;
import com.itlize.backend.demo.repositories.ResourceRepository;
import com.itlize.backend.demo.services.ResourceService;
import com.itlize.backend.demo.utils.dto.ResourceDto;
import com.itlize.backend.demo.utils.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;
    private final ResourceMapper mapper = ResourceMapper.INSTANCE;

    @Autowired
    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }


    @Override
    @Transactional
    public List<Resource> initData( ) {
        Resource r1 = new Resource();
        Resource r2 = new Resource();

        r1.setName("r1");
        r1.setResourceCode("1");
//        r1.setCreatedTime(new Timestamp(new Date().getTime()));

        r2.setName("r2");
        r2.setResourceCode("2");
//        r2.setCreatedTime(new Timestamp(new Date().getTime()));

        r1 = resourceRepository.save(r1);
        r2 = resourceRepository.save(r2);
        return resourceRepository.findAllById(Arrays.asList(r1.getId(), r2.getId()));
    }

    @Override
    public Resource findOneById(int id) {
        return resourceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Resource> findAll( ) {
        return resourceRepository.findAll();
    }

    @Override
    public Resource createOne(Resource resource) {
        return resourceRepository.save(resource);
    }

    @Override
    public Resource updateOneById(ResourceDto dto) {
        Resource resource = resourceRepository.findById(dto.getId()).orElse(null);
        assert resource != null;
        mapper.updateResourceFromDto(dto, resource);
        return resourceRepository.save(resource);
    }

    @Override
    public Boolean deleteOne(Resource resource) {
        resourceRepository.delete(resource);
        return !resourceRepository.exists(Example.of(resource));
    }
}
