package com.ec.tvcable.switchaprov.service.tvconax;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import javax.swing.Timer;
import com.ec.tvcable.switchaprov.service.tvpagada.Respuesta;

public class Yprd_apro_conax {

	private String contador;
	private String errorno;
	private String errormessage;
	private Respuesta respuesta;
	private int bandera = 0;
	public RespuestaConax resConax (ParametrosConax parConax){
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("switch-aprovisionamiento");
		EntityManager enmanager = emfactory.createEntityManager();
		
		try{
			
			Query query1 = enmanager.createNativeQuery("insert into ytbl_conax q (q.id,q.process_id,q.citem_id,q.serial,q.activitytype,q.state,q.creation_date) values((select max(w.id) + 1 from ytbl_conax w),?,?,?,?,0,sysdate)")
					.setParameter(1, parConax.getProcess_id())
					.setParameter(2, parConax.getCitem_id())
					.setParameter(3, parConax.getSerial())
					.setParameter(4, parConax.getActivity());
					
			query1.getSingleResult();
			
		}catch(Exception e){
			
			System.out.println("query_error = "+e);
		}
		
		try{
					
			Query query2 = enmanager.createNativeQuery("select count(1) from ytbl_conax w where w.id = (select max(q.id) from ytbl_conax q where q.citem_id = ?) and w.errorno is not null")
					.setParameter(1, parConax.getCitem_id());
					
			contador = query2.getResultList().get(0).toString();
			
			System.out.println("contador = "+contador);
			
			bandera = 0;
			
			while (contador.equals("0")) {
				
				Query query3 = enmanager.createNativeQuery("select count(1) from ytbl_conax w where w.id = (select max(q.id) from ytbl_conax q where q.citem_id = ?) and w.errorno is not null")
						.setParameter(1, parConax.getCitem_id());
						
				contador = query3.getResultList().get(0).toString();
				System.out.println("contador = "+contador);
				
				Thread.sleep(5000);
				
				bandera ++;
				System.out.println("bandera = "+bandera);
				
				if (bandera == 12){
					contador = "2";
					errorno = "1";
					errormessage = "No se genero el archivo xml";
				}
				
				
				
				if (contador.equals("1")){
					
					Query query4 = enmanager.createNativeQuery("select w.errorno from ytbl_conax w where w.id = (select max(q.id) from ytbl_conax q where q.citem_id = ?) and w.errorno is not null")
							.setParameter(1, parConax.getCitem_id());
							
					errorno = query4.getResultList().get(0).toString();
					/*System.out.println("errorno = "+errorno);*/
					
					if (!errorno.equals("0"))
					{
					Query query5 = enmanager.createNativeQuery("select w.errormessage from ytbl_conax w where w.id = (select max(q.id) from ytbl_conax q where q.citem_id = ?) and w.errorno is not null")
							.setParameter(1, parConax.getCitem_id());
					
					errormessage = query5.getResultList().get(0).toString();
					/*System.out.println("errormessage = "+errormessage);*/
					}
				}
				
			}
			
			
			
		}catch(Exception e){
			
			System.out.println("query_error = "+e);
			enmanager.close();
			emfactory.close();
		}
		
		enmanager.close();
		emfactory.close();
				
		RespuestaConax serConax = new RespuestaConax();
		
		serConax.setEstado("A");
		serConax.setXml("xml");
		serConax.setErrorMessage(errormessage);
		serConax.setErrorNo(errorno);
		
		return serConax;
	}
}
