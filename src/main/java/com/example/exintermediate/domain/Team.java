package com.example.exintermediate.domain;

public class Team {
    private Integer id;
    private String leagueName;
    private String teamName;
    private String headquarters;
    private String inaugurantion;
    private String history;

    @Override
    public String toString() {
        return "Team [id=" + id + ", leagueName=" + leagueName + ", teamName=" + teamName + ", headquarters="
                + headquarters + ", inaugurantion=" + inaugurantion + ", history=" + history + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public String getInaugurantion() {
        return inaugurantion;
    }

    public void setInaugurantion(String inaugurantion) {
        this.inaugurantion = inaugurantion;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

}
