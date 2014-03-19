/**
 * 
 */
package com.ec.tvcable.switchaprov;

import org.switchyard.annotations.Transformer;
import org.w3c.dom.Element;

/**
 * @author pablo
 *
 */
public final class SaludarTransformer {

	@Transformer(to = "{urn:com.ec.tvcable.switchaprov:switch-aprovisionamiento:1.0}saludarResponse")
	public String transformStringToSaludarResponse(String from) {
		return "<saludarResponse>" + from  + "</saludarResponse>";
	}

	@Transformer(from = "{urn:com.ec.tvcable.switchaprov:switch-aprovisionamiento:1.0}saludar")
	public String transformSaludarToString(Element from) {
		return from.getTextContent();
	}

}
