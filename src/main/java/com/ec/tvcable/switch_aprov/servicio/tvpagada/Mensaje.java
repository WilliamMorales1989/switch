
package com.ec.tvcable.switch_aprov.servicio.tvpagada;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Mensaje complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Mensaje">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CodError" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DetMensaje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DatosExtrasTVP" type="{http://www.grupotvcable.com.ec/WsdlTvPagada/}DatosExtrasTVP"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Mensaje", propOrder = {
    "codError",
    "detMensaje",
    "datosExtrasTVP"
})
public class Mensaje {

    @XmlElement(name = "CodError")
    protected int codError;
    @XmlElement(name = "DetMensaje", required = true)
    protected String detMensaje;
    @XmlElement(name = "DatosExtrasTVP", required = true)
    protected DatosExtrasTVP datosExtrasTVP;

    /**
     * Gets the value of the codError property.
     * 
     */
    public int getCodError() {
        return codError;
    }

    /**
     * Sets the value of the codError property.
     * 
     */
    public void setCodError(int value) {
        this.codError = value;
    }

    /**
     * Gets the value of the detMensaje property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetMensaje() {
        return detMensaje;
    }

    /**
     * Sets the value of the detMensaje property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetMensaje(String value) {
        this.detMensaje = value;
    }

    /**
     * Gets the value of the datosExtrasTVP property.
     * 
     * @return
     *     possible object is
     *     {@link DatosExtrasTVP }
     *     
     */
    public DatosExtrasTVP getDatosExtrasTVP() {
        return datosExtrasTVP;
    }

    /**
     * Sets the value of the datosExtrasTVP property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatosExtrasTVP }
     *     
     */
    public void setDatosExtrasTVP(DatosExtrasTVP value) {
        this.datosExtrasTVP = value;
    }

}
