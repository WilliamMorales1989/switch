
package com.ec.tvcable.switchaprov.service.ems;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for device complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="device">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deviceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deviceName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deviceType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="serialNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="macAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="macAddress1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="macAddress2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Serialnumberold" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MacAddressold" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="networkservice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="forAll" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="activityType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "device", propOrder = {
    "deviceId",
    "deviceName",
    "deviceType",
    "serialNumber",
    "macAddress",
    "macAddress1",
    "macAddress2",
    "status",
    "date",
    "serialnumberold",
    "macAddressold",
    "networkservice",
    "forAll",
    "activityType"
})
public class Device {

    @XmlElement(required = true)
    protected String deviceId;
    @XmlElement(required = true)
    protected String deviceName;
    @XmlElement(required = true)
    protected String deviceType;
    @XmlElement(required = true)
    protected String serialNumber;
    @XmlElement(required = true)
    protected String macAddress;
    @XmlElement(required = true)
    protected String macAddress1;
    @XmlElement(required = true)
    protected String macAddress2;
    @XmlElement(required = true)
    protected String status;
    @XmlElement(name = "Date", required = true)
    protected String date;
    @XmlElement(name = "Serialnumberold", required = true)
    protected String serialnumberold;
    @XmlElement(name = "MacAddressold", required = true)
    protected String macAddressold;
    @XmlElement(required = true)
    protected String networkservice;
    @XmlElement(required = true)
    protected String forAll;
    @XmlElement(required = true)
    protected String activityType;

    /**
     * Gets the value of the deviceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Sets the value of the deviceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceId(String value) {
        this.deviceId = value;
    }

    /**
     * Gets the value of the deviceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * Sets the value of the deviceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceName(String value) {
        this.deviceName = value;
    }

    /**
     * Gets the value of the deviceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * Sets the value of the deviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceType(String value) {
        this.deviceType = value;
    }

    /**
     * Gets the value of the serialNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the value of the serialNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialNumber(String value) {
        this.serialNumber = value;
    }

    /**
     * Gets the value of the macAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMacAddress() {
        return macAddress;
    }

    /**
     * Sets the value of the macAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMacAddress(String value) {
        this.macAddress = value;
    }

    /**
     * Gets the value of the macAddress1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMacAddress1() {
        return macAddress1;
    }

    /**
     * Sets the value of the macAddress1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMacAddress1(String value) {
        this.macAddress1 = value;
    }

    /**
     * Gets the value of the macAddress2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMacAddress2() {
        return macAddress2;
    }

    /**
     * Sets the value of the macAddress2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMacAddress2(String value) {
        this.macAddress2 = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the serialnumberold property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialnumberold() {
        return serialnumberold;
    }

    /**
     * Sets the value of the serialnumberold property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialnumberold(String value) {
        this.serialnumberold = value;
    }

    /**
     * Gets the value of the macAddressold property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMacAddressold() {
        return macAddressold;
    }

    /**
     * Sets the value of the macAddressold property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMacAddressold(String value) {
        this.macAddressold = value;
    }

    /**
     * Gets the value of the networkservice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNetworkservice() {
        return networkservice;
    }

    /**
     * Sets the value of the networkservice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNetworkservice(String value) {
        this.networkservice = value;
    }

    /**
     * Gets the value of the forAll property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForAll() {
        return forAll;
    }

    /**
     * Sets the value of the forAll property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForAll(String value) {
        this.forAll = value;
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

}
