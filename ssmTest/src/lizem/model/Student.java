package lizem.model;

import java.util.Arrays;

public class Student {
    private String id;

    private String pwd;

    private String name;

    private Integer qx;

    private String[] likes;
    
    private Contry contry;
    
    
    
    public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


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

    public String[] getLikes() {
        return likes;
    }

    public void setLikes(String[] likes) {
        this.likes = likes;
    }

	public Contry getContry() {
		return contry;
	}

	public void setContry(Contry contry) {
		this.contry = contry;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", pwd=" + pwd + ", name=" + name
				+ ", qx=" + qx + ", likes=" + Arrays.toString(likes)
				+ ", contry=" + contry + "]";
	}
    
	
    
}