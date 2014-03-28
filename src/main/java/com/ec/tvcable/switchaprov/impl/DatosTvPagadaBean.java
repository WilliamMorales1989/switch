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

import com.ec.tvcable.switchaprov.DatosTvPagada;
import com.ec.tvcable.switchaprov.DeviceProcess;
import com.ec.tvcable.switchaprov.exception.DataQueryException;
import com.ec.tvcable.switchaprov.jpa.TransactionSpTvPagada;

/**
 * @author pablo
 * 
 */
@Service(DatosTvPagada.class)
public class DatosTvPagadaBean implements DatosTvPagada {

	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ec.tvcable.switchaprov.DatosTvPagada#buscarPorDevice(java.lang.String
	 * )
	 */
	@Override
	public TransactionSpTvPagada findByDevice(DeviceProcess deviceProcess) throws DataQueryException {
		Query query = em.createNamedQuery("findByDeviceAndProcess");
		try {
			query.setParameter("deviceId", Long.parseLong(deviceProcess.getDeviceId()));
			query.setParameter("processId", Long.parseLong(deviceProcess.getProcessId()));
			return (TransactionSpTvPagada) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("no lo logra");
			throw new DataQueryException(String.format("No existen datos para el device %s process %s ",
					deviceProcess.getDeviceId(), deviceProcess.getProcessId()), e);
		} catch (NonUniqueResultException e) {
			throw new DataQueryException(String.format("Existen varios registros para el device %s process %s ",
					deviceProcess.getDeviceId(), deviceProcess.getProcessId()), e);
		} catch (Exception e) {
			throw new DataQueryException(String.format(
					"No se pudo consultar datos para el device %s process %s , error: %s", deviceProcess.getDeviceId(),
					deviceProcess.getProcessId(), e.getMessage()), e);
		}
	}

}
