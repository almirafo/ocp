package com.supportcom.ocp.dao;

import com.supportcomm.ocp.entity.Portal;

public interface PortalDAO {
	public void save(Portal portal);
	public void delete(Portal portal);
	public Portal findById(Portal portal);
	public Portal findByPortalNumber(Portal portal);

}
