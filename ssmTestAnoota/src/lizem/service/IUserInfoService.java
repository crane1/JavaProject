package lizem.service;

import java.util.List;
import java.util.Map;

import lizem.model.Student;

public interface IUserInfoService {
	int deleteByPrimaryKey(String id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String id);
    
    List<Student> selectByPrimaryKeys(List<String> id);
    
    List<Student> selectByPrimaryName(String name);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    Student selectStudenByid(String id);

	List<Student> selectByPrimaryKeys2(Map<String, Object> map);
}
