package com.itlize.backend.demo.utils.mapper;

import com.itlize.backend.demo.entities.Resource;
import com.itlize.backend.demo.utils.dto.ResourceDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ResourceMapper {
    ResourceMapper INSTANCE = Mappers.getMapper(ResourceMapper.class);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateResourceFromDto(ResourceDto dto, @MappingTarget Resource entity);
}
