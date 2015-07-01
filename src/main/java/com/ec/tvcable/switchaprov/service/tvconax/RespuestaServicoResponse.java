
package com.ec.tvcable.switchaprov.service.tvconax;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for respuestaServicoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="respuestaServicoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="respuestaServicoConax" type="{urn:com.example.switchyard:ServicioConax:1.0}respuestaServicoConax" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "respuestaServicoResponse", propOrder = {
    "respuestaServicoConax"
})
public class RespuestaServicoResponse {

    protected RespuestaServicoConax respuestaServicoConax;

    /**
     * Gets the value of the respuestaServicoConax property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaServicoConax }
     *     
     */
    public RespuestaServicoConax getRespuestaServicoConax() {
        return respuestaServicoConax;
    }

    /**
     * Sets the value of the respuestaServicoConax property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaServicoConax }
     *     
     */
    public void setRespuestaServicoConax(RespuestaServicoConax value) {
        this.respuestaServicoConax = value;
    }

}
