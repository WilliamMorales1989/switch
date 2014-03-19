/**
 * 
 */
package com.ec.tvcable.switchaprov;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.component.test.mixins.http.HTTPMixIn;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;
import org.switchyard.test.SwitchYardTestKit;

import com.ec.tvcable.switchaprov.test.BaseTest;

/**
 * @author pablo
 *
 */
@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(config = SwitchYardTestCaseConfig.SWITCHYARD_XML, mixins = { CDIMixIn.class, HTTPMixIn.class })
public class HolaMundoTest extends BaseTest {

	private SwitchYardTestKit testKit;
	private CDIMixIn cdiMixIn;
	@ServiceOperation("HolaMundo")
	private Invoker service;
	
	private HTTPMixIn httpMixIn;

	@Test
	public void testSaludar() throws Exception {
		// TODO Auto-generated method stub
		// initialize your test message
		String message = "Pablo";
		String result = service.operation("saludar").sendInOut(message).getContent(String.class);

		// validate the results
		Assert.assertEquals("Hola Pablo", result);
	}

	@Test
	public void invocarServicio() throws Exception {
		String respuesta = httpMixIn.postFile("http://localhost:8080/switch-aprovisionamiento/HolaMundo", "src/test/resources/saludar.xml");
		System.out.println(respuesta);
		httpMixIn.postStringAndTestXML("http://localhost:8080/switch-aprovisionamiento/HolaMundo", loadStringXML("saludar.xml"), loadStringXML("respuesta.xml"));
	}

	
}
