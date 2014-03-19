
package com.ec.tvcable.switchaprov.service.tvpagada;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NumPaq complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NumPaq">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdPay" type="{http://www.grupotvcable.com.ec/WsdlTvPagada/}IdPay" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="CantP" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NumPaq", propOrder = {
    "idPay"
})
public class NumPaq {

    @XmlElement(name = "IdPay")
    protected List<IdPay> idPay;
    @XmlAttribute(name = "CantP", namespace = "http://www.grupotvcable.com.ec/WsdlTvPagada/")
    protected Integer cantP;

    /**
     * Gets the value of the idPay property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idPay property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdPay().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdPay }
     * 
     * 
     */
    public List<IdPay> getIdPay() {
        if (idPay == null) {
            idPay = new ArrayList<IdPay>();
        }
        return this.idPay;
    }

    /**
     * Gets the value of the cantP property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCantP() {
        return cantP;
    }

    /**
     * Sets the value of the cantP property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCantP(Integer value) {
        this.cantP = value;
    }

}
