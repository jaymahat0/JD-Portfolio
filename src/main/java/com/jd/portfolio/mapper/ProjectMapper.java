package com.jd.portfolio.mapper;

import com.jd.portfolio.dto.project.ProjectRequestDto;
import com.jd.portfolio.dto.project.ProjectResponseDto;
import com.jd.portfolio.entity.Project;

import java.util.Objects;

public final class ProjectMapper {

    public ProjectMapper() {
    }

    public static ProjectResponseDto toResponse(Project project) {

        if (project == null) {
            return null;
        }

        return ProjectResponseDto.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .githubUrl(project.getGithubUrl())
                .liveUrl(project.getLiveUrl())
                .imageUrl(project.getImageUrl())
                .featured(project.getFeatured())
                .build();
    }

    public static Project toEntity(ProjectRequestDto dto) {

        if (dto == null) {
            return null;
        }

        return Project.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .githubUrl(dto.getGithubUrl())
                .liveUrl(dto.getLiveUrl())
                .imageUrl(dto.getImageUrl())
                .featured(dto.getFeatured())
                .build();
    }

    public static void updateEntity(Project project,
                                    ProjectRequestDto dto) {

        Objects.requireNonNull(project, "Project cannot be null");
        Objects.requireNonNull(dto, "ProjectRequestDto cannot be null");

        project.setTitle(dto.getTitle());
        project.setDescription(dto.getDescription());
        project.setGithubUrl(dto.getGithubUrl());
        project.setLiveUrl(dto.getLiveUrl());
        project.setImageUrl(dto.getImageUrl());
        project.setFeatured(dto.getFeatured());
    }
}