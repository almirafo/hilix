package com.supportcomm.ocp.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

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
import com.supportcomm.ocp.entity.Occupation;

/**
 * Servlet implementation class OccupationServlet
 */
@WebServlet(name = "release", description = "Servlet for Lua Control to release", urlPatterns = { "/release" })
public class ReleaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReleaseServlet() {
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
		Occupation occupation = new Occupation();

		

		    String callId =request.getParameter("callId");
				
		    Timestamp ts = new Timestamp(new Date().getTime() );
  
		    OccupationServiceImpl occupationService = new OccupationServiceImpl();
		    occupation.setCallId(callId);
		    occupation =occupationService.findByCallId(occupation);
		    
		    
		    occupation.setHangupStatus("NORMAL");
		    occupation.setDatetimeHangup(ts);
		    
	    
		    System.out.println("ReleaseServlet: callId--->"+ callId);
		    occupationService.release(occupation);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
