package com.supportcom.ocp.service;

import com.supportcom.ocp.dao.PortalDAOImpl;
import com.supportcomm.ocp.entity.Ivr;
import com.supportcomm.ocp.entity.Portal;

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

}
