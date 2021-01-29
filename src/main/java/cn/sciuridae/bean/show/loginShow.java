package cn.sciuridae.bean.show;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

public class loginShow {
    private String account_name;

    private String regtime;

    private String role;

    @Override
    public String toString() {
        return "loginShow{" +
                "account_name='" + account_name + '\'' +
                ", regtime='" + regtime + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
