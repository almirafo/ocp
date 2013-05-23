package com.supportcom.ocp.service;

import com.supportcomm.ocp.entity.Portal;

public interface PortalService {
	
	public void save(Portal portal);
	public void delete(Portal portal);
	public Portal findById(Portal portal);
	public Portal findByPortalNumber(Portal portal);

}
