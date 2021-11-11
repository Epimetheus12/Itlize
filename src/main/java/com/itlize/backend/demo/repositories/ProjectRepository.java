package com.itlize.backend.demo.repositories;

import com.itlize.backend.demo.entities.Project;
import com.itlize.backend.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findAllByUser_Id(int id);
}
