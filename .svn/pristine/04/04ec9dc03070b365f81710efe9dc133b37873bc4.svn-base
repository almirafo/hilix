package com.supportcom.ocp.service;

import java.util.List;

import com.supportcom.ocp.dao.CompanyDAOImpl;
import com.supportcom.ocp.dao.LoginDaoImpl;
import com.supportcomm.ocp.entity.Login;

public class LoginServiceImpl implements LoginService {

	@Override
	public void save(Login login) {
		LoginDaoImpl loginDao = new LoginDaoImpl();
		CompanyDAOImpl companyService =  new CompanyDAOImpl();
		login.setCompany(companyService.load(login.getCompany()));
		loginDao.save(login);
		

	}

	@Override
	public void delete(Login login) {
		 LoginDaoImpl loginDao = new LoginDaoImpl();
		 loginDao.delete(login);
	}

	@Override
	public Login findById(Login login) {
		 LoginDaoImpl loginDao = new LoginDaoImpl();
		return loginDao.findById(login);
	}

	@Override
	public Login findByEmail(Login login) {
		 LoginDaoImpl loginDao = new LoginDaoImpl();
		return loginDao.findByEmail(login);
	}

	@Override
	public Login FindByLogin(Login login) {
		 LoginDaoImpl loginDao = new LoginDaoImpl();
		return loginDao.FindByLogin(login);
	}

	@Override
	public List<Login> getAll() {
		 LoginDaoImpl loginDao = new LoginDaoImpl();
		 
		return loginDao.getAll();
	}

	@Override
	public Login getUserAccessLoginPass(String login, String password) {
		 LoginDaoImpl loginDao = new LoginDaoImpl();
		return loginDao.getUserAccessLoginPass(login, password);
	}

	@Override
	public void update(Login login) {
		 LoginDaoImpl loginDao = new LoginDaoImpl();
		 loginDao.update(login);

	}

}
