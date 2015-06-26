package com.supportcom.ocp.managedbean;



import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.supportcom.ocp.service.IvrServiceImpl;
import com.supportcom.ocp.service.LoginServiceImpl;
import com.supportcomm.ocp.entity.Company;
import com.supportcomm.ocp.entity.Ivr;
import com.supportcomm.ocp.entity.Login;
import com.supportcomm.ocp.entity.Site;
import com.supportcomm.ocp.util.Telas;




@ManagedBean(name="ivrBean")
@ViewScoped
public class IvrManagedBean {

	  
	   IvrServiceImpl ivrService;
	   
	   


	    private static Logger log = Logger.getLogger(IvrManagedBean.class);
	    private static final String SUCCESS = "success";
	    private static final String ERROR   = "error";
	    
	    private Long ivrId=0l;
	    private String ivrCode="";
	    private Long capacity=0l;
	    private Site site= new Site();
	    private String message;
	   
	    
	    public IvrManagedBean(){
		    ivrId=0l;
		    ivrCode="";
		    capacity=0l;
		    site= new Site();
		    Ivr ivr = new Ivr();	
	    }
	    
	    



	    
	    public Ivr edit(Ivr ivr){		   
	    	 ivrId=ivr.getIvrId();
	    	 ivrCode=ivr.getIvrCode();
	         capacity=ivr.getCapacity();
	         site= ivr.getSite();
	    	return ivr;
	    }
	    
	    public void remove(Ivr ivr){
	    	ivrService =  new IvrServiceImpl();
	    	ivrService.delete(ivr);
	    	
	    }
	    
	    public String save(){
	    	ivrService =  new IvrServiceImpl();
	    	
	    	
	    	Ivr ivr = new Ivr();
	    	
	    	ivr.setCapacity(this.capacity);
	    	ivr.setIvrCode(this.ivrCode);
	    	ivr.setSite(this.site);
	    	ivr.setIvrId(this.ivrId);
	    	
	    	
	    	
	    	
	    	if(ivrId>0){
	    		ivrService.update(ivr);
	    	}else{
	    		ivrService.save(ivr);
	    	}
	    		
	    	
	    	return "user";
	    }
	    
	    
	    public List<Ivr> getListAll(){
	    	ivrService =  new IvrServiceImpl();
	    	return ivrService.getListAll();
	    	
	    }
	    
	    
	    
	    public void reset() {
		    ivrId=0l;
		    ivrCode="";
		    capacity=0l;
		    site= new Site();
		    Ivr ivr = new Ivr();
	    }


	    //----------------------------------------------------------



		public IvrServiceImpl getIvrService() {
			return ivrService;
		}






		public void setIvrService(IvrServiceImpl ivrService) {
			this.ivrService = ivrService;
		}






		public Long getIvrId() {
			return ivrId;
		}






		public void setIvrId(Long ivrId) {
			this.ivrId = ivrId;
		}






		public String getIvrCode() {
			return ivrCode;
		}






		public void setIvrCode(String ivrCode) {
			this.ivrCode = ivrCode;
		}






		public Long getCapacity() {
			return capacity;
		}






		public void setCapacity(Long capacity) {
			this.capacity = capacity;
		}






		public Site getSite() {
			return site;
		}






		public void setSite(Site site) {
			this.site = site;
		}






		public String getMessage() {
			return message;
		}






		public void setMessage(String message) {
			this.message = message;
		}
	    
	   
	
}
