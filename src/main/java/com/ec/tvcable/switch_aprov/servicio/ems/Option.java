
package com.ec.tvcable.switch_aprov.servicio.ems;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Option complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Option">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Optional1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Optional2" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Optional3" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Option", propOrder = {
    "optional1",
    "optional2",
    "optional3"
})
public class Option {

    @XmlElement(name = "Optional1", required = true)
    protected String optional1;
    @XmlElement(name = "Optional2")
    protected boolean optional2;
    @XmlElement(name = "Optional3")
    protected int optional3;

    /**
     * Gets the value of the optional1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptional1() {
        return optional1;
    }

    /**
     * Sets the value of the optional1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptional1(String value) {
        this.optional1 = value;
    }

    /**
     * Gets the value of the optional2 property.
     * 
     */
    public boolean isOptional2() {
        return optional2;
    }

    /**
     * Sets the value of the optional2 property.
     * 
     */
    public void setOptional2(boolean value) {
        this.optional2 = value;
    }

    /**
     * Gets the value of the optional3 property.
     * 
     */
    public int getOptional3() {
        return optional3;
    }

    /**
     * Sets the value of the optional3 property.
     * 
     */
    public void setOptional3(int value) {
        this.optional3 = value;
    }

}
