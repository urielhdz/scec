package edu.uag.iidis.scec.filters;
 
import java.io.IOException;
import java.util.Date;
 
import edu.uag.iidis.scec.modelo.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 
public class LoginFilter implements Filter {
    private Log log = LogFactory.getLog(LoginFilter.class);
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
 
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        User user = (User) request.getSession().getAttribute("user");
        String url = getOriginalUri(request);
            log.debug(">The URL is: "+url);
        
        if (user != null || url.contains("login") || url.contains("css")) {
            chain.doFilter(req, res);     
        }
        else{
            request.getRequestDispatcher("/login/solicitarRegistroSesion.do").forward(req,res);
        } 
        

    }
    public void init(FilterConfig config) throws ServletException {
         
        
    }
    public void destroy() {
        //add code to release any resource
    }
    private String getOriginalUri(HttpServletRequest request) {
    String targetUrl = request.getServletPath();
    if (request.getQueryString() != null) {
        targetUrl += "?" + request.getQueryString();
    }
    return targetUrl;
}
}