package com.itlize.backend.demo.utils.mapper;


import com.itlize.backend.demo.entities.ResourceDetails;
import com.itlize.backend.demo.utils.dto.ResourceDetailsDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ResourceDetailsMapper {
    ResourceDetailsMapper INSTANCE = Mappers.getMapper(ResourceDetailsMapper.class);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateResourceDetailsFromDto(ResourceDetailsDto dto, @MappingTarget ResourceDetails entity);
}
