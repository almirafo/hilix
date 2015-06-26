package com.supportcom.ocp.managedbean;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;


import com.supportcom.ocp.dao.SiteDAOImpl;
import com.supportcom.ocp.service.OccupationServiceImpl;
import com.supportcomm.ocp.entity.PieChartOccupationPortalVO;

import com.supportcomm.ocp.entity.Site;

@ManagedBean(name="chartSitePortalBean")
@RequestScoped
public class ChartSitePortalManagedBean {
	
	
    String portal="BLABLABLA";
    String seriesColors="0000FF,088A29";
    Site site = new Site();
    Long capacity = 1l;
    
    private CartesianChartModel categoryModel;
    


	public ChartSitePortalManagedBean() {
        seriesColors="#0000FF";
        capacity = 1l;
        
	}

  	
	 
	 //--------  Call Chart in Dialog
	 public CartesianChartModel getCategoryModelSitePortal(){
		 categoryModel = new CartesianChartModel(); 
		 
		 SiteDAOImpl siteService =  new SiteDAOImpl();
		 
		 
		 if (this.site!=null){
			 
			 
			 this.site = (Site)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("site");
			 System.out.println("Site Name-----> " + this.site.getName());
			 createCategoryModelPortalSite(this.site);
		 }
		 return categoryModel;
	 }
	
	private void createCategoryModelPortalSite(Site site) { 
		   OccupationServiceImpl occuService = new OccupationServiceImpl();
	    	List<PieChartOccupationPortalVO>  pcs =occuService.portalSiteOccupationByLogged(site);
	    	
	        categoryModel = new CartesianChartModel();  
	  
	        ChartSeries portals = new ChartSeries();  
	        portals.setLabel("Users Simultaneous");  
	        
	        if (pcs.isEmpty()){
	        	portals.set("No Data", 0);
	        }
	        for (PieChartOccupationPortalVO pc: pcs){
	        	if (capacity < pc.getUsed()){
	        		setCapacity (  (long) (pc.getUsed() + pc.getUsed() * 1.10));
	        	}
	        	portals.set(pc.getPortalName(), pc.getUsed());  
	        	
	        }
	        
	         categoryModel.addSeries(portals);
	    }
    //--------------------------------- Call Chart in Dialog
	
	
	
	
	
	
	
	public String  loadSite(Site site){
		System.out.println("composeTheParameters : "+  site.getName());
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("site", site);
		setSite(site);
		
		return "occupationSitePortal";
	}
	//----------------------------------------------------------------------
	  public String showDetailByPortal(){
		  
		  return "occupationChartPortal";
	  }

	public String getSeriesColors() {
		return seriesColors;
	}

	public void setSeriesColors(String seriesColors) {
		this.seriesColors = seriesColors;
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

	public String getPortal() {
		return portal;
	}

	public void setPortal(String portal) {
		this.portal = portal;
	}
	
	
	
	
}
