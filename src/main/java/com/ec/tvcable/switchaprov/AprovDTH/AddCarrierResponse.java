
package com.ec.tvcable.switchaprov.AprovDTH;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AddCarrierResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "addCarrierResult"
})
@XmlRootElement(name = "AddCarrierResponse")
public class AddCarrierResponse {

    @XmlElement(name = "AddCarrierResult")
    protected String addCarrierResult;

    /**
     * Obtiene el valor de la propiedad addCarrierResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddCarrierResult() {
        return addCarrierResult;
    }

    /**
     * Define el valor de la propiedad addCarrierResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddCarrierResult(String value) {
        this.addCarrierResult = value;
    }

}
