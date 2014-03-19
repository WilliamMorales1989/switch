
package com.ec.tvcable.switchaprov.service.intraway;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Respuesta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Respuesta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Cabecera" type="{http://www.grupotvcable.com.ec/WsdlIntraway/}Cabecera"/>
 *         &lt;element name="Mensaje" type="{http://www.grupotvcable.com.ec/WsdlIntraway/}Mensaje"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Respuesta", propOrder = {
    "cabecera",
    "mensaje"
})
public class Respuesta {

    @XmlElement(name = "Cabecera", required = true)
    protected Cabecera cabecera;
    @XmlElement(name = "Mensaje", required = true)
    protected Mensaje mensaje;

    /**
     * Gets the value of the cabecera property.
     * 
     * @return
     *     possible object is
     *     {@link Cabecera }
     *     
     */
    public Cabecera getCabecera() {
        return cabecera;
    }

    /**
     * Sets the value of the cabecera property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cabecera }
     *     
     */
    public void setCabecera(Cabecera value) {
        this.cabecera = value;
    }

    /**
     * Gets the value of the mensaje property.
     * 
     * @return
     *     possible object is
     *     {@link Mensaje }
     *     
     */
    public Mensaje getMensaje() {
        return mensaje;
    }

    /**
     * Sets the value of the mensaje property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mensaje }
     *     
     */
    public void setMensaje(Mensaje value) {
        this.mensaje = value;
    }

}
