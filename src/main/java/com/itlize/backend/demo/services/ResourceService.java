package com.itlize.backend.demo.services;


import com.itlize.backend.demo.entities.Resource;
import com.itlize.backend.demo.utils.dto.ResourceDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResourceService {

    List<Resource> initData();

    Resource findOneById(int id);

    List<Resource> findAll();

    Resource createOne(Resource resource);

    Resource updateOneById(ResourceDto dto);

    Boolean deleteOne(Resource resource);
}
