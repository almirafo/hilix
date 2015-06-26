package com.supportcom.ocp.service;

import java.util.List;

import com.supportcomm.ocp.entity.Ivr;
import com.supportcomm.ocp.entity.Occupation;
import com.supportcomm.ocp.entity.PieChartOccupationPortalVO;
import com.supportcomm.ocp.entity.PieChartOccupationSiteVO;
import com.supportcomm.ocp.entity.PieChartOccupationTotalVO;
import com.supportcomm.ocp.entity.Site;

public interface OccupationService {
	public void save(Occupation occupation);
	public void remove(Occupation occupation);
	public void release(Occupation occupation);
	public void releaseAll(Ivr ivr);
	public Occupation findByMsisdn(Occupation occupation);
	public Occupation findByCallId(Occupation occupation);
	public PieChartOccupationTotalVO totalOccupationByLogged();
	public List<PieChartOccupationPortalVO> portalOccupationByLogged();
	public List<PieChartOccupationSiteVO> portalOccupationSiteByLogged();
	public PieChartOccupationSiteVO portalOccupationSiteByLogged(Site site);
	public List<PieChartOccupationPortalVO> portalSiteOccupationByLogged(Site site);
}
