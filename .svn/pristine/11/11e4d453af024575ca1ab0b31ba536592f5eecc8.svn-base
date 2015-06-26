package com.supportcom.ocp.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import com.supportcom.ocp.service.OccupationServiceImpl;
import com.supportcomm.ocp.entity.PieChartOccupationPortalVO;
import com.supportcomm.ocp.entity.PieChartOccupationSiteVO;
import com.supportcomm.ocp.entity.PieChartOccupationTotalVO;
import com.supportcomm.ocp.entity.Site;

@ManagedBean(name="chartBean")
@RequestScoped
public class ChartManagedBean{
	
	
    String portal="BLABLABLA";
    String seriesColors="0000FF,088A29";
    Long capacity = 1l;
    
    private CartesianChartModel categoryModel;
    
    private PieChartModel livePieModel;

	public ChartManagedBean() {
        createLivePieModel();
        seriesColors="#0000FF";
        capacity = 1l;
	}


	public String getPortal() {
		return portal;
	}

	public void setPortal(String portal) {
		this.portal = portal;
	}

	public PieChartModel getLivePieOccupationTotalByLogin() {
		
		OccupationServiceImpl occuService = new OccupationServiceImpl();
		
		PieChartOccupationTotalVO  pc =occuService.totalOccupationByLogged();

		livePieModel.getData().put("Free", pc.getTotalCapacity()- pc.getUsed());
        livePieModel.getData().put("Use", pc.getUsed());

        return livePieModel;
    }

    private void createLivePieModel() {
        livePieModel = new PieChartModel();

        livePieModel.set("Free", 540);
        livePieModel.set("Use", 325);
    }

    
    
	public PieChartModel getLivePieOccupationSiteByLogin(String siteName, Long totalCapacity, Long used) {
		
		
		livePieModel.getData().put("Free", totalCapacity);
        livePieModel.getData().put("Use", used);

        return livePieModel;
    }

    
	 public List<PieChartOccupationPortalVO> getListAll(){
		   OccupationServiceImpl occuService = new OccupationServiceImpl();
	    	List<PieChartOccupationPortalVO>  pc =occuService.portalOccupationByLogged();
	    	return pc;
	    } 
	 
	
	//---- Call Chart Bar by Portals----------
	private void createCategoryModel() { 
		   OccupationServiceImpl occuService = new OccupationServiceImpl();
	    	List<PieChartOccupationPortalVO>  pcs =occuService.portalOccupationByLogged();
	    	
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
	 
	 public CartesianChartModel getCategoryModel() {
		    createCategoryModel(); 
	        return categoryModel;  
	  } 
	//---------------------------Call Chart Bar by Portals--------  
	
	public List<PieChartOccupationSiteVO> getListOccupationSiteByLogin(){
		
		
		 OccupationServiceImpl occuService = new OccupationServiceImpl();
		List<PieChartOccupationSiteVO> sites = new ArrayList<>();
		sites =occuService.portalOccupationSiteByLogged();

		return sites;
	}
	
	
	
	
	
	public PieChartModel livePieOccupationSiteByLogin(Site site){

		
		 OccupationServiceImpl occuService = new OccupationServiceImpl();
		PieChartOccupationSiteVO siteOccupation = new PieChartOccupationSiteVO();
		siteOccupation =occuService.portalOccupationSiteByLogged(site);
		
		

		PieChartModel livePieModel1 = new PieChartModel();
		if(siteOccupation.getTotalCapacity()!= null){
			livePieModel1.getData().put("Free", siteOccupation.getTotalCapacity() - siteOccupation.getUsed());
	        livePieModel1.getData().put("Use", siteOccupation.getUsed());
		}else{
			livePieModel1.getData().put("Free", 1);
	        livePieModel1.getData().put("Use", 0);
		}
        return livePieModel1;
	}
	
	

	//----------------------------------------------------------------------
	  public String showDetailByPortal(){
		  
		  return "occupationChartPortal";
	  }


	  public String showDetailBySitePortal(){
		  
		  return "occupationSitePortal";
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
    
}
