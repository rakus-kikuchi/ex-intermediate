package com.example.exintermediate.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.exintermediate.domain.Team;

@Repository
public class TeamRepository {

    @Autowired
    private static final RowMapper<Team> TEAM_ROW_MAPEER = (rs, i) -> {
        Team team = new Team();
        team.setId(rs.getInt("id"));
        team.setLeagueName(rs.getString("league_name"));
        team.setTeamName(rs.getString("team_name"));
        team.setHeadquarters(rs.getString("headquarters"));
        team.setInaugurantion(rs.getString("inauguration"));
        team.setHistory(rs.getString("history"));
        return team;
    };

    @Autowired
    private NamedParameterJdbcTemplate template;

    public List<Team> findAll() {
        String sql = "SELECT * FROM teams ORDER BY history ASC";
        List<Team> teamList = template.query(sql, TEAM_ROW_MAPEER);
        return teamList;
    }

    public Team teamDetail(Integer id) {
        String sql = "SELECT * FROM teams WHERE id = :id;";
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        try {
            Team team = template.queryForObject(sql, param, TEAM_ROW_MAPEER);
            return team;
        } catch (Exception e) {
            return null;
        }
    }
}
