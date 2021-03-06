/**
 * 
 */
package com.ec.tvcable.switchaprov.impl;

import java.util.List;

import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import com.ec.tvcable.switchaprov.InterfazAprovServicio;
import com.ec.tvcable.switchaprov.InterfazResolver;
import com.ec.tvcable.switchaprov.Operation;
import com.ec.tvcable.switchaprov.exception.AprovisionamientoException;
import com.ec.tvcable.switchaprov.jpa.InterfazAprovisionamiento;

/**
 * @author pablo
 * 
 */
@Service(InterfazResolver.class)
public class InterfazResolverBean implements InterfazResolver {

	@Inject
	@Reference
	InterfazAprovServicio interfazAprovServicio;

	@Override
	public List<InterfazAprovisionamiento> resolveInterfaces(Operation operation) throws AprovisionamientoException {
		List<InterfazAprovisionamiento> intAprovlist = interfazAprovServicio.buscarPorAprovisionamiento(operation);
		if (hayInterfaces(intAprovlist)) {
			return intAprovlist;
		} else {
			throw new AprovisionamientoException(String.format(
					"No existen interfaces definidas para system: %s activityType %s", operation.getSystem(),
					operation.getActivityType()));
		}
	}

	private boolean hayInterfaces(List<InterfazAprovisionamiento> intAprovlist) {
		return intAprovlist != null && intAprovlist.size() > 0;
	}

}