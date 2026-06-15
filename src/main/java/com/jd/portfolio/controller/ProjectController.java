package com.jd.portfolio.controller;

import com.jd.portfolio.dto.project.ProjectRequestDto;
import com.jd.portfolio.dto.project.ProjectResponseDto;
import com.jd.portfolio.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public List<ProjectResponseDto> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ProjectResponseDto getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponseDto createProject(
            @RequestBody ProjectRequestDto requestDto) {
        return projectService.createProject(requestDto);
    }

    @PutMapping("/{id}")
    public ProjectResponseDto updateProject(
            @PathVariable Long id,
            @RequestBody ProjectRequestDto requestDto) {

        return projectService.updateProject(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }
}