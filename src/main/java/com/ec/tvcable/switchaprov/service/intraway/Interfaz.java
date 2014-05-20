
package com.ec.tvcable.switchaprov.service.intraway;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Interfaz complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Interfaz">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Username" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IdTipoCliente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EmailNoticias" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idCicloFactCRM" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ServicTypeCRMId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MessageCRMID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Cantidad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Quotamax" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ServidorEmailCRMId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Dominio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DiskQuota" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Noticias" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ServicePackageCRMId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Hub" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Nodo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IdISPCRM" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ActivactionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IspMtaCrmId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="BuscarTagCRM" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Docsis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EnableAccounting" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProductName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BandPackageCRMId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PrepaidPolicyCRMId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CantCPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="USChannelID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="StartingBalance" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DSFreq" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PeriodicalBaseBalance" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NoBoot" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="MACAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SnmpGroupCRMID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="HostName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CmsCMDID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Provisioning" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ProfileCRMId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SendtoController" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LinesQTy" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MtaModelCRMId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EndpointNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Tn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="HomeExchangeCRMId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FeatureCrmId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DatoI1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DatoI2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Customer1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Customer2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Customer3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Customer4" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DeviceId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Interface" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Action" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IdEmpresa" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Negocio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Secuencia" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Interfaz", propOrder = {
    "nombre",
    "username",
    "password",
    "idTipoCliente",
    "emailNoticias",
    "idCicloFactCRM",
    "servicTypeCRMId",
    "messageCRMID",
    "cantidad",
    "quotamax",
    "servidorEmailCRMId",
    "dominio",
    "diskQuota",
    "noticias",
    "name",
    "servicePackageCRMId",
    "hub",
    "nodo",
    "idISPCRM",
    "activactionCode",
    "ispMtaCrmId",
    "buscarTagCRM",
    "docsis",
    "enableAccounting",
    "productName",
    "bandPackageCRMId",
    "prepaidPolicyCRMId",
    "cantCPE",
    "usChannelID",
    "startingBalance",
    "dsFreq",
    "periodicalBaseBalance",
    "noBoot",
    "macAddress",
    "snmpGroupCRMID",
    "hostName",
    "cmsCMDID",
    "provisioning",
    "profileCRMId",
    "sendtoController",
    "linesQTy",
    "mtaModelCRMId",
    "endpointNumber",
    "tn",
    "homeExchangeCRMId",
    "featureCrmId",
    "active",
    "datoI1",
    "datoI2",
    "customer1",
    "customer2",
    "customer3",
    "customer4",
    "deviceid",
    "interfaces",
    "action",
    "id",
    "idEmpresa",
    "negocio",
    "secuencia"
})
public class Interfaz {

    @XmlElement(name = "Nombre", required = true)
    protected String nombre;
    @XmlElement(name = "Username", required = true)
    protected String username;
    @XmlElement(name = "Password", required = true)
    protected String password;
    @XmlElement(name = "IdTipoCliente", required = true)
    protected String idTipoCliente;
    @XmlElement(name = "EmailNoticias", required = true)
    protected String emailNoticias;
    @XmlElement(required = true)
    protected String idCicloFactCRM;
    @XmlElement(name = "ServicTypeCRMId")
    protected Long servicTypeCRMId;
    @XmlElement(name = "MessageCRMID", required = true)
    protected String messageCRMID;
    @XmlElement(name = "Cantidad")
    protected Long cantidad;
    @XmlElement(name = "Quotamax")
    protected Long quotamax;
    @XmlElement(name = "ServidorEmailCRMId", required = true)
    protected String servidorEmailCRMId;
    @XmlElement(name = "Dominio", required = true)
    protected String dominio;
    @XmlElement(name = "DiskQuota")
    protected Long diskQuota;
    @XmlElement(name = "Noticias")
    protected Long noticias;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "ServicePackageCRMId", required = true)
    protected String servicePackageCRMId;
    @XmlElement(name = "Hub", required = true)
    protected String hub;
    @XmlElement(name = "Nodo", required = true)
    protected String nodo;
    @XmlElement(name = "IdISPCRM", required = true)
    protected String idISPCRM;
    @XmlElement(name = "ActivactionCode", required = true)
    protected String activactionCode;
    @XmlElement(name = "IspMtaCrmId")
    protected String ispMtaCrmId;
    @XmlElement(name = "BuscarTagCRM")
    protected Long buscarTagCRM;
    @XmlElement(name = "Docsis", required = true)
    protected String docsis;
    @XmlElement(name = "EnableAccounting", required = true)
    protected String enableAccounting;
    @XmlElement(name = "ProductName", required = true)
    protected String productName;
    @XmlElement(name = "BandPackageCRMId", required = true)
    protected String bandPackageCRMId;
    @XmlElement(name = "PrepaidPolicyCRMId", required = true)
    protected String prepaidPolicyCRMId;
    @XmlElement(name = "CantCPE")
    protected Long cantCPE;
    @XmlElement(name = "USChannelID")
    protected Long usChannelID;
    @XmlElement(name = "StartingBalance")
    protected Long startingBalance;
    @XmlElement(name = "DSFreq")
    protected Long dsFreq;
    @XmlElement(name = "PeriodicalBaseBalance")
    protected Long periodicalBaseBalance;
    @XmlElement(name = "NoBoot")
    protected boolean noBoot;
    @XmlElement(name = "MACAddress", required = true)
    protected String macAddress;
    @XmlElement(name = "SnmpGroupCRMID", required = true)
    protected String snmpGroupCRMID;
    @XmlElement(name = "HostName", required = true)
    protected String hostName;
    @XmlElement(name = "CmsCMDID", required = true)
    protected String cmsCMDID;
    @XmlElement(name = "Provisioning")
    protected Long provisioning;
    @XmlElement(name = "ProfileCRMId", required = true)
    protected String profileCRMId;
    @XmlElement(name = "SendtoController", required = true)
    protected String sendtoController;
    @XmlElement(name = "LinesQTy")
    protected Long linesQTy;
    @XmlElement(name = "MtaModelCRMId", required = true)
    protected String mtaModelCRMId;
    @XmlElement(name = "EndpointNumber")
    protected Long endpointNumber;
    @XmlElement(name = "Tn", required = true)
    protected String tn;
    @XmlElement(name = "HomeExchangeCRMId", required = true)
    protected String homeExchangeCRMId;
    @XmlElement(name = "FeatureCrmId", required = true)
    protected String featureCrmId;
    @XmlElement(name = "Active")
    protected Long active;
    @XmlElement(name = "DatoI1", required = true)
    protected String datoI1;
    @XmlElement(name = "DatoI2", required = true)
    protected String datoI2;
    @XmlElement(name = "Customer1", required = true)
    protected String customer1;
    @XmlElement(name = "Customer2", required = true)
    protected String customer2;
    @XmlElement(name = "Customer3", required = true)
    protected String customer3;
    @XmlElement(name = "Customer4", required = true)
    protected String customer4;
    @XmlElement(name = "DeviceId", required = true)
    protected int deviceid;
    @XmlElement(name = "Interface", required = true)
    protected Long interfaces;
    @XmlElement(name = "Action")
    protected Long action;
    @XmlElement(name = "Id", required = true)
    protected Long id;
    @XmlElement(name = "IdEmpresa", required = true)
    protected Long idEmpresa;
    @XmlElement(name = "Negocio", required = true)
    protected String negocio;
    @XmlElement(name = "Secuencia", required = true)
    protected Long secuencia;

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the idTipoCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdTipoCliente() {
        return idTipoCliente;
    }

    /**
     * Sets the value of the idTipoCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdTipoCliente(String value) {
        this.idTipoCliente = value;
    }

    /**
     * Gets the value of the emailNoticias property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailNoticias() {
        return emailNoticias;
    }

    /**
     * Sets the value of the emailNoticias property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailNoticias(String value) {
        this.emailNoticias = value;
    }

    /**
     * Gets the value of the idCicloFactCRM property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCicloFactCRM() {
        return idCicloFactCRM;
    }

    /**
     * Sets the value of the idCicloFactCRM property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCicloFactCRM(String value) {
        this.idCicloFactCRM = value;
    }

    /**
     * Gets the value of the servicTypeCRMId property.
     * 
     */
    public Long getServicTypeCRMId() {
        return servicTypeCRMId;
    }

    /**
     * Sets the value of the servicTypeCRMId property.
     * 
     */
    public void setServicTypeCRMId(Long value) {
        this.servicTypeCRMId = value;
    }

    /**
     * Gets the value of the messageCRMID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageCRMID() {
        return messageCRMID;
    }

    /**
     * Sets the value of the messageCRMID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageCRMID(String value) {
        this.messageCRMID = value;
    }

    /**
     * Gets the value of the cantidad property.
     * 
     */
    public Long getCantidad() {
        return cantidad;
    }

    /**
     * Sets the value of the cantidad property.
     * 
     */
    public void setCantidad(Long value) {
        this.cantidad = value;
    }

    /**
     * Gets the value of the quotamax property.
     * 
     */
    public Long getQuotamax() {
        return quotamax;
    }

    /**
     * Sets the value of the quotamax property.
     * 
     */
    public void setQuotamax(Long value) {
        this.quotamax = value;
    }

    /**
     * Gets the value of the servidorEmailCRMId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServidorEmailCRMId() {
        return servidorEmailCRMId;
    }

    /**
     * Sets the value of the servidorEmailCRMId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServidorEmailCRMId(String value) {
        this.servidorEmailCRMId = value;
    }

    /**
     * Gets the value of the dominio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDominio() {
        return dominio;
    }

    /**
     * Sets the value of the dominio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDominio(String value) {
        this.dominio = value;
    }

    /**
     * Gets the value of the diskQuota property.
     * 
     */
    public Long getDiskQuota() {
        return diskQuota;
    }

    /**
     * Sets the value of the diskQuota property.
     * 
     */
    public void setDiskQuota(Long value) {
        this.diskQuota = value;
    }

    /**
     * Gets the value of the noticias property.
     * 
     */
    public Long getNoticias() {
        return noticias;
    }

    /**
     * Sets the value of the noticias property.
     * 
     */
    public void setNoticias(Long value) {
        this.noticias = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the servicePackageCRMId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServicePackageCRMId() {
        return servicePackageCRMId;
    }

    /**
     * Sets the value of the servicePackageCRMId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServicePackageCRMId(String value) {
        this.servicePackageCRMId = value;
    }

    /**
     * Gets the value of the hub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHub() {
        return hub;
    }

    /**
     * Sets the value of the hub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHub(String value) {
        this.hub = value;
    }

    /**
     * Gets the value of the nodo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNodo() {
        return nodo;
    }

    /**
     * Sets the value of the nodo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNodo(String value) {
        this.nodo = value;
    }

    /**
     * Gets the value of the idISPCRM property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdISPCRM() {
        return idISPCRM;
    }

    /**
     * Sets the value of the idISPCRM property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdISPCRM(String value) {
        this.idISPCRM = value;
    }

    /**
     * Gets the value of the activactionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivactionCode() {
        return activactionCode;
    }

    /**
     * Sets the value of the activactionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivactionCode(String value) {
        this.activactionCode = value;
    }

    /**
     * Gets the value of the ispMtaCrmId property.
     * 
     */
    public String getIspMtaCrmId() {
        return ispMtaCrmId;
    }

    /**
     * Sets the value of the ispMtaCrmId property.
     * 
     */
    public void setIspMtaCrmId(String value) {
        this.ispMtaCrmId = value;
    }

    /**
     * Gets the value of the buscarTagCRM property.
     * 
     */
    public Long getBuscarTagCRM() {
        return buscarTagCRM;
    }

    /**
     * Sets the value of the buscarTagCRM property.
     * 
     */
    public void setBuscarTagCRM(Long value) {
        this.buscarTagCRM = value;
    }

    /**
     * Gets the value of the docsis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocsis() {
        return docsis;
    }

    /**
     * Sets the value of the docsis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocsis(String value) {
        this.docsis = value;
    }

    /**
     * Gets the value of the enableAccounting property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnableAccounting() {
        return enableAccounting;
    }

    /**
     * Sets the value of the enableAccounting property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnableAccounting(String value) {
        this.enableAccounting = value;
    }

    /**
     * Gets the value of the productName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * Gets the value of the bandPackageCRMId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBandPackageCRMId() {
        return bandPackageCRMId;
    }

    /**
     * Sets the value of the bandPackageCRMId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBandPackageCRMId(String value) {
        this.bandPackageCRMId = value;
    }

    /**
     * Gets the value of the prepaidPolicyCRMId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrepaidPolicyCRMId() {
        return prepaidPolicyCRMId;
    }

    /**
     * Sets the value of the prepaidPolicyCRMId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrepaidPolicyCRMId(String value) {
        this.prepaidPolicyCRMId = value;
    }

    /**
     * Gets the value of the cantCPE property.
     * 
     */
    public Long getCantCPE() {
        return cantCPE;
    }

    /**
     * Sets the value of the cantCPE property.
     * 
     */
    public void setCantCPE(Long value) {
        this.cantCPE = value;
    }

    /**
     * Gets the value of the usChannelID property.
     * 
     */
    public Long getUSChannelID() {
        return usChannelID;
    }

    /**
     * Sets the value of the usChannelID property.
     * 
     */
    public void setUSChannelID(Long value) {
        this.usChannelID = value;
    }

    /**
     * Gets the value of the startingBalance property.
     * 
     */
    public Long getStartingBalance() {
        return startingBalance;
    }

    /**
     * Sets the value of the startingBalance property.
     * 
     */
    public void setStartingBalance(Long value) {
        this.startingBalance = value;
    }

    /**
     * Gets the value of the dsFreq property.
     * 
     */
    public Long getDSFreq() {
        return dsFreq;
    }

    /**
     * Sets the value of the dsFreq property.
     * 
     */
    public void setDSFreq(Long value) {
        this.dsFreq = value;
    }

    /**
     * Gets the value of the periodicalBaseBalance property.
     * 
     */
    public Long getPeriodicalBaseBalance() {
        return periodicalBaseBalance;
    }

    /**
     * Sets the value of the periodicalBaseBalance property.
     * 
     */
    public void setPeriodicalBaseBalance(Long value) {
        this.periodicalBaseBalance = value;
    }

    /**
     * Gets the value of the noBoot property.
     * 
     */
    public boolean isNoBoot() {
        return noBoot;
    }

    /**
     * Sets the value of the noBoot property.
     * 
     */
    public void setNoBoot(boolean value) {
        this.noBoot = value;
    }

    /**
     * Gets the value of the macAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMACAddress() {
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
    public void setMACAddress(String value) {
        this.macAddress = value;
    }

    /**
     * Gets the value of the snmpGroupCRMID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSnmpGroupCRMID() {
        return snmpGroupCRMID;
    }

    /**
     * Sets the value of the snmpGroupCRMID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSnmpGroupCRMID(String value) {
        this.snmpGroupCRMID = value;
    }

    /**
     * Gets the value of the hostName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * Sets the value of the hostName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHostName(String value) {
        this.hostName = value;
    }

    /**
     * Gets the value of the cmsCMDID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCmsCMDID() {
        return cmsCMDID;
    }

    /**
     * Sets the value of the cmsCMDID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCmsCMDID(String value) {
        this.cmsCMDID = value;
    }

    /**
     * Gets the value of the provisioning property.
     * 
     */
    public Long getProvisioning() {
        return provisioning;
    }

    /**
     * Sets the value of the provisioning property.
     * 
     */
    public void setProvisioning(Long value) {
        this.provisioning = value;
    }

    /**
     * Gets the value of the profileCRMId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfileCRMId() {
        return profileCRMId;
    }

    /**
     * Sets the value of the profileCRMId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfileCRMId(String value) {
        this.profileCRMId = value;
    }

    /**
     * Gets the value of the sendtoController property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendtoController() {
        return sendtoController;
    }

    /**
     * Sets the value of the sendtoController property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendtoController(String value) {
        this.sendtoController = value;
    }

    /**
     * Gets the value of the linesQTy property.
     * 
     */
    public Long getLinesQTy() {
        return linesQTy;
    }

    /**
     * Sets the value of the linesQTy property.
     * 
     */
    public void setLinesQTy(Long value) {
        this.linesQTy = value;
    }

    /**
     * Gets the value of the mtaModelCRMId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMtaModelCRMId() {
        return mtaModelCRMId;
    }

    /**
     * Sets the value of the mtaModelCRMId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMtaModelCRMId(String value) {
        this.mtaModelCRMId = value;
    }

    /**
     * Gets the value of the endpointNumber property.
     * 
     */
    public Long getEndpointNumber() {
        return endpointNumber;
    }

    /**
     * Sets the value of the endpointNumber property.
     * 
     */
    public void setEndpointNumber(Long value) {
        this.endpointNumber = value;
    }

    /**
     * Gets the value of the tn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTn() {
        return tn;
    }

    /**
     * Sets the value of the tn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTn(String value) {
        this.tn = value;
    }

    /**
     * Gets the value of the homeExchangeCRMId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeExchangeCRMId() {
        return homeExchangeCRMId;
    }

    /**
     * Sets the value of the homeExchangeCRMId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeExchangeCRMId(String value) {
        this.homeExchangeCRMId = value;
    }

    /**
     * Gets the value of the featureCrmId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeatureCrmId() {
        return featureCrmId;
    }

    /**
     * Sets the value of the featureCrmId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeatureCrmId(String value) {
        this.featureCrmId = value;
    }

    /**
     * Gets the value of the active property.
     * 
     */
    public Long getActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     */
    public void setActive(Long value) {
        this.active = value;
    }

    /**
     * Gets the value of the datoI1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatoI1() {
        return datoI1;
    }

    /**
     * Sets the value of the datoI1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatoI1(String value) {
        this.datoI1 = value;
    }

    /**
     * Gets the value of the datoI2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatoI2() {
        return datoI2;
    }

    /**
     * Sets the value of the datoI2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatoI2(String value) {
        this.datoI2 = value;
    }

    /**
     * Gets the value of the customer1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomer1() {
        return customer1;
    }

    /**
     * Sets the value of the customer1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomer1(String value) {
        this.customer1 = value;
    }

    /**
     * Gets the value of the customer2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomer2() {
        return customer2;
    }

    /**
     * Sets the value of the customer2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomer2(String value) {
        this.customer2 = value;
    }

    /**
     * Gets the value of the customer3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomer3() {
        return customer3;
    }

    /**
     * Sets the value of the customer3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomer3(String value) {
        this.customer3 = value;
    }

    /**
     * Gets the value of the customer4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomer4() {
        return customer4;
    }

    /**
     * Sets the value of the customer4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomer4(String value) {
        this.customer4 = value;
    }
    /**
     * Gets the value of the deviceid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public int getDeviceId() {
        return deviceid;
    }

    /**
     * Sets the value of the deviceid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceId(int value) {
        this.deviceid = value;
    }
    /**
     * Gets the value of the interfaces property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getInterface() {
        return interfaces;
    }

    /**
     * Sets the value of the interface property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterface(Long value) {
        this.interfaces = value;
    }
    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAction(Long value) {
        this.action = value;
    }
    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }
    /**
     * Gets the value of the idEmpresa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * Sets the value of the idEmpresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdEmpresa(Long value) {
        this.idEmpresa = value;
    }
    /**
     * Gets the value of the negocio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNegocio() {
        return negocio;
    }

    /**
     * Sets the value of the negocio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNegocio(String value) {
        this.negocio = value;
    }
    /**
     * Gets the value of the secuencia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getSecuencia() {
        return secuencia;
    }

    /**
     * Sets the value of the secuencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecuencia(Long value) {
        this.secuencia = value;
    }

}
