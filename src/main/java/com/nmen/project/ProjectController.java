package com.nmen.project;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/teams/{teamId}/projects")
    public ResponseEntity<Project> createProject(@PathVariable Integer teamId, @RequestBody CreateProjectRequest request) {
        return ResponseEntity.ok(projectService.createProject(request, teamId));
    }

    @GetMapping("/teams/{teamId}/projects")
    public ResponseEntity<List<Project>> getProjects(@PathVariable Integer teamId) {
        return ResponseEntity.ok(projectService.getProjects(teamId));
    }
}
