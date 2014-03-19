/**
 * 
 */
package com.ec.tvcable.switchaprov.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.switchyard.component.bean.Service;

import com.ec.tvcable.switchaprov.InterfazAprovServicio;
import com.ec.tvcable.switchaprov.Operation;
import com.ec.tvcable.switchaprov.jpa.InterfazAprovisionamiento;

/**
 * @author pablo
 *
 */
@Service(InterfazAprovServicio.class)
public class InterfazAprovServicioBean implements InterfazAprovServicio {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<InterfazAprovisionamiento> buscarPorAprovisionamiento(
			Operation operation) {
		Query query = em.createNamedQuery("buscarPorAprovisionamiento");
		query.setParameter("target", operation.getSystem());
		query.setParameter("function", operation.getActivityType());
		return query.getResultList();
	}

}
