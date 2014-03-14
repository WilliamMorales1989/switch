/**
 * 
 */
package com.ec.tvcable.switch_aprov.servicio.ems;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;
import org.switchyard.test.SwitchYardTestKit;

/**
 * @author pablo
 *
 */
@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(config = SwitchYardTestCaseConfig.SWITCHYARD_XML, mixins = { CDIMixIn.class })
public class EMSTest {

	private SwitchYardTestKit testKit;
	private CDIMixIn cdiMixIn;
	@ServiceOperation("EMS")
	private Invoker service;

	@Test
	public void testEMS() throws Exception {
		EMS_Type message = new EMS_Type();
		Header header = new Header();
		header.setTarget("target");
		message.setHeader(header);
		EMSResponse result = service.operation("EMS").sendInOut(message)
				.getContent(EMSResponse.class);

		Assert.assertEquals("detallentrawaydetalleTvPagada", result.getDescription());
	}

}
