
package com.ec.tvcable.switchaprov.service.tvpagada;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IdPaquetes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IdPaquetes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdPaquete" type="{http://www.grupotvcable.com.ec/WsdlTvPagada/}IdPaquete" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "IdPaquetes", propOrder = {
    "idPaquete"
})
public class IdPaquetes {

    @XmlElement(name = "IdPaquete")
    protected List<IdPaquete> idPaquete;
    @XmlAttribute(name = "CantP", namespace = "http://www.grupotvcable.com.ec/WsdlTvPagada/")
    protected Integer cantP;

    /**
     * Gets the value of the idPaquete property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idPaquete property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdPaquete().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdPaquete }
     * 
     * 
     */
    public List<IdPaquete> getIdPaquete() {
        if (idPaquete == null) {
            idPaquete = new ArrayList<IdPaquete>();
        }
        return this.idPaquete;
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
