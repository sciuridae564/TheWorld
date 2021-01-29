package cn.sciuridae.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 *
 * </p>
 *
 * @author sciuridae
 * @since 2021-01-28
 */
@ApiModel(value = "Student对象", description = "")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "学生学号")
    private Long student_id;

    @ApiModelProperty(value = "学生姓名")
    private String student_name;

    @ApiModelProperty(value = "学生性别")
    private Boolean student_sex;

    @ApiModelProperty(value = "学生生日")
    private LocalDate student_bir;

    @ApiModelProperty(value = "学生班级id")
    private Integer student_class_id;

    @ApiModelProperty(value = "学生组别id")
    private Integer student_team_id;

    @ApiModelProperty(value = "学生qq号")
    private Long qq_number;

    @ApiModelProperty(value = "学生就业城市")
    private Integer work_city;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public Boolean getStudent_sex() {
        return student_sex;
    }

    public void setStudent_sex(Boolean student_sex) {
        this.student_sex = student_sex;
    }

    public LocalDate getStudent_bir() {
        return student_bir;
    }

    public void setStudent_bir(LocalDate student_bir) {
        this.student_bir = student_bir;
    }

    public Integer getStudent_class_id() {
        return student_class_id;
    }

    public void setStudent_class_id(Integer student_class_id) {
        this.student_class_id = student_class_id;
    }

    public Integer getStudent_team_id() {
        return student_team_id;
    }

    public void setStudent_team_id(Integer student_team_id) {
        this.student_team_id = student_team_id;
    }

    public Long getQq_number() {
        return qq_number;
    }

    public void setQq_number(Long qq_number) {
        this.qq_number = qq_number;
    }

    public Integer getWork_city() {
        return work_city;
    }

    public void setWork_city(Integer work_city) {
        this.work_city = work_city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", student_id=" + student_id +
                ", student_name=" + student_name +
                ", student_sex=" + student_sex +
                ", student_bir=" + student_bir +
                ", student_class_id=" + student_class_id +
                ", student_team_id=" + student_team_id +
                ", qq_number=" + qq_number +
                ", work_city=" + work_city +
                "}";
    }
}
