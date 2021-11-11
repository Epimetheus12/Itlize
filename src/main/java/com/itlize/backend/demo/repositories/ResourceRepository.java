package com.itlize.backend.demo.repositories;

import com.itlize.backend.demo.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ResourceRepository extends JpaRepository<Resource, Integer> {

}
