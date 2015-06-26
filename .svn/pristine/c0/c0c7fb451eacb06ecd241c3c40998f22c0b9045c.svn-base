package com.supportcom.ocp.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import com.supportcom.ocp.service.PortalServiceImpl;
import com.supportcomm.ocp.entity.Portal;
import com.supportcomm.ocp.entity.PortalLoginVO;
import com.supportcomm.ocp.entity.Site;

@ManagedBean(name="portalBean")
@RequestScoped
public class PortalManagedBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2625957338012051868L;
	private Long portalId;
	private String name;
	private String description;
	private String portalNumber;
	private Site site =  new Site();
	private List<PortalLoginVO> selectedAccessRights = new ArrayList<PortalLoginVO>(); 
	
	private Portal portal = new Portal();

	
    private Map<Long, Boolean> checked = new HashMap<Long, Boolean>();
    private List<PortalLoginVO> items;
	
	
	
	
	
	public PortalManagedBean(){
		 this.portalId = 0l;
		 this.name ="";
		 this.description="";
		 this.portalNumber="";
		 this.site = new Site();
	}
	public void reset(){
		 this.portalId = 0l;
		 this.name ="";
		 this.description="";
		 this.portalNumber="";
		 this.site =  new Site();
		 
    }
	
    public String save(){
    	
    	PortalServiceImpl service = new PortalServiceImpl();
    	
    	Portal portal = new Portal();
        portal.setName(this.name);
        portal.setDescription(this.description);
        portal.setPortalNumber(this.portalNumber);
        portal.setSite(this.site);
        portal.setDnid("qqq");

        if(this.portalId>0){
            portal.setPortalId(this.portalId);
        	service.update(portal);
        } else{
        	service.save(portal); 
        }
        return "portal";
    }
	
	
    public String load(Portal portal){
    	PortalServiceImpl service = new PortalServiceImpl();
        this.portal = service.findById(portal);
        
        this.name= portal.getName();
        this.portalId = portal.getPortalId();
        this.description = portal.getDescription();
        this.site = portal.getSite();
        this.portalNumber = portal.getPortalNumber();
        return("portal");

    }
	
	
    public String remove(Portal portal){
    	PortalServiceImpl service = new PortalServiceImpl();
         service.delete(portal);
         return("portal");
        
    }

    
    public List<Portal> getListAll(){
    	PortalServiceImpl service = new PortalServiceImpl();
      	
    	return service.listAll();
    }
    
    
    private List<PortalLoginVO> listAllByLogin;
    public  List<PortalLoginVO>  setListAllByLogin(Long loginId){
    	PortalServiceImpl service = new PortalServiceImpl();
    	listAllByLogin = service.listAllByLogin(loginId);
    	return listAllByLogin;

    }
    
    
    public List<PortalLoginVO> getListAllByLogin(){
    	
    	return listAllByLogin;
    }
    
    
    
    
    //-----------------------------------------------------------
 

    
    
    
    public List<PortalLoginVO> getSelectedAccessRights() {  
  
        return selectedAccessRights;  
    }  
  
    public void setSelectedAccessRights(List<PortalLoginVO> selectedAccessRights) {  
    	
    	PortalServiceImpl portalService = new PortalServiceImpl();
    	
    	selectedAccessRights = portalService.setSelectedAccessRights(selectedAccessRights);
        
    	this.selectedAccessRights = selectedAccessRights;  
    }  
    
    public String update(){

        List<PortalLoginVO> checkedItems = new ArrayList<PortalLoginVO>();

        for (PortalLoginVO item : this.listAllByLogin) {
            if (item.getChecked() ) {
                checkedItems.add(item);
            }
        }

     
    	PortalServiceImpl portalService = new PortalServiceImpl();
    	
    	portalService.setSelectedAccessRights(checkedItems);
    	 return("portal");
    }
    
    
    
    
	//---------------------------------
	public Long getPortalId() {
		return portalId;
	}
	public void setPortalId(Long portalId) {
		this.portalId = portalId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPortalNumber() {
		return portalNumber;
	}
	public void setPortalNumber(String portalNumber) {
		this.portalNumber = portalNumber;
	}
	public Portal getPortal() {
		return portal;
	}
	public void setPortal(Portal portal) {
		this.portal = portal;
	}

	public Map<Long, Boolean> getChecked() {
		return checked;
	}
	public void setChecked(Map<Long, Boolean> checked) {
		this.checked = checked;
	}
	public List<PortalLoginVO> getItems() {
		return items;
	}
	public void setItems(List<PortalLoginVO> items) {
		this.items = items;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}

	
	
	
	
}