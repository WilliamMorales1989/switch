/**
 * 
 */
package com.ec.tvcable.switchaprov;

import java.util.List;




/**
 * @author pablo
 *
 */
public interface IntrawayInterfaceService  {

	public List<InterfaceInvocationResponse> invokeInterfaces(AprovisionamientoInterfaces comandoEmsInterfaces);

	InterfaceInvocationResponse generateResponseIntraway();

}
