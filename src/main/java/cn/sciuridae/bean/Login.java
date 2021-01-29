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
@ApiModel(value = "Login对象", description = "")
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String account_name;

    @ApiModelProperty(value = "密码密文")
    private String account_password;

    @ApiModelProperty(value = "注册时间")
    private LocalDateTime regtime;

    @ApiModelProperty(value = "角色")
    private Boolean role;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getAccount_password() {
        return account_password;
    }

    public void setAccount_password(String account_password) {
        this.account_password = account_password;
    }

    public LocalDateTime getRegtime() {
        return regtime;
    }

    public void setRegtime(LocalDateTime regtime) {
        this.regtime = regtime;
    }

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", account_name=" + account_name +
                ", account_password=" + account_password +
                ", regtime=" + regtime +
                ", role=" + role +
                "}";
    }
}
