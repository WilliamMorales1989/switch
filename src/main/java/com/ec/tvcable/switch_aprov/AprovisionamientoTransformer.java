package com.ec.tvcable.switch_aprov;

import org.switchyard.annotations.Transformer;
import org.w3c.dom.Element;

public final class AprovisionamientoTransformer {

	@Transformer(to = "{urn:com.ec.tvcable.switch_aprov:switch-aprovisionamiento:1.0}aprovisionarResponse")
	public String transformStringToAprovisionarResponse(String from) {
		return "<aprovisionarResponse><string>" + from  + "</string></aprovisionarResponse>";
	}

	@Transformer(from = "{urn:com.ec.tvcable.switch_aprov:switch-aprovisionamiento:1.0}aprovisionar")
	public String transformAprovisionarToString(Element from) {
		return from.getTextContent().trim();
	}

}
