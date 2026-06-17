package com.jd.portfolio.controller;

import com.jd.portfolio.dto.project.ProjectRequestDto;
import com.jd.portfolio.dto.project.ProjectResponseDto;
import com.jd.portfolio.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public Page<ProjectResponseDto> getAllProjects(
            @PageableDefault(page = 0, size = 5)
            Pageable pageable
    ) {
        return projectService.getAllProjects(pageable);
    }

    @GetMapping("/{id}")
    public ProjectResponseDto getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponseDto createProject(
            @Valid @RequestBody ProjectRequestDto requestDto) {
        return projectService.createProject(requestDto);
    }

    @PutMapping("/{id}")
    public ProjectResponseDto updateProject(
            @PathVariable Long id,
            @Valid @RequestBody ProjectRequestDto requestDto) {

        return projectService.updateProject(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }
}