/**
 * 
 */
package com.ec.tvcable.switchaprov.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;
import org.switchyard.test.SwitchYardTestKit;

import com.ec.tvcable.switchaprov.service.aprov.AprovisionamientoResponse;
import com.ec.tvcable.switchaprov.service.aprov.Aprovisionamiento_Type;
import com.ec.tvcable.switchaprov.service.aprov.HeaderRequest;
import com.ec.tvcable.switchaprov.service.ems.EMSResponse;
import com.ec.tvcable.switchaprov.service.ems.EMS_Type;
import com.ec.tvcable.switchaprov.service.ems.Header;

/**
 * @author pablo
 * 
 */
@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(config = SwitchYardTestCaseConfig.SWITCHYARD_XML, mixins = { CDIMixIn.class })
public class AprovionamientoTest {

	private SwitchYardTestKit testKit;
	private CDIMixIn cdiMixIn;
	@ServiceOperation("Aprovisionamiento")
	private Invoker service;

	@Test
	public void testEMS() throws Exception {
		Aprovisionamiento_Type message = new Aprovisionamiento_Type();
		HeaderRequest header = new HeaderRequest();
		header.setTarget("target");
		message.setHeaderRequest(header);
		AprovisionamientoResponse result = service.operation("Aprovisionamiento").sendInOut(message)
				.getContent(AprovisionamientoResponse.class);

		Assert.assertEquals("detallentrawaydetalleTvPagada", result.getBodyResponse().getResponseMessage());
	}

}
