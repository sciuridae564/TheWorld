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
@ApiModel(value = "Tags_to_class对象", description = "")
public class Tags_to_class implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "班级id")
    private Integer tags_class_id;

    @ApiModelProperty(value = "标签id")
    private Integer tags_tags_id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTags_class_id() {
        return tags_class_id;
    }

    public void setTags_class_id(Integer tags_class_id) {
        this.tags_class_id = tags_class_id;
    }

    public Integer getTags_tags_id() {
        return tags_tags_id;
    }

    public void setTags_tags_id(Integer tags_tags_id) {
        this.tags_tags_id = tags_tags_id;
    }

    @Override
    public String toString() {
        return "Tags_to_class{" +
                "id=" + id +
                ", tags_class_id=" + tags_class_id +
                ", tags_tags_id=" + tags_tags_id +
                "}";
    }
}
