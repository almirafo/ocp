package com.supportcom.ocp.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.supportcom.ocp.dao.CompanyDAOImpl;
import com.supportcomm.ocp.entity.Company;

@ManagedBean(name="companyBean")
@ViewScoped
public class CompanyManagedBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2625957338012051868L;
	private Long companyId;
	private String name;
	private Boolean edita = new Boolean(Boolean.FALSE);
	
	private Company company =  new Company();
	
	public CompanyManagedBean(){
		this.companyId = 0l;
		this.name ="";
	}
	public void reset(ActionEvent actionEvent ){
		this.companyId = 0l;
		this.name ="";
		 setEdita(Boolean.FALSE);
    }
	
    public void save(ActionEvent actionEvent ){
    	
    	CompanyDAOImpl service = new CompanyDAOImpl();
    	
        Company company = new Company();
        company.setName(name);
        
        if(companyId>0){
        	company.setCompanyId(companyId);
        	service.update(company);
        }
        else{
        	service.save(company);
        }
       
    }
	
	
    public String load(Company company){
    	CompanyDAOImpl service = new CompanyDAOImpl();
        this.company = service.load(company);
        this.name= company.getName();
        this.companyId = company.getCompanyId();
        setEdita( Boolean.TRUE);
         return("company.xhtml");
    }
	
	
    public String remove(Company company){
    	CompanyDAOImpl service = new CompanyDAOImpl();
         service.remove(company);
         return("cadastroIntegrante.xhtml");
        
    }

    
    public List<Company> getListAll(){
    	CompanyDAOImpl service = new CompanyDAOImpl();
      	
    	return service.lista();
    }
	//---------------------------------
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Boolean getEdita() {
		return edita;
	}
	public void setEdita(Boolean edita) {
		this.edita = edita;
	}
	
	
	
	
}