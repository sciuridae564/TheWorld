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
@ApiModel(value = "City对象", description = "")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String city_name;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime city_time;

    @ApiModelProperty(value = "就业人数")
    private Integer city_count;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public LocalDateTime getCity_time() {
        return city_time;
    }

    public void setCity_time(LocalDateTime city_time) {
        this.city_time = city_time;
    }

    public Integer getCity_count() {
        return city_count;
    }

    public void setCity_count(Integer city_count) {
        this.city_count = city_count;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city_name=" + city_name +
                ", city_time=" + city_time +
                ", city_count=" + city_count +
                "}";
    }
}
