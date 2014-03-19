
package com.ec.tvcable.switchaprov.service.tvpagada;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Detalle complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Detalle">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TVpagada" type="{http://www.grupotvcable.com.ec/WsdlTvPagada/}TVpagada"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Detalle", propOrder = {
    "tVpagada"
})
public class Detalle {

    @XmlElement(name = "TVpagada", required = true)
    protected TVpagada tVpagada;

    /**
     * Gets the value of the tVpagada property.
     * 
     * @return
     *     possible object is
     *     {@link TVpagada }
     *     
     */
    public TVpagada getTVpagada() {
        return tVpagada;
    }

    /**
     * Sets the value of the tVpagada property.
     * 
     * @param value
     *     allowed object is
     *     {@link TVpagada }
     *     
     */
    public void setTVpagada(TVpagada value) {
        this.tVpagada = value;
    }

}
