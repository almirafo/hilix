package br.com.supportcomm.freecall.service.user;

import java.io.Serializable;
import java.util.List;

import br.com.supportcomm.freecall.entity.UserAccess;
import br.com.supportcomm.freecall.entity.UserType;
import br.com.supportcomm.freecall.impl.user.UserBean;
import br.com.supportcomm.freecall.impl.user.UserBeanLocal;

/**
 * Session Bean implementation class UserService
 */
public class UserService implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
     * Default constructor. 
     */
    public UserService() {
    }
    
    private UserBeanLocal userBean = new UserBean();

	
	public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
		return userBean.queryByRange(jpqlStmt, firstResult, maxResults);
	}

	
	public UserAccess persistUserAccess(UserAccess userAccess) {
		return userBean.persistUserAccess(userAccess);
	}

	
	public UserAccess mergeUserAccess(UserAccess userAccess) {
		return userBean.mergeUserAccess(userAccess);
	}

	
	public void removeUserAccess(UserAccess userAccess) {
		userBean.removeUserAccess(userAccess);
	}

	
	public List<UserAccess> getUserAccessLogin(String login) {
		return userBean.getUserAccessLogin(login);
	}

	
	public List<UserAccess> getUserAccessLoginPass(String login, String senha) {
		return userBean.getUserAccessLoginPass(login, senha);
	}

	
	public List<UserAccess> getUserAccessUsuario(Long idUsuario) {
		return userBean.getUserAccessUsuario(idUsuario);
	}

	
	public List<UserAccess> getUserAccessAll() {
		return userBean.getUserAccessAll();
	}

	
	public List<UserAccess> getUserAccessById(Long id) {
		return userBean.getUserAccessById(id);
	}

	
	public UserType persistUserType(UserType userType) {
		return userBean.persistUserType(userType);
	}

	
	public UserType mergeUserType(UserType userType) {
		return userBean.mergeUserType(userType);
	}

	
	public void removeUserType(UserType userType) {
		userBean.removeUserType(userType);
	}

	
	public List<UserType> getUserTypeAll() {
		return userBean.getUserTypeAll();
	}

	
	public List<UserType> getUserTypeId(Long idUserType) {
		return userBean.getUserTypeId(idUserType);
	}

	
}


