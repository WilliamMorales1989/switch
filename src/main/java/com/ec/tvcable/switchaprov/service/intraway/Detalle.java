
package com.ec.tvcable.switchaprov.service.intraway;

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
 *         &lt;element name="Intraway" type="{http://www.grupotvcable.com.ec/WsdlIntraway/}Intraway"/>
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
    "intraway"
})
public class Detalle {

    @XmlElement(name = "Intraway", required = true)
    protected Intraway intraway;

    /**
     * Gets the value of the intraway property.
     * 
     * @return
     *     possible object is
     *     {@link Intraway }
     *     
     */
    public Intraway getIntraway() {
        return intraway;
    }

    /**
     * Sets the value of the intraway property.
     * 
     * @param value
     *     allowed object is
     *     {@link Intraway }
     *     
     */
    public void setIntraway(Intraway value) {
        this.intraway = value;
    }

}
