package com.nmen.config;


import com.nmen.team.Team;
import com.nmen.team.TeamMembershipRepository;
import com.nmen.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeamSecurity {

    private final TeamMembershipRepository teamMembershipRepository;

    public boolean isTeamMember(Integer teamId, Integer userId) {
        return teamMembershipRepository.existsTeamMembershipByTeamIdAndUserId(teamId, userId);
    }
}
