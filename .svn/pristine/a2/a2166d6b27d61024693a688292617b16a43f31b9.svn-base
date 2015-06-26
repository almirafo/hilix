package com.supportcom.ocp.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import com.supportcom.ocp.service.SiteServiceImpl;
import com.supportcomm.ocp.entity.Site;

@ManagedBean(name="siteBean")
@RequestScoped
public class SiteManagedBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2625957338012051868L;
	private Long siteId;
	private String name;
	private String description;
	private Boolean edita = new Boolean(Boolean.FALSE);
	
	private Site site = new Site();
	
	public SiteManagedBean(){
		 this.siteId = 0l;
		 this.name ="";
		 this.description="";
	}
	public void reset(ActionEvent actionEvent ){
		this.siteId = 0l;
		this.name ="";
		this.description="";
		 setEdita(Boolean.FALSE);
    }
	
    public void save(ActionEvent actionEvent ){
    	
    	SiteServiceImpl service = new SiteServiceImpl();
    	
        Site site = new Site();
        site.setName(this.name);
        site.setDescription(this.description);

        if(this.siteId>0){
            site.setSiteId(this.siteId);
        	service.update(site);
        } else{
        	service.save(site); 
        }
    }
	
	
    public String load(Site site){
    	SiteServiceImpl service = new SiteServiceImpl();
        this.site = service.load(site);
        
        name= site.getName();
        siteId = site.getSiteId();
        description = site.getDescription();
        return("site");

    }
	
	
    public String remove(Site site){
    	SiteServiceImpl service = new SiteServiceImpl();
         service.remove(site);
         return("site");
        
    }

    
    public List<Site> getListAll(){
    	SiteServiceImpl service = new SiteServiceImpl();
      	
    	return service.listAll();
    }
	//---------------------------------
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
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
	public Boolean getEdita() {
		return edita;
	}
	public void setEdita(Boolean edita) {
		this.edita = edita;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}


	
	
	
}