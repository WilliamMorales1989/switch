
package com.ec.tvcable.switchaprov;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Aprov_conax complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Aprov_conax">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="process_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="citem_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activity_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Aprov_conax", propOrder = {
    "processId",
    "citemId",
    "activityType",
    "serial"
})
public class AprovConax {

    @XmlElement(name = "process_id")
    protected String processId;
    @XmlElement(name = "citem_id")
    protected String citemId;
    @XmlElement(name = "activity_type")
    protected String activityType;
    protected String serial;

    /**
     * Gets the value of the processId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessId() {
        return processId;
    }

    /**
     * Sets the value of the processId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessId(String value) {
        this.processId = value;
    }

    /**
     * Gets the value of the citemId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCitemId() {
        return citemId;
    }

    /**
     * Sets the value of the citemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCitemId(String value) {
        this.citemId = value;
    }

    /**
     * Gets the value of the activityType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityType() {
        return activityType;
    }

    /**
     * Sets the value of the activityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityType(String value) {
        this.activityType = value;
    }

    /**
     * Gets the value of the serial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerial() {
        return serial;
    }

    /**
     * Sets the value of the serial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerial(String value) {
        this.serial = value;
    }

}
