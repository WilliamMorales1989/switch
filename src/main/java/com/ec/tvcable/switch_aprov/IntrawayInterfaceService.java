/**
 * 
 */
package com.ec.tvcable.switch_aprov;

import java.util.List;

import com.ec.tvcable.switch_aprov.servicio.ems.EMS_Type;




/**
 * @author pablo
 *
 */
public interface IntrawayInterfaceService  {

	public List<InterfaceInvocationResponse> invokeInterfaces(EMS_Type comandoEms);

}
