package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.UnavailableException;

public class SetCharacterEncodingFilter implements Filter {
	public void destroy() {
		this.encoding = null;
		this.filterConfig = null;
	}
	protected String selectEncoding(ServletRequest request) {
		return (this.encoding);
	}
}