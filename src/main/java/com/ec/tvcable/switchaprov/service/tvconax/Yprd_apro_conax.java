package com.ec.tvcable.switchaprov.service.tvconax;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Yprd_apro_conax {

	public RespuestaConax resConax (ParametrosConax parConax){
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("switch-aprovisionamiento");
		EntityManager enmanager = emfactory.createEntityManager();
		
		try{
			
			Query query = enmanager.createNativeQuery("BEGIN "
					+ "yprd_apro_conax@bsqatest(?,?,?,?); "
					+ "END;").setParameter(1, parConax.getProcess_id())
					.setParameter(2, parConax.getCitem_id())
					.setParameter(3, parConax.getActivity())
					.setParameter(4, parConax.getSerial());
			
			query.getResultList();
			
		}catch(Exception e){
			
			System.out.println("query_error = "+e);
		}
		
		enmanager.close();
		emfactory.close();
				
		RespuestaConax serConax = new RespuestaConax();
		
		serConax.setEstado("A");
		serConax.setXml("xml");
		
		return serConax;
	}
}
