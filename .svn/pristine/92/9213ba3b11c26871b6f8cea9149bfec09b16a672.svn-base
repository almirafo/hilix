/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supportcomm.ocp.filtro;

 import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author deoliva
 */
public class Filtro implements Filter{  
@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        if (session.getAttribute("logado") != null || req.getRequestURI().endsWith("login.xhtml")) {
            chain.doFilter(request, response);
        } else {
            //HttpServletResponse res = (HttpServletResponse) response;
            //res.sendRedirect( req.getContextPath() + "/faces/login.xhtml");
            
            RequestDispatcher rd = req.getRequestDispatcher("login.xhtml");
		rd.forward(request, response);

            
        }

   
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {
    }
}
