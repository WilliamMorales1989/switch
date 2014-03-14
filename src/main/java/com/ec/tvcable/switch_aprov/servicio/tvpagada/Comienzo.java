
package com.ec.tvcable.switch_aprov.servicio.tvpagada;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Comienzo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Comienzo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FechaIni" type="{http://www.w3.org/2001/XMLSchema}anySimpleType"/>
 *         &lt;element name="TiempoIni" type="{http://www.w3.org/2001/XMLSchema}anySimpleType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Comienzo", propOrder = {
    "fechaIni",
    "tiempoIni"
})
public class Comienzo {

    @XmlElement(name = "FechaIni", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected Object fechaIni;
    @XmlElement(name = "TiempoIni", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected Object tiempoIni;

    /**
     * Gets the value of the fechaIni property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getFechaIni() {
        return fechaIni;
    }

    /**
     * Sets the value of the fechaIni property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setFechaIni(Object value) {
        this.fechaIni = value;
    }

    /**
     * Gets the value of the tiempoIni property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getTiempoIni() {
        return tiempoIni;
    }

    /**
     * Sets the value of the tiempoIni property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setTiempoIni(Object value) {
        this.tiempoIni = value;
    }

}
