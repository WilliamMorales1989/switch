/**
 * 
 */
package com.ec.tvcable.switchaprov.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import com.ec.tvcable.switchaprov.InterfazAprovServicio;
import com.ec.tvcable.switchaprov.InterfazResolver;
import com.ec.tvcable.switchaprov.Operation;
import com.ec.tvcable.switchaprov.jpa.InterfazAprovisionamiento;

/**
 * @author pablo
 *
 */
@Service(InterfazResolver.class)
public class InterfazResolverBean implements InterfazResolver {

	/* (non-Javadoc)
	 * @see com.ec.tvcable.switchaprov.InterfazResolver#resolveInterfaces(java.lang.String)
	 */
	
	@Inject
	@Reference
	InterfazAprovServicio interfazAprovServicio;
	
	@Override
	public List<String> resolveInterfaces(Operation operation) {
		List<InterfazAprovisionamiento> intAprovlist = interfazAprovServicio.buscarPorAprovisionamiento(operation);
		List<String> interfaces = new ArrayList<String>();
		for (InterfazAprovisionamiento ia : intAprovlist) {
			interfaces.add(ia.getInterfaceCode());
		}
		return interfaces;
	}

}
