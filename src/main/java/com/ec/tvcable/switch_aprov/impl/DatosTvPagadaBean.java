/**
 * 
 */
package com.ec.tvcable.switch_aprov.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.switchyard.component.bean.Service;

import com.ec.tvcable.switch_aprov.DatosTvPagada;
import com.ec.tvcable.switch_aprov.exception.DataQueryException;
import com.ec.tvcable.switch_aprov.jpa.TransactionSpTvPagada;

/**
 * @author pablo
 *
 */
@Service(DatosTvPagada.class)
public class DatosTvPagadaBean implements DatosTvPagada {
	
	@PersistenceContext
	private EntityManager em;

	/* (non-Javadoc)
	 * @see com.ec.tvcable.switch_aprov.DatosTvPagada#buscarPorDevice(java.lang.String)
	 */
	@Override
	public TransactionSpTvPagada findByDevice(String deviceId) throws DataQueryException {
		Query query = em.createNamedQuery("buscarPorDevice");
		try {
			query.setParameter("deviceId", Long.parseLong(deviceId));
			return (TransactionSpTvPagada) query.getSingleResult();
		} catch (NoResultException e) {
			throw new DataQueryException(String.format("No existen datos para el device %s", deviceId), e);
		}catch (NonUniqueResultException e) {
			throw new DataQueryException(String.format("Existen varios registros para el device %s", deviceId), e);
		} catch (Exception e) {
			throw new DataQueryException(String.format("No se pudo consultar datos para el device %s, error: %s", deviceId, e.getMessage()), e);
		}
	}

}
