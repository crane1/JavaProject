package lizem.test;

import lizem.model.Student;
import lizem.service.IUserInfoService;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {
	 @Test
     public void testDao(){
		 ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		 IUserInfoService userService = ac.getBean("StudentService", IUserInfoService.class);
		 
		 Student stu = userService.selectByPrimaryKey("2");
		 System.out.println(stu);
	 
     }
}
