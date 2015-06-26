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
import com.supportcom.ocp.service.PortalServiceImpl;
import com.supportcomm.ocp.entity.Ivr;
import com.supportcomm.ocp.entity.Occupation;
import com.supportcomm.ocp.entity.Portal;

/**
 * Servlet implementation class OccupationServlet
 */
@WebServlet(name = "occupation", description = "Servlet for Lua Control", urlPatterns = { "/occupation" })
public class OccupationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OccupationServlet() {
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
		
		String msisdn =request.getParameter("msisdn");
		String ivrCode =request.getParameter("ivrCode");
		String portalNumber =request.getParameter("portalNumber");
		String callId =request.getParameter("callId");
		
		System.out.println( " OccupationServlet : ivrCode--->"+ ivrCode);
		System.out.println( " OccupationServlet : portalNumber--->"+ portalNumber);
		
		Occupation occupation = new Occupation();
		
		IvrServiceImpl ivrService = new IvrServiceImpl();
		Ivr ivr = new Ivr();
		ivr.setIvrCode(ivrCode);
		ivr = ivrService.findByIvrCode(ivr);
		
		Portal portal = new Portal();
		PortalServiceImpl portalService =  new PortalServiceImpl();
		portal.setPortalNumber(portalNumber);
		portal = portalService.findByPortalNumber(portal);
		
		
		
		
		Timestamp ts = new Timestamp(new Date().getTime() );
		
		occupation.setMsisdn(msisdn);
		occupation.setIvr(ivr);
		occupation.setDatetimeIncall(ts);
		occupation.setPortal(portal);
		occupation.setCallId(callId);
		OccupationServiceImpl service = new OccupationServiceImpl();
		service.save(occupation);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
