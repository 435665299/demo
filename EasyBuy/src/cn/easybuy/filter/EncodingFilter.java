package cn.easybuy.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(urlPatterns={"/*"} , filterName="EncodeFilter" , initParams={@WebInitParam(name="encode", value="UTF-8")})
public class EncodingFilter implements Filter {
	private String encode;

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		encode = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(request.getCharacterEncoding()==null){
			request.setCharacterEncoding(encode);
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		encode = fConfig.getInitParameter("encode");
		if(this.encode == null){
			this.encode = encode;
		}
	}

}
