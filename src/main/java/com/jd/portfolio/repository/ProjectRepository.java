package com.jd.portfolio.repository;

import com.jd.portfolio.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository
        extends JpaRepository<Project, Long> {


//    List<Project> findAllByOrderByDisplayOrderAsc();
//
//    List<Project> findByFeaturedTrue();
//
//    List<Project> findByTechnologiesContainingIgnoreCase(String technology);

}