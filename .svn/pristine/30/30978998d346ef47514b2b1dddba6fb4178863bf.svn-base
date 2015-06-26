package com.supportcom.ocp.service;

import java.util.List;

import com.supportcom.ocp.dao.PortalDAOImpl;
import com.supportcomm.ocp.entity.Portal;
import com.supportcomm.ocp.entity.PortalLoginVO;

public class PortalServiceImpl implements PortalService {

	private PortalDAOImpl portalDao = new PortalDAOImpl();
	@Override
	public void save(Portal portal) {
		portalDao.save(portal);

	}

	@Override
	public void delete(Portal portal) {
		portalDao.delete(portal);
	}

	@Override
	public Portal findById(Portal portal) {
		// TODO Auto-generated method stub
		return portalDao.findById(portal);
	}

	@Override
	public Portal findByPortalNumber(Portal portal) {
		return portalDao.findByPortalNumber(portal);
	}

	public void update(Portal portal) {
		portalDao.update(portal);
		
	}

	public List<Portal> listAll() {
		// TODO Auto-generated method stub
		return portalDao.listAll();
	}

	@Override
	public List<PortalLoginVO> setSelectedAccessRights(List<PortalLoginVO> selectedAccessRights) {
		    Long loginId=selectedAccessRights.get(0).getLoginId();
		    portalDao.removeAllPortalsLogin(loginId);
		  	for( PortalLoginVO portal :selectedAccessRights){
	    		portalDao.associatePortalLogin(portal.getPortalId(), portal.getLoginId());
	    		
	    	}
		  	List<PortalLoginVO> retorno = listAllByLogin( loginId );
	    	
	    	return  retorno;
		}
    	
    	


	public List<PortalLoginVO> listAllByLogin(Long loginId) {
		
		return portalDao.listAllByLogin(loginId);
	}

}
