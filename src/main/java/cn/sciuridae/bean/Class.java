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
@ApiModel(value = "Class对象", description = "")
public class Class implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "班级编号")
    private Long class_id;

    @ApiModelProperty(value = "班级名称")
    private String class_name;

    @ApiModelProperty(value = "班长id,不是学号")
    private Integer class_leader_id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getClass_id() {
        return class_id;
    }

    public void setClass_id(Long class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Integer getClass_leader_id() {
        return class_leader_id;
    }

    public void setClass_leader_id(Integer class_leader_id) {
        this.class_leader_id = class_leader_id;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", class_id=" + class_id +
                ", class_name=" + class_name +
                ", class_leader_id=" + class_leader_id +
                "}";
    }
}
