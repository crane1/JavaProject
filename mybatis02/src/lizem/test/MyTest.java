package lizem.test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lizem.dao.ContryMapper;
import lizem.dao.StudentMapper;
import lizem.model.Contry;
import lizem.model.Student;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


public class MyTest {
	 @Test
	    public void testDao(){
		 try {
			InputStream res = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory build = new SqlSessionFactoryBuilder().build(res);
			SqlSession session = build.openSession();
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			
//			Student stu = mapper.selectStudenByid("1");
//			
//			System.out.println(stu);
			
//			ContryMapper mapper = session.getMapper(ContryMapper.class);
			
			/*BigDecimal big = new BigDecimal(1);
			Contry con = mapper.selectByPrimaryKey1(big);
			System.out.println("contry:" + con.getUserlist().size());
			
			for(Student s : con.getUserlist()){
				System.out.println(s);
			}*/
			
			List<String> list = new ArrayList<String>();
			list.add("1");
			list.add("2");
			list.add("3");
			
//			List<Student> stus = mapper.selectByPrimaryKeys(list);
			
			
			Map<String, Object> map = new HashMap<String, Object>();
	        
	        // ����in
	        map.put("ids", list);
	        
	        // ���ڲ�ѯsex
//	        map.put("sexs", stuparam);

	        // ִ��SQL
	        List<Student> stulist = mapper.selectByPrimaryKeys2(map);
	        
	        
			for(Student s : stulist){
				System.out.println(s);
			}
			 
//			System.out.println("inser succeed? " + mapper.insert(student));
			session.commit();
			session.close();
//			System.out.println(student);
//			String[] liks = student.getLikes();
//			
//			for(String l : liks){
//				System.out.println("like:" + l);
//			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
}
