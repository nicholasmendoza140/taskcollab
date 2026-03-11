package com.nmen.config;


import com.nmen.project.ProjectRepository;
import com.nmen.team.Team;
import com.nmen.team.TeamMembershipRepository;
import com.nmen.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeamSecurity {

    private final TeamMembershipRepository teamMembershipRepository;
    private final ProjectRepository projectRepository;

    public boolean isTeamMember(Integer teamId, Integer userId) {
        return teamMembershipRepository.existsTeamMembershipByTeamIdAndUserId(teamId, userId);
    }

    public boolean isTeamMemberByProject(Integer projectId, Integer userId) {
        var project = projectRepository.findById(projectId)
                .orElseThrow();
        var teamId = project.getTeam().getId();
        return teamMembershipRepository.existsTeamMembershipByTeamIdAndUserId(teamId, userId);
    }
}
