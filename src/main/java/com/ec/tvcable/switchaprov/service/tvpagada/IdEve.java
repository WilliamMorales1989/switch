
package com.ec.tvcable.switchaprov.service.tvpagada;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IdEve complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IdEve">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdEve" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdEve", propOrder = {
    "idEve"
})
public class IdEve {

    @XmlElement(name = "IdEve")
    protected int idEve;

    /**
     * Gets the value of the idEve property.
     * 
     */
    public int getIdEve() {
        return idEve;
    }

    /**
     * Sets the value of the idEve property.
     * 
     */
    public void setIdEve(int value) {
        this.idEve = value;
    }

}
