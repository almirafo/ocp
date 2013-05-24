package com.supportcom.ocp.service;

import java.util.List;

import com.supportcom.ocp.dao.PortalDAOImpl;
import com.supportcomm.ocp.entity.Ivr;
import com.supportcomm.ocp.entity.Portal;
import com.supportcomm.ocp.entity.PortalLoginVO;
import com.supportcomm.ocp.entity.Site;

public class PortalServiceImpl implements PortalService {

	private PortalDAOImpl portalDao = new PortalDAOImpl();
	@Override
	public void save(Portal portal) {
		portalDao.save(portal);

	}

	@Override
	public void delete(Portal portal) {
		portalDao.delete(portal);
	}

	@Override
	public Portal findById(Portal portal) {
		// TODO Auto-generated method stub
		return portalDao.findById(portal);
	}

	@Override
	public Portal findByPortalNumber(Portal portal) {
		return portalDao.findByPortalNumber(portal);
	}

	public void update(Portal portal) {
		portalDao.update(portal);
		
	}

	public List<Portal> listAll() {
		// TODO Auto-generated method stub
		return portalDao.listAll();
	}

	@Override
	public void setSelectedAccessRights(List<Portal> selectedAccessRights) {
		String[] reg =selectedAccessRights.get(0).getName().split(",");
    	Long loginId= Long.parseLong( reg[1].toString());
    	Long portalId= Long.parseLong( reg[0].toString());
    	portalDao.removeAllPortalsLogin(loginId);
    	for( Portal portal :selectedAccessRights){
    		
    		portalDao.associatePortalLogin(portalId, loginId);
    		
    	}

	}

	public List<PortalLoginVO> listAllByLogin(Long loginId) {
		
		return portalDao.listAllByLogin(loginId);
	}

}
