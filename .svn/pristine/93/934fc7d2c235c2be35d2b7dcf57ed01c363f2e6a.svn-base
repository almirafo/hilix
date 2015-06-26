package com.supportcom.ocp.dao;

import java.util.List;

import com.supportcomm.ocp.entity.Portal;
import com.supportcomm.ocp.entity.PortalLoginVO;

public interface PortalDAO {
	public void save(Portal portal);
	public void delete(Portal portal);
	public Portal findById(Portal portal);
	public Portal findByPortalNumber(Portal portal);
	public List<Portal> listAll();
	public void associatePortalLogin(Long portalId, Long loginId);
	public List<PortalLoginVO> listAllByLogin(Long loginId);

}
