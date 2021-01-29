package cn.sciuridae.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@ApiModel(value = "Tags_to_student对象", description = "")
@TableName("tags_to_student")
public class Tags_to_student implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "学生id")
    private Integer tags_student_id;

    @ApiModelProperty(value = "标签id")
    private Integer tags_tags_id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTags_student_id() {
        return tags_student_id;
    }

    public void setTags_student_id(Integer tags_student_id) {
        this.tags_student_id = tags_student_id;
    }

    public Integer getTags_tags_id() {
        return tags_tags_id;
    }

    public void setTags_tags_id(Integer tags_tags_id) {
        this.tags_tags_id = tags_tags_id;
    }

    @Override
    public String toString() {
        return "Tags_to_student{" +
                "id=" + id +
                ", tags_student_id=" + tags_student_id +
                ", tags_tags_id=" + tags_tags_id +
                "}";
    }
}
