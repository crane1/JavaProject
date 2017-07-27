package lizem.test;

import java.io.IOException;
import java.io.InputStream;

import lizem.dao.StudentMapper;
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
//			Student student = mapper.selectByPrimaryKey("7");
			int i = mapper.deleteByPrimaryKey("2");
			System.out.println(i);
//			System.out.println(student.getName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
}
