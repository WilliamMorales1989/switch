
package com.ec.tvcable.switch_aprov.servicio.tvpagada;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IdPay complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IdPay">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdPay" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdPay", propOrder = {
    "idPay"
})
public class IdPay {

    @XmlElement(name = "IdPay")
    protected int idPay;

    /**
     * Gets the value of the idPay property.
     * 
     */
    public int getIdPay() {
        return idPay;
    }

    /**
     * Sets the value of the idPay property.
     * 
     */
    public void setIdPay(int value) {
        this.idPay = value;
    }

}
