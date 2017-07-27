package lizem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lizem.model.Student;
import lizem.service.IUserInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller(value="spring")
@RequestMapping("/spring")
public class IndexController extends AbstractController{
	
	 @Autowired
	IUserInfoService userService = null;
	
	public IndexController() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public IUserInfoService getUserService() {
		return userService;
	}

	public void setUserService(IUserInfoService userService) {
		this.userService = userService;
	}

	@RequestMapping("/index.action")
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		Student stu = userService.selectByPrimaryKey("3");
		
		ModelAndView modelAndView = new ModelAndView("succeed");
		modelAndView.addObject("user", stu.getName());
		return modelAndView;
	}

}
