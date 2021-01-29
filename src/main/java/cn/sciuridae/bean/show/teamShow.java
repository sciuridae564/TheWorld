package cn.sciuridae.bean.show;

import io.swagger.annotations.ApiModelProperty;

public class teamShow {
    private Long team_id;
    private String team_name;
    private String team_nick;
    private String team_slo;
    private String team_leader;
    private String team_class;

    public Long getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Long team_id) {
        this.team_id = team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTeam_nick() {
        return team_nick;
    }

    public void setTeam_nick(String team_nick) {
        this.team_nick = team_nick;
    }

    public String getTeam_slo() {
        return team_slo;
    }

    public void setTeam_slo(String team_slo) {
        this.team_slo = team_slo;
    }

    public String getTeam_leader() {
        return team_leader;
    }

    public void setTeam_leader(String team_leader) {
        this.team_leader = team_leader;
    }

    public String getTeam_class() {
        return team_class;
    }

    public void setTeam_class(String team_class) {
        this.team_class = team_class;
    }

    @Override
    public String toString() {
        return "teamShow{" +
                "team_id=" + team_id +
                ", team_name='" + team_name + '\'' +
                ", team_nick='" + team_nick + '\'' +
                ", team_slo='" + team_slo + '\'' +
                ", team_leader='" + team_leader + '\'' +
                ", team_class='" + team_class + '\'' +
                '}';
    }
}
