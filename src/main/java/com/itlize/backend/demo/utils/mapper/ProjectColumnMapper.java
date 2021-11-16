package com.itlize.backend.demo.utils.mapper;

import com.itlize.backend.demo.entities.ProjectColumn;
import com.itlize.backend.demo.entities.Type;
import com.itlize.backend.demo.utils.dto.ProjectColumnDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProjectColumnMapper {
    ProjectColumnMapper INSTANCE = Mappers.getMapper(ProjectColumnMapper.class);
    default void updateProjectColumnFromDto(ProjectColumnDto dto, ProjectColumn entity){
        if ( dto == null ) {
            return;
        }

        entity.setId( dto.getId() );
        if ( dto.getColumnName() != null ) {
            entity.setColumnName( dto.getColumnName() );
        }
        if ( dto.getFormula() != null ) {
            entity.setFormula( dto.getFormula() );
        }
        if ( dto.getType() != null ) {
            entity.setType(Type.valueOf(dto.getType()));
        }
    }
}
