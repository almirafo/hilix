package com.supportcom.ocp.service;

import java.util.List;

import com.supportcom.ocp.dao.OccupationDAOImpl;
import com.supportcom.ocp.dao.OccupationHistoryDAOImpl;
import com.supportcomm.ocp.entity.Ivr;
import com.supportcomm.ocp.entity.Occupation;
import com.supportcomm.ocp.entity.OccupationHistory;
import com.supportcomm.ocp.entity.PieChartOccupationPortalVO;
import com.supportcomm.ocp.entity.PieChartOccupationSiteVO;
import com.supportcomm.ocp.entity.PieChartOccupationTotalVO;
import com.supportcomm.ocp.entity.Site;

public class OccupationServiceImpl implements OccupationService {

	@Override
	public void save(Occupation occupation) {
		OccupationDAOImpl occupationDao = new OccupationDAOImpl();
		occupationDao.save(occupation);

	}

	@Override
	public void remove(Occupation occupation) {
		OccupationDAOImpl occupationDao = new OccupationDAOImpl();
		occupationDao.remove(occupation);

	}

	@Override
	public void release(Occupation occupation) {
		OccupationDAOImpl occupationDao = new OccupationDAOImpl();
		OccupationHistory occupationHistory = new OccupationHistory();
		OccupationHistoryDAOImpl occupationHistoryDao = new OccupationHistoryDAOImpl();
		occupationDao.update(occupation);
		
		setOccupationHistory(occupation, occupationHistory);
		occupationHistoryDao.save(occupationHistory);
		
		occupationDao.remove(occupation);

	}

	@Override
	public void releaseAll(Ivr ivr) {
		OccupationDAOImpl occupationDao = new OccupationDAOImpl();
		occupationDao.releaseAll(ivr);
		
		List<Occupation> occupations= occupationDao.listByIvr(ivr);
		for(Occupation occupation: occupations){
			OccupationHistory occupationHistory = new OccupationHistory();
			OccupationHistoryDAOImpl occupationHistoryDao = new OccupationHistoryDAOImpl();
			
			setOccupationHistory(occupation, occupationHistory);
			occupationHistoryDao.save(occupationHistory);
			
			occupationDao.remove(occupation);
			
		}

	}

	private void setOccupationHistory(Occupation occupation,
			OccupationHistory occupationHistory) {
		occupationHistory.setCallid(occupation.getCallId());
		occupationHistory.setDatetimeHangup(occupation.getDatetimeHangup());
		occupationHistory.setDatetimeInCall(occupation.getDatetimeIncall());
		occupationHistory.setHangupStatus(occupation.getHangupStatus());
		occupationHistory.setIvrCode(occupation.getIvr().getIvrCode());
		occupationHistory.setIvrID(occupation.getIvr().getIvrId());
		occupationHistory.setMsisdn(occupation.getMsisdn());
		occupationHistory.setOccupationId(occupation.getOccupationId());
		occupationHistory.setPortalId(occupation.getPortal().getPortalId());
		occupationHistory.setPortalName(occupation.getPortal().getName());
		occupationHistory.setPortalNumber(occupation.getPortal().getPortalNumber());
		occupationHistory.setSiteId(occupation.getIvr().getSite().getSiteId());
		occupationHistory.setSiteName(occupation.getIvr().getSite().getName());
	}

	@Override
	public Occupation findByMsisdn(Occupation occupation) {
		OccupationDAOImpl occupationDao = new OccupationDAOImpl();
		
		return occupationDao.findByMsisdn(occupation);
	}

	@Override
	public PieChartOccupationTotalVO totalOccupationByLogged() {
		OccupationDAOImpl occupationDao = new OccupationDAOImpl();
		
		return occupationDao.totalOccupationByLogged();
	}

	@Override
	public List<PieChartOccupationPortalVO> portalOccupationByLogged() {
		OccupationDAOImpl occupationDao = new OccupationDAOImpl();
		
		return occupationDao.portalOccupationByLogged();
	}

	@Override
	public Occupation findByCallId(Occupation occupation) {
		OccupationDAOImpl occupationDao = new OccupationDAOImpl();
		
		return occupationDao.findByCallId(occupation);
	}

	public List<PieChartOccupationSiteVO> portalOccupationSiteByLogged() {
		OccupationDAOImpl occupationDao = new OccupationDAOImpl();
		
		return occupationDao.portalOccupationSiteByLogged();
	}

	public PieChartOccupationSiteVO portalOccupationSiteByLogged(Site site) {
		OccupationDAOImpl occupationDao = new OccupationDAOImpl();
		
		return occupationDao.portalOccupationSiteByLogged(site);
	}

	public List<PieChartOccupationPortalVO> portalSiteOccupationByLogged(Site site) {
		OccupationDAOImpl occupationDao = new OccupationDAOImpl();
		
		return occupationDao.portalSiteOccupationByLogged(site);
	}

	
}
