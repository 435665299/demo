package cn.easybuy.web.pre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;

import cn.easybuy.entity.User;
import cn.easybuy.service.user.UserService;
import cn.easybuy.utils.Constants;
import cn.easybuy.utils.RegUtils;
import cn.easybuy.utils.ReturnResult;
import cn.easybuy.web.AbstractServlet;

@WebServlet(urlPatterns = { "/register" }, name = "register")
public class RegisterServlet extends AbstractServlet {
	private UserService userService;

	@Override
	public Class getServletClass() {
		return RegisterServlet.class;
	}

	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}

	public String toRegister(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/pre/register";
	}

	public ReturnResult doRegister(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ReturnResult result = new ReturnResult();
		User user = new User();
		String loginName = request.getParameter("loginName");
		User oldUser = userService.getUser(loginName);
		if (!StringUtils.isEmpty(oldUser)) {
			result.returnFail("�û����Ѵ���");
			return result;
		} else {
			String passWord1 = request.getParameter("passWord");
			String passWord2 = request.getParameter("rePassWord_2");
			String userName = request.getParameter("userName");
			String sex = request.getParameter("sex");
			String identityCode = request.getParameter("identityCode");
			String email = request.getParameter("email");
			user.setLoginName(loginName);
			user.setUserName(userName);
			user.setPassword(passWord1);
			user.setSex(Integer.parseInt(sex));
			user.setIdentityCode(identityCode);
			user.setEmail(email);
			user.setType(1);
			result = checkUser(user);
			if (result.getStatus() == Constants.ReturnResult.SUCCESS) {
				boolean flag = userService.addUser(user);
				if (flag) {
					result.returnSuccess("ע��ɹ�");
				} else {
					result.returnFail("ע��ʧ��");
				}
			}

		}
		return result;
	}

	public ReturnResult checkUser(User user) {
		ReturnResult result = new ReturnResult();
		if (StringUtils.isEmpty(user.getLoginName())) {
			result.returnFail("�û�������Ϊ��");
			return result;
		}
		if (StringUtils.isEmpty(user.getUserName())) {
			result.returnFail("��������Ϊ��");
			return result;
		}
		if (StringUtils.isEmpty(user.getPassword())) {
			result.returnFail("���벻��Ϊ��");
			return result;
		}

		if (!StringUtils.isEmpty(user.getMobile())) {
			if (!RegUtils.isMobile(user.getMobile())) {
				result.returnFail("�ֻ������ʽ����ȷ");
			}
		}
		if (!StringUtils.isEmpty(user.getEmail())) {
			if (!RegUtils.isEmail(user.getEmail())) {
				result.returnFail("�����ʽ����ȷ");
			}
		}
		if (!StringUtils.isEmpty(user.getIdentityCode())) {
			if (!RegUtils.isIdCard(user.getIdentityCode())) {
				result.returnFail("���֤�Ÿ�ʽ����ȷ");
			}
		}
		result.returnSuccess("��֤ͨ��");
		return result;
	}

}
