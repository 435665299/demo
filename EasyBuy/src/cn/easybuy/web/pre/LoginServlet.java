package cn.easybuy.web.pre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import cn.easybuy.entity.User;
import cn.easybuy.service.user.UserService;
import cn.easybuy.utils.ReturnResult;
import cn.easybuy.web.AbstractServlet;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

@WebServlet(urlPatterns={"/login"},name="login" )
public class LoginServlet extends AbstractServlet{
	UserService us = null;

	@Override
	public Class getServletClass() {
		Class class1 = LoginServlet.class;
		return class1;
	}
	
	public String toLogin(HttpServletRequest request,HttpServletResponse response){
		return "/pre/login";		
	}
	
	public ReturnResult login(HttpServletRequest request,HttpServletResponse response){
		ReturnResult result = new ReturnResult();
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		User user = UserService.getUser(loginName);
		if(StringUtils.isEmpty(user)){
			result.returnFail("用户不存在");
		}else{
			if(user.getPassword().equals(password)){
				request.getSession().setAttribute("loginUser", user);
				result.returnSuccess("登录成功");
			}else {
				result.returnFail("用户名或密码不正确");
			}
		}				
		return result;		
	}
	
	public String loginOut(HttpServletRequest request,HttpServletResponse response){
		ReturnResult result = new ReturnResult();
		request.getSession().removeAttribute("loginUser");		
		result.returnSuccess("注销成功");
		return "/pre/login";		
	}
	
	@Override
	public void init() throws ServletException {
		us = new UserService();
	}
	
	
	
	
}
