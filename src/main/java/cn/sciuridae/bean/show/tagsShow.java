package cn.sciuridae.bean.show;

public class tagsShow {

    private String tags_name;

    private String tags_type;

    private String tags_createtime;

    @Override
    public String toString() {
        return "tagsShow{" +
                "tags_name='" + tags_name + '\'' +
                ", tags_type='" + tags_type + '\'' +
                ", tags_createtime='" + tags_createtime + '\'' +
                '}';
    }

    public String getTags_name() {
        return tags_name;
    }

    public void setTags_name(String tags_name) {
        this.tags_name = tags_name;
    }

    public String getTags_type() {
        return tags_type;
    }

    public void setTags_type(String tags_type) {
        this.tags_type = tags_type;
    }

    public String getTags_createtime() {
        return tags_createtime;
    }

    public void setTags_createtime(String tags_createtime) {
        this.tags_createtime = tags_createtime;
    }
}
