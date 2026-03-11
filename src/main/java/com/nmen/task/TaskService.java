package com.nmen.task;

import com.nmen.project.ProjectRepository;
import com.nmen.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public Task createTask(CreateTaskRequest request, Integer projectId) {
        var email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        var user = userRepository.findByEmail(email)
                .orElseThrow();
        var project = projectRepository.findById(projectId)
                .orElseThrow();
        var task = Task.builder()
                .name(request.getName())
                .description(request.getDescription())
                .assignee(request.getAssignee())
                .status(TaskStatus.TODO)
                .project(project)
                .createdBy(user)
                .build();
        taskRepository.save(task);
        return task;
    }
}
