package com.supportcom.ocp.dao;

import javax.persistence.EntityManager;

import com.supportcomm.ocp.entity.Portal;
import com.supportcomm.ocp.util.JPAUtil;

public class PortalDAOImpl implements PortalDAO {

	@Override
	public void save(Portal portal) {
	EntityManager em=  JPAUtil.getEntityManager();
		
		try{
			em.getTransaction().begin();
			em.persist(portal);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			
		}finally{
			em.close();
		}

	}

	@Override
	public void delete(Portal portal) {
		EntityManager em=  JPAUtil.getEntityManager();
		
		try{
			em.getTransaction().begin();
			em.remove(portal);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			
		}finally{
			em.close();
		}


	}

	@Override
	public Portal findById(Portal portal) {
		EntityManager em=  JPAUtil.getEntityManager();
		Portal results = new Portal();
		try{
			em.getTransaction().begin();
			results =em.find(Portal.class, portal);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			
		}finally{
			em.close();
		}

		return results;
	}

	@Override
	public Portal findByPortalNumber(Portal portal) {

		EntityManager em=  JPAUtil.getEntityManager();
		Portal results = new Portal();
		try{
			em.getTransaction().begin();
			
		
			results = (Portal)em.createNamedQuery("findByPortalNumber")
						   .setParameter("portalNumber", portal.getPortalNumber())
						   .getSingleResult() ;
						
			 
			
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			
		}finally{
			em.close();
			
		}

		return results;

		
	}

}
