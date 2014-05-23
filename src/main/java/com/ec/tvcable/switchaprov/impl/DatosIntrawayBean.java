/**
 * 
 */
package com.ec.tvcable.switchaprov.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.switchyard.component.bean.Service;

import com.ec.tvcable.switchaprov.DatosIntraway;
import com.ec.tvcable.switchaprov.DeviceProcess;
import com.ec.tvcable.switchaprov.exception.DataQueryException;
import com.ec.tvcable.switchaprov.jpa.TransactionSpIntraway;;

/**
 * @author pablo
 * 
 */
@Service(DatosIntraway.class)
public class DatosIntrawayBean implements DatosIntraway {

	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ec.tvcable.switchaprov.DatosIntraway#findByDevice(java.lang.String
	 * )
	 */
	
	@Override
	public TransactionSpIntraway findByDevice(DeviceProcess deviceProcess) throws DataQueryException {
		Query query = em.createNamedQuery("findByDeviceAndProcessIntraway");
		
		try {
			query.setParameter("deviceId", Integer.parseInt(deviceProcess.getDeviceId()) );
			query.setParameter("processId", Long.parseLong(deviceProcess.getProcessId()));
			return (TransactionSpIntraway)query.getSingleResult() ;
		} catch (NoResultException e) {
			throw new DataQueryException(String.format("No existen datos de Intraway el device %s process %s ",
					deviceProcess.getDeviceId(), deviceProcess.getProcessId()), e);
		} catch (NonUniqueResultException e) {
			throw new DataQueryException(String.format("Existen varios registros de Intrawaypara el device %s process %s ",
					deviceProcess.getDeviceId(), deviceProcess.getProcessId()), e);
		} catch (Exception e) {
			throw new DataQueryException(String.format(
					"No se pudo consultar datos de Intraway para el device %s process %s , error: %s", deviceProcess.getDeviceId(),
					deviceProcess.getProcessId(), e.getMessage()), e);
		} 
	}

}