
package com.ec.tvcable.switchaprov.service.tvpagada;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Final complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Final">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FechaFin" type="{http://www.w3.org/2001/XMLSchema}anySimpleType"/>
 *         &lt;element name="TiempoFin" type="{http://www.w3.org/2001/XMLSchema}anySimpleType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Final", propOrder = {
    "fechaFin",
    "tiempoFin"
})
public class Final {

    @XmlElement(name = "FechaFin", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected Object fechaFin;
    @XmlElement(name = "TiempoFin", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected Object tiempoFin;

    /**
     * Gets the value of the fechaFin property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getFechaFin() {
        return fechaFin;
    }

    /**
     * Sets the value of the fechaFin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setFechaFin(Object value) {
        this.fechaFin = value;
    }

    /**
     * Gets the value of the tiempoFin property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getTiempoFin() {
        return tiempoFin;
    }

    /**
     * Sets the value of the tiempoFin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setTiempoFin(Object value) {
        this.tiempoFin = value;
    }

}
