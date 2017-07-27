package lizem.model;

public class Student {
    private String id;

    private String pwd;

    private String name;

    private Integer qx;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getQx() {
        return qx;
    }

    public void setQx(Integer qx) {
        this.qx = qx;
    }
}