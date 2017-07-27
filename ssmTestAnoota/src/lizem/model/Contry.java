package lizem.model;

import java.math.BigDecimal;
import java.util.List;

public class Contry {
    private BigDecimal id;

    private String name;
    
    private List<Student> userlist;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	public List<Student> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<Student> userlist) {
		this.userlist = userlist;
	}

	@Override
	public String toString() {
		return "Contry [id=" + id + ", name=" + name + ", userlist=" + userlist
				+ "]";
	}
	
	
    
    
}