/**
 * 
 */
package com.ec.tvcable.switchaprov;

import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

/**
 * @author pablo
 *
 */
@Service(HolaMundo.class)
public class HolaMundoBean implements HolaMundo {

	@Inject
	@Reference
	HolaMundoFile holaMundoFile;
	
	@Override
	public String saludar(String nombre) {
		return "Hola " + nombre;
	}

}
