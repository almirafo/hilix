package com.supportcom.ocp.service;

import java.util.List;

import com.supportcom.ocp.dao.IvrDAOImpl;
import com.supportcomm.ocp.entity.Ivr;
import com.supportcomm.ocp.entity.Login;

public class IvrServiceImpl implements IvrService {

	private IvrDAOImpl ivrDao = new IvrDAOImpl();
	@Override
	public void save(Ivr ivr) {
		ivrDao.save(ivr);

	}

	@Override
	public void delete(Ivr ivr) {
		ivrDao.delete(ivr);
	}

	@Override
	public Ivr findById(Ivr ivr) {
		// TODO Auto-generated method stub
		return ivrDao.findById(ivr);
	}

	@Override
	public Ivr findByIvrCode(Ivr ivr) {
		return ivrDao.findByIvrCode(ivr);
	}

	public void update(Ivr ivr) {
		ivrDao.update(ivr);

		
	}

	public List<Ivr> getListAll() {
		
		return ivrDao.getListAll();
	}

}
