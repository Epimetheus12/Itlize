package com.itlize.backend.demo.utils.mapper.impl;

import com.itlize.backend.demo.entities.Project;
import com.itlize.backend.demo.entities.ProjectColumn;
import com.itlize.backend.demo.entities.Type;
import com.itlize.backend.demo.utils.dto.ProjectColumnDto;
import com.itlize.backend.demo.utils.dto.ProjectDto;
import com.itlize.backend.demo.utils.mapper.ProjectColumnMapper;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

//@Component
//public class ProjectColumnMapperImpl implements ProjectColumnMapper {
//
//    @Override
//    public void updateProjectColumnFromDto(ProjectColumnDto dto, ProjectColumn entity) {
//        if ( dto == null ) {
//            return;
//        }
//
//        entity.setId( dto.getId() );
//        if ( dto.getColumnName() != null ) {
//            entity.setColumnName( dto.getColumnName() );
//        }
//        if ( dto.getFormula() != null ) {
//            entity.setFormula( dto.getFormula() );
//        }
//        if ( dto.getType() != null ) {
//            entity.setType(Type.valueOf(dto.getType()));
//        }
//    }
//}
