package cn.easybuy.web;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.nullValue;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.print.attribute.ResolutionSyntax;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;


public abstract class AbstractServlet extends HttpServlet{
	
	public abstract Class getServletClass();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		Method method = null;
		Object result = null;
		if(StringUtils.isEmpty(action)){
			req.getRequestDispatcher("/pre/index.jsp").forward(req, resp);
		}else{
			try {
				method = getServletClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
				result = method.invoke(this, req, resp);
				toView(req, resp, result);
			} catch (NoSuchMethodException e) {
				String error = "404.jsp";
				req.getRequestDispatcher(error).forward(req, resp);
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void toView(HttpServletRequest req, HttpServletResponse resp, Object result){
		if(!StringUtils.isEmpty(result)){
			if(result instanceof String){
				String url = result.toString() + ".jsp";
				try {
					req.getRequestDispatcher(url).forward(req, resp);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				writer(result, resp);
			}
		}
	}
	
	public void writer(Object object,HttpServletResponse resp){
		resp.setContentType("text/html; charset=UTF-8");
		String json = JSONObject.toJSONString(object);
		PrintWriter writer = null;
		try {
			writer = resp.getWriter();
			writer.print(json);
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			writer.close();
		}
	}
	
}
