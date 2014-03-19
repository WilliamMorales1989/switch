
package com.ec.tvcable.switchaprov.service.tvpagada;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NumEve complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NumEve">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdEve" type="{http://www.grupotvcable.com.ec/WsdlTvPagada/}IdEve" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="CantE" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NumEve", propOrder = {
    "idEve"
})
public class NumEve {

    @XmlElement(name = "IdEve")
    protected List<IdEve> idEve;
    @XmlAttribute(name = "CantE", namespace = "http://www.grupotvcable.com.ec/WsdlTvPagada/")
    protected Integer cantE;

    /**
     * Gets the value of the idEve property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idEve property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdEve().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdEve }
     * 
     * 
     */
    public List<IdEve> getIdEve() {
        if (idEve == null) {
            idEve = new ArrayList<IdEve>();
        }
        return this.idEve;
    }

    /**
     * Gets the value of the cantE property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCantE() {
        return cantE;
    }

    /**
     * Sets the value of the cantE property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCantE(Integer value) {
        this.cantE = value;
    }

}
