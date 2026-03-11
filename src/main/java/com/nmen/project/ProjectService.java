package com.nmen.project;

import com.nmen.team.Team;
import com.nmen.team.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final TeamRepository teamRepository;
    private final ProjectRepository projectRepository;

    public Project createProject(CreateProjectRequest request, Integer teamId) {
        var team = teamRepository.findById(teamId)
                .orElseThrow();
        var project = Project.builder()
                .name(request.getName())
                .description(request.getDescription())
                .team(team)
                .createdAt(Instant.now())
                .build();
        projectRepository.save(project);
        return project;
    }

    public List<Project> getProjects(Integer teamId) {
        var team = teamRepository.findById(teamId)
                .orElseThrow();
        return projectRepository.findProjectsByTeam(team);
    }
}
