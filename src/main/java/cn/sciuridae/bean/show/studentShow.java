package cn.sciuridae.bean.show;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class studentShow {
    private static final long serialVersionUID = 1L;

    private Long student_id;

    private String student_name;

    private String student_sex;

    private String student_bir;

    private String student_class;

    private String student_team;

    private Long qq_number;

    private String work_city;

    public studentShow() {
    }

    public studentShow(Long student_id, String student_name, String student_sex, String student_bir, String student_class, String student_team, Long qq_number, String work_city) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_sex = student_sex;
        this.student_bir = student_bir;
        this.student_class = student_class;
        this.student_team = student_team;
        this.qq_number = qq_number;
        this.work_city = work_city;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getStudent_sex() {
        return student_sex;
    }

    public void setStudent_sex(String student_sex) {
        this.student_sex = student_sex;
    }

    public String getStudent_bir() {
        return student_bir;
    }

    public void setStudent_bir(LocalDateTime student_bir) {
        if(student_bir!=null){
            DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.student_bir = student_bir.format(dTF);
        }else {
            this.student_bir = null;
        }
    }

    public String getStudent_class() {
        return student_class;
    }

    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }

    public String getStudent_team() {
        return student_team;
    }

    public void setStudent_team(String student_team) {
        this.student_team = student_team;
    }

    public Long getQq_number() {
        return qq_number;
    }

    public void setQq_number(Long qq_number) {
        this.qq_number = qq_number;
    }

    public String getWork_city() {
        return work_city;
    }

    public void setWork_city(String work_city) {
        this.work_city = work_city;
    }

    @Override
    public String toString() {
        return "studentShow{" +
                ", student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", student_sex='" + student_sex + '\'' +
                ", student_bir=" + student_bir +
                ", student_class='" + student_class + '\'' +
                ", student_team='" + student_team + '\'' +
                ", qq_number=" + qq_number +
                ", work_city='" + work_city + '\'' +
                '}';
    }
}
