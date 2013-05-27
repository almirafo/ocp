package com.supportcom.ocp.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import com.supportcom.ocp.service.PortalServiceImpl;
import com.supportcomm.ocp.entity.Portal;
import com.supportcomm.ocp.entity.PortalLoginVO;

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
	private List<Portal> accessRights = new ArrayList<Portal>(); 
	private List<Portal> selectedAccessRights = new ArrayList<Portal>(); 
	private boolean Checkado=true;
	
	private Portal portal = new Portal();

	
	public PortalManagedBean(){
		 this.portalId = 0l;
		 this.name ="";
		 this.description="";
		 this.portalNumber="";
	}
	public void reset(ActionEvent actionEvent ){
		 this.portalId = 0l;
		 this.name ="";
		 this.description="";
		 this.portalNumber="";
    }
	
    public void save(ActionEvent actionEvent ){
    	
    	PortalServiceImpl service = new PortalServiceImpl();
    	
    	Portal portal = new Portal();
        portal.setName(this.name);
        portal.setDescription(this.description);
        portal.setPortalNumber(this.portalNumber);


        if(this.portalId>0){
            portal.setPortalId(this.portalId);
        	service.update(portal);
        } else{
        	service.save(portal); 
        }
    }
	
	
    public String load(Portal portal){
    	PortalServiceImpl service = new PortalServiceImpl();
        this.portal = service.findById(portal);
        
        name= portal.getName();
        portalId = portal.getPortalId();
        description = portal.getDescription();
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
    
    
    public List<PortalLoginVO> listAllByLogin(Long loginId){
    	PortalServiceImpl service = new PortalServiceImpl();
    	List<PortalLoginVO> p = service.listAllByLogin(loginId);
    	
    	return p;
    }
    
    
    
    //-----------------------------------------------------------
    public void setAccessRights(List<Portal> accessRights) {
    	for( Portal portal :accessRights){
    		System.out.println("Portal : " + portal.getName());
    	}
        this.accessRights = accessRights;  
    }
    
    public List<Portal> getAccessRights() {  
    	PortalServiceImpl service = new PortalServiceImpl();
      	
    	return service.listAll();
    }  

    
    
    
    public List<Portal> getSelectedAccessRights() {  
  
        return selectedAccessRights;  
    }  
  
    public void setSelectedAccessRights(List<Portal> selectedAccessRights) {  
    	
    	PortalServiceImpl portalService = new PortalServiceImpl();
    	
    	selectedAccessRights = portalService.setSelectedAccessRights(selectedAccessRights);
        
    	this.selectedAccessRights = selectedAccessRights;  
    }  
    
    public String update(List<Portal> selectedAccessRights){
    	PortalServiceImpl portalService = new PortalServiceImpl();
    	
    	portalService.setSelectedAccessRights(selectedAccessRights);
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
	public boolean isCheckado() {
		return Checkado;
	}
	public void setCheckado(boolean checkado) {
		Checkado = checkado;
	}

	


	
	
	
}