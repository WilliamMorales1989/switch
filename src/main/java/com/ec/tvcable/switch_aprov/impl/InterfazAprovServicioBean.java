/**
 * 
 */
package com.ec.tvcable.switch_aprov.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.switchyard.component.bean.Service;

import com.ec.tvcable.switch_aprov.InterfazAprovServicio;
import com.ec.tvcable.switch_aprov.Operation;
import com.ec.tvcable.switch_aprov.jpa.InterfazAprovisionamiento;

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
		query.setParameter("target", operation.getTarget());
		query.setParameter("function", operation.getFunction());
		return query.getResultList();
	}

}
