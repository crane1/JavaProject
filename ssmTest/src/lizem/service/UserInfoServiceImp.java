package lizem.service;

import java.util.List;
import java.util.Map;

import lizem.dao.StudentMapper;
import lizem.model.Student;

public class UserInfoServiceImp implements IUserInfoService {

	StudentMapper stuMapper = null;
		
	public StudentMapper getStuMapper() {
		return stuMapper;
	}

	public void setStuMapper(StudentMapper stuMapper) {
		this.stuMapper = stuMapper;
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Student record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Student record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return stuMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Student> selectByPrimaryKeys(List<String> id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> selectByPrimaryName(String name) {
		// TODO Auto-generated method stub
		return stuMapper.selectByPrimaryName(name);
	}

	@Override
	public int updateByPrimaryKeySelective(Student record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Student record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student selectStudenByid(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> selectByPrimaryKeys2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
