package com.supportcom.ocp.service;

import java.util.List;

import com.supportcom.ocp.dao.SiteDAOImpl;
import com.supportcomm.ocp.entity.Site;

public class SiteServiceImpl implements SiteService {

	private SiteDAOImpl siteDao = new SiteDAOImpl();

	@Override
	public void save(Site site) {
		siteDao.save(site);
		
	}

	@Override
	public List<Site> listAll() {

		return siteDao.listAll();
	}

	@Override
	public Site load(Site site) {
		
		return siteDao.load(site);
	}

	@Override
	public void remove(Site site) {
			siteDao.remove(site);
		
	}

	@Override
	public void update(Site site) {
		siteDao.update(site);
		
	}

	

}
