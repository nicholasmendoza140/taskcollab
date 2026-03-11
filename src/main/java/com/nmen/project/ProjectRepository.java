package com.nmen.project;

import com.nmen.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findProjectsByTeam(Team team);
}
