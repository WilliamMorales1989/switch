
package com.ec.tvcable.switch_aprov.servicio.tvpagada;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Comando complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Comando">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Cabecera" type="{http://www.grupotvcable.com.ec/WsdlTvPagada/}Cabecera"/>
 *         &lt;element name="Detalle" type="{http://www.grupotvcable.com.ec/WsdlTvPagada/}Detalle"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Comando", propOrder = {
    "cabecera",
    "detalle"
})
@XmlRootElement(name="ejecutaComando")
public class Comando {

    @XmlElement(name = "Cabecera", required = true)
    protected Cabecera cabecera;
    @XmlElement(name = "Detalle", required = true)
    protected Detalle detalle;

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
     * Gets the value of the detalle property.
     * 
     * @return
     *     possible object is
     *     {@link Detalle }
     *     
     */
    public Detalle getDetalle() {
        return detalle;
    }

    /**
     * Sets the value of the detalle property.
     * 
     * @param value
     *     allowed object is
     *     {@link Detalle }
     *     
     */
    public void setDetalle(Detalle value) {
        this.detalle = value;
    }

}
