package com.supportcomm.ocp.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supportcom.ocp.service.IvrServiceImpl;
import com.supportcom.ocp.service.OccupationServiceImpl;
import com.supportcomm.ocp.entity.Ivr;

/**
 * Servlet implementation class OccupationServlet
 */
@WebServlet(name = "releaseAll", description = "Servlet for Lua Control to release", urlPatterns = { "/releaseAll" })
public class ReleaseAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReleaseAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String ivrCode =request.getParameter("ivrCode");
		IvrServiceImpl serviceIvr = new IvrServiceImpl();
		Ivr ivr =  new Ivr();
		ivr.setIvrCode(ivrCode);
		ivr =  serviceIvr.findByIvrCode(ivr);
   
		OccupationServiceImpl service = new OccupationServiceImpl();

		    
		service.releaseAll(ivr);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
