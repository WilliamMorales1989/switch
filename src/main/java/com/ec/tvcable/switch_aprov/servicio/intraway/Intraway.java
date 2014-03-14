
package com.ec.tvcable.switch_aprov.servicio.intraway;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Intraway complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Intraway">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Estandar" type="{http://www.grupotvcable.com.ec/WsdlIntraway/}Estandar"/>
 *         &lt;element name="Interfaz" type="{http://www.grupotvcable.com.ec/WsdlIntraway/}Interfaz"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Intraway", propOrder = {
    "estandar",
    "interfaz"
})
public class Intraway {

    @XmlElement(name = "Estandar", required = true)
    protected Estandar estandar;
    @XmlElement(name = "Interfaz", required = true)
    protected Interfaz interfaz;

    /**
     * Gets the value of the estandar property.
     * 
     * @return
     *     possible object is
     *     {@link Estandar }
     *     
     */
    public Estandar getEstandar() {
        return estandar;
    }

    /**
     * Sets the value of the estandar property.
     * 
     * @param value
     *     allowed object is
     *     {@link Estandar }
     *     
     */
    public void setEstandar(Estandar value) {
        this.estandar = value;
    }

    /**
     * Gets the value of the interfaz property.
     * 
     * @return
     *     possible object is
     *     {@link Interfaz }
     *     
     */
    public Interfaz getInterfaz() {
        return interfaz;
    }

    /**
     * Sets the value of the interfaz property.
     * 
     * @param value
     *     allowed object is
     *     {@link Interfaz }
     *     
     */
    public void setInterfaz(Interfaz value) {
        this.interfaz = value;
    }

}
