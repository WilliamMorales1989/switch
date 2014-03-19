
package com.ec.tvcable.switchaprov.service.ems;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Optional complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Optional">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Optional1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Optional2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Optional3" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Optional4" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Optional5" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Optional6" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Optional7" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Optional8" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Optional", propOrder = {
    "optional1",
    "optional2",
    "optional3",
    "optional4",
    "optional5",
    "optional6",
    "optional7",
    "optional8"
})
public class Optional {

    @XmlElement(name = "Optional1", required = true)
    protected String optional1;
    @XmlElement(name = "Optional2", required = true)
    protected String optional2;
    @XmlElement(name = "Optional3")
    protected int optional3;
    @XmlElement(name = "Optional4")
    protected int optional4;
    @XmlElement(name = "Optional5")
    protected boolean optional5;
    @XmlElement(name = "Optional6")
    protected boolean optional6;
    @XmlElement(name = "Optional7")
    protected float optional7;
    @XmlElement(name = "Optional8")
    protected float optional8;

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
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptional2() {
        return optional2;
    }

    /**
     * Sets the value of the optional2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptional2(String value) {
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

    /**
     * Gets the value of the optional4 property.
     * 
     */
    public int getOptional4() {
        return optional4;
    }

    /**
     * Sets the value of the optional4 property.
     * 
     */
    public void setOptional4(int value) {
        this.optional4 = value;
    }

    /**
     * Gets the value of the optional5 property.
     * 
     */
    public boolean isOptional5() {
        return optional5;
    }

    /**
     * Sets the value of the optional5 property.
     * 
     */
    public void setOptional5(boolean value) {
        this.optional5 = value;
    }

    /**
     * Gets the value of the optional6 property.
     * 
     */
    public boolean isOptional6() {
        return optional6;
    }

    /**
     * Sets the value of the optional6 property.
     * 
     */
    public void setOptional6(boolean value) {
        this.optional6 = value;
    }

    /**
     * Gets the value of the optional7 property.
     * 
     */
    public float getOptional7() {
        return optional7;
    }

    /**
     * Sets the value of the optional7 property.
     * 
     */
    public void setOptional7(float value) {
        this.optional7 = value;
    }

    /**
     * Gets the value of the optional8 property.
     * 
     */
    public float getOptional8() {
        return optional8;
    }

    /**
     * Sets the value of the optional8 property.
     * 
     */
    public void setOptional8(float value) {
        this.optional8 = value;
    }

}
