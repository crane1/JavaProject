package lizem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lizem.model.Student;
import lizem.service.IUserInfoService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class IndexController extends AbstractController{
	IUserInfoService userService = null;

	public IUserInfoService getUserService() {
		return userService;
	}

	public void setUserService(IUserInfoService userService) {
		this.userService = userService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		Student stu = userService.selectByPrimaryKey("3");
		
		ModelAndView modelAndView = new ModelAndView("succeed");
		modelAndView.addObject("user", stu.getName());
		return modelAndView;
	}

}
