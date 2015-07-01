
package com.ec.tvcable.switchaprov.service.tvconax;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for respuestaServico complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="respuestaServico">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datosServicio" type="{urn:com.example.switchyard:ServicioConax:1.0}datosServicio" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "respuestaServico", propOrder = {
    "datosServicio"
})
public class RespuestaServico {

    protected DatosServicio datosServicio;

    /**
     * Gets the value of the datosServicio property.
     * 
     * @return
     *     possible object is
     *     {@link DatosServicio }
     *     
     */
    public DatosServicio getDatosServicio() {
        return datosServicio;
    }

    /**
     * Sets the value of the datosServicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatosServicio }
     *     
     */
    public void setDatosServicio(DatosServicio value) {
        this.datosServicio = value;
    }

}
