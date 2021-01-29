package cn.sciuridae.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author sciuridae
 * @since 2021-01-28
 */
@ApiModel(value = "Tags对象", description = "")
public class Tags implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "标签名称")
    private String tags_name;

    @ApiModelProperty(value = "标签种类")
    private Boolean tags_type;

    @ApiModelProperty(value = "标签创建时间")
    private LocalDateTime tags_createtime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTags_name() {
        return tags_name;
    }

    public void setTags_name(String tags_name) {
        this.tags_name = tags_name;
    }

    public Boolean getTags_type() {
        return tags_type;
    }

    public void setTags_type(Boolean tags_type) {
        this.tags_type = tags_type;
    }

    public LocalDateTime getTags_createtime() {
        return tags_createtime;
    }

    public void setTags_createtime(LocalDateTime tags_createtime) {
        this.tags_createtime = tags_createtime;
    }

    @Override
    public String toString() {
        return "Tags{" +
                "id=" + id +
                ", tags_name=" + tags_name +
                ", tags_type=" + tags_type +
                ", tags_createtime=" + tags_createtime +
                "}";
    }
}
