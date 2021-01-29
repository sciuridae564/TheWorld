package cn.sciuridae.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author sciuridae
 * @since 2021-01-28
 */
@ApiModel(value = "Team对象", description = "")
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "小组编号")
    private Long team_id;

    @ApiModelProperty(value = "小组名称")
    private String team_name;

    @ApiModelProperty(value = "小组昵称")
    private String team_nick;

    @ApiModelProperty(value = "小组标语")
    private String team_slo;

    @ApiModelProperty(value = "组长id,不是学号")
    private Integer team_leader_id;

    @ApiModelProperty(value = "小组对应的班级id")
    private Long team_class_id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getTeam_leader_id() {
        return team_leader_id;
    }

    public void setTeam_leader_id(Integer team_leader_id) {
        this.team_leader_id = team_leader_id;
    }

    public Long getTeam_class_id() {
        return team_class_id;
    }

    public void setTeam_class_id(Long team_class_id) {
        this.team_class_id = team_class_id;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", team_id=" + team_id +
                ", team_name='" + team_name + '\'' +
                ", team_nick='" + team_nick + '\'' +
                ", team_slo='" + team_slo + '\'' +
                ", team_leader_id=" + team_leader_id +
                ", team_class_id=" + team_class_id +
                '}';
    }
}
