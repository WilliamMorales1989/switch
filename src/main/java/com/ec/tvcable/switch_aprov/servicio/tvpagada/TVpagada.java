
package com.ec.tvcable.switch_aprov.servicio.tvpagada;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TVpagada complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TVpagada">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Serie" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TipoD" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IdConvertidor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IdAccount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CItem" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Ubicacion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Accion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Credito" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IdServicio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IdPaquetes" type="{http://www.grupotvcable.com.ec/WsdlTvPagada/}IdPaquetes"/>
 *         &lt;element name="IdEventos" type="{http://www.grupotvcable.com.ec/WsdlTvPagada/}IdEventos"/>
 *         &lt;element name="TipoA" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="EstadoC" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FormaPago" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TipoC" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CodigoCanal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DescEvento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Comienzo" type="{http://www.grupotvcable.com.ec/WsdlTvPagada/}Comienzo"/>
 *         &lt;element name="Final" type="{http://www.grupotvcable.com.ec/WsdlTvPagada/}Final"/>
 *         &lt;element name="DuracionEvento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Interstitial" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TiempoLibre" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Mpaa" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ContenidoViolento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ContenidoSexual" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Lenguaje" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Rating" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TiempoCompra" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Paquete" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TiempoDisplay" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CostoEvento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PrecioEvento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AnyTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TipoPromocion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DatoC1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DatoC2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TVpagada", propOrder = {
    "serie",
    "tipoD",
    "idConvertidor",
    "idAccount",
    "cItem",
    "ubicacion",
    "accion",
    "credito",
    "idServicio",
    "idPaquetes",
    "idEventos",
    "tipoA",
    "estadoC",
    "formaPago",
    "tipoC",
    "codigoCanal",
    "descEvento",
    "comienzo",
    "_final",
    "duracionEvento",
    "interstitial",
    "tiempoLibre",
    "mpaa",
    "contenidoViolento",
    "contenidoSexual",
    "lenguaje",
    "rating",
    "tiempoCompra",
    "paquete",
    "tiempoDisplay",
    "costoEvento",
    "precioEvento",
    "anyTime",
    "tipoPromocion",
    "datoC1",
    "datoC2"
})
public class TVpagada {

    @XmlElement(name = "Serie", required = true)
    protected String serie;
    @XmlElement(name = "TipoD")
    protected int tipoD;
    @XmlElement(name = "IdConvertidor", required = true)
    protected String idConvertidor;
    @XmlElement(name = "IdAccount")
    protected int idAccount;
    @XmlElement(name = "CItem")
    protected int cItem;
    @XmlElement(name = "Ubicacion")
    protected int ubicacion;
    @XmlElement(name = "Accion")
    protected int accion;
    @XmlElement(name = "Credito")
    protected int credito;
    @XmlElement(name = "IdServicio")
    protected int idServicio;
    @XmlElement(name = "IdPaquetes", required = true)
    protected IdPaquetes idPaquetes;
    @XmlElement(name = "IdEventos", required = true)
    protected IdEventos idEventos;
    @XmlElement(name = "TipoA")
    protected int tipoA;
    @XmlElement(name = "EstadoC", required = true)
    protected String estadoC;
    @XmlElement(name = "FormaPago", required = true)
    protected String formaPago;
    @XmlElement(name = "TipoC")
    protected int tipoC;
    @XmlElement(name = "CodigoCanal")
    protected int codigoCanal;
    @XmlElement(name = "DescEvento", required = true)
    protected String descEvento;
    @XmlElement(name = "Comienzo", required = true)
    protected Comienzo comienzo;
    @XmlElement(name = "Final", required = true)
    protected Final _final;
    @XmlElement(name = "DuracionEvento")
    protected int duracionEvento;
    @XmlElement(name = "Interstitial")
    protected int interstitial;
    @XmlElement(name = "TiempoLibre")
    protected int tiempoLibre;
    @XmlElement(name = "Mpaa")
    protected int mpaa;
    @XmlElement(name = "ContenidoViolento")
    protected int contenidoViolento;
    @XmlElement(name = "ContenidoSexual")
    protected int contenidoSexual;
    @XmlElement(name = "Lenguaje")
    protected int lenguaje;
    @XmlElement(name = "Rating")
    protected int rating;
    @XmlElement(name = "TiempoCompra")
    protected int tiempoCompra;
    @XmlElement(name = "Paquete")
    protected int paquete;
    @XmlElement(name = "TiempoDisplay")
    protected int tiempoDisplay;
    @XmlElement(name = "CostoEvento")
    protected int costoEvento;
    @XmlElement(name = "PrecioEvento")
    protected int precioEvento;
    @XmlElement(name = "AnyTime")
    protected int anyTime;
    @XmlElement(name = "TipoPromocion")
    protected int tipoPromocion;
    @XmlElement(name = "DatoC1", required = true)
    protected String datoC1;
    @XmlElement(name = "DatoC2", required = true)
    protected String datoC2;

    /**
     * Gets the value of the serie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerie() {
        return serie;
    }

    /**
     * Sets the value of the serie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerie(String value) {
        this.serie = value;
    }

    /**
     * Gets the value of the tipoD property.
     * 
     */
    public int getTipoD() {
        return tipoD;
    }

    /**
     * Sets the value of the tipoD property.
     * 
     */
    public void setTipoD(int value) {
        this.tipoD = value;
    }

    /**
     * Gets the value of the idConvertidor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdConvertidor() {
        return idConvertidor;
    }

    /**
     * Sets the value of the idConvertidor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdConvertidor(String value) {
        this.idConvertidor = value;
    }

    /**
     * Gets the value of the idAccount property.
     * 
     */
    public int getIdAccount() {
        return idAccount;
    }

    /**
     * Sets the value of the idAccount property.
     * 
     */
    public void setIdAccount(int value) {
        this.idAccount = value;
    }

    /**
     * Gets the value of the cItem property.
     * 
     */
    public int getCItem() {
        return cItem;
    }

    /**
     * Sets the value of the cItem property.
     * 
     */
    public void setCItem(int value) {
        this.cItem = value;
    }

    /**
     * Gets the value of the ubicacion property.
     * 
     */
    public int getUbicacion() {
        return ubicacion;
    }

    /**
     * Sets the value of the ubicacion property.
     * 
     */
    public void setUbicacion(int value) {
        this.ubicacion = value;
    }

    /**
     * Gets the value of the accion property.
     * 
     */
    public int getAccion() {
        return accion;
    }

    /**
     * Sets the value of the accion property.
     * 
     */
    public void setAccion(int value) {
        this.accion = value;
    }

    /**
     * Gets the value of the credito property.
     * 
     */
    public int getCredito() {
        return credito;
    }

    /**
     * Sets the value of the credito property.
     * 
     */
    public void setCredito(int value) {
        this.credito = value;
    }

    /**
     * Gets the value of the idServicio property.
     * 
     */
    public int getIdServicio() {
        return idServicio;
    }

    /**
     * Sets the value of the idServicio property.
     * 
     */
    public void setIdServicio(int value) {
        this.idServicio = value;
    }

    /**
     * Gets the value of the idPaquetes property.
     * 
     * @return
     *     possible object is
     *     {@link IdPaquetes }
     *     
     */
    public IdPaquetes getIdPaquetes() {
        return idPaquetes;
    }

    /**
     * Sets the value of the idPaquetes property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdPaquetes }
     *     
     */
    public void setIdPaquetes(IdPaquetes value) {
        this.idPaquetes = value;
    }

    /**
     * Gets the value of the idEventos property.
     * 
     * @return
     *     possible object is
     *     {@link IdEventos }
     *     
     */
    public IdEventos getIdEventos() {
        return idEventos;
    }

    /**
     * Sets the value of the idEventos property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdEventos }
     *     
     */
    public void setIdEventos(IdEventos value) {
        this.idEventos = value;
    }

    /**
     * Gets the value of the tipoA property.
     * 
     */
    public int getTipoA() {
        return tipoA;
    }

    /**
     * Sets the value of the tipoA property.
     * 
     */
    public void setTipoA(int value) {
        this.tipoA = value;
    }

    /**
     * Gets the value of the estadoC property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoC() {
        return estadoC;
    }

    /**
     * Sets the value of the estadoC property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoC(String value) {
        this.estadoC = value;
    }

    /**
     * Gets the value of the formaPago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * Sets the value of the formaPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormaPago(String value) {
        this.formaPago = value;
    }

    /**
     * Gets the value of the tipoC property.
     * 
     */
    public int getTipoC() {
        return tipoC;
    }

    /**
     * Sets the value of the tipoC property.
     * 
     */
    public void setTipoC(int value) {
        this.tipoC = value;
    }

    /**
     * Gets the value of the codigoCanal property.
     * 
     */
    public int getCodigoCanal() {
        return codigoCanal;
    }

    /**
     * Sets the value of the codigoCanal property.
     * 
     */
    public void setCodigoCanal(int value) {
        this.codigoCanal = value;
    }

    /**
     * Gets the value of the descEvento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescEvento() {
        return descEvento;
    }

    /**
     * Sets the value of the descEvento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescEvento(String value) {
        this.descEvento = value;
    }

    /**
     * Gets the value of the comienzo property.
     * 
     * @return
     *     possible object is
     *     {@link Comienzo }
     *     
     */
    public Comienzo getComienzo() {
        return comienzo;
    }

    /**
     * Sets the value of the comienzo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Comienzo }
     *     
     */
    public void setComienzo(Comienzo value) {
        this.comienzo = value;
    }

    /**
     * Gets the value of the final property.
     * 
     * @return
     *     possible object is
     *     {@link Final }
     *     
     */
    public Final getFinal() {
        return _final;
    }

    /**
     * Sets the value of the final property.
     * 
     * @param value
     *     allowed object is
     *     {@link Final }
     *     
     */
    public void setFinal(Final value) {
        this._final = value;
    }

    /**
     * Gets the value of the duracionEvento property.
     * 
     */
    public int getDuracionEvento() {
        return duracionEvento;
    }

    /**
     * Sets the value of the duracionEvento property.
     * 
     */
    public void setDuracionEvento(int value) {
        this.duracionEvento = value;
    }

    /**
     * Gets the value of the interstitial property.
     * 
     */
    public int getInterstitial() {
        return interstitial;
    }

    /**
     * Sets the value of the interstitial property.
     * 
     */
    public void setInterstitial(int value) {
        this.interstitial = value;
    }

    /**
     * Gets the value of the tiempoLibre property.
     * 
     */
    public int getTiempoLibre() {
        return tiempoLibre;
    }

    /**
     * Sets the value of the tiempoLibre property.
     * 
     */
    public void setTiempoLibre(int value) {
        this.tiempoLibre = value;
    }

    /**
     * Gets the value of the mpaa property.
     * 
     */
    public int getMpaa() {
        return mpaa;
    }

    /**
     * Sets the value of the mpaa property.
     * 
     */
    public void setMpaa(int value) {
        this.mpaa = value;
    }

    /**
     * Gets the value of the contenidoViolento property.
     * 
     */
    public int getContenidoViolento() {
        return contenidoViolento;
    }

    /**
     * Sets the value of the contenidoViolento property.
     * 
     */
    public void setContenidoViolento(int value) {
        this.contenidoViolento = value;
    }

    /**
     * Gets the value of the contenidoSexual property.
     * 
     */
    public int getContenidoSexual() {
        return contenidoSexual;
    }

    /**
     * Sets the value of the contenidoSexual property.
     * 
     */
    public void setContenidoSexual(int value) {
        this.contenidoSexual = value;
    }

    /**
     * Gets the value of the lenguaje property.
     * 
     */
    public int getLenguaje() {
        return lenguaje;
    }

    /**
     * Sets the value of the lenguaje property.
     * 
     */
    public void setLenguaje(int value) {
        this.lenguaje = value;
    }

    /**
     * Gets the value of the rating property.
     * 
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     */
    public void setRating(int value) {
        this.rating = value;
    }

    /**
     * Gets the value of the tiempoCompra property.
     * 
     */
    public int getTiempoCompra() {
        return tiempoCompra;
    }

    /**
     * Sets the value of the tiempoCompra property.
     * 
     */
    public void setTiempoCompra(int value) {
        this.tiempoCompra = value;
    }

    /**
     * Gets the value of the paquete property.
     * 
     */
    public int getPaquete() {
        return paquete;
    }

    /**
     * Sets the value of the paquete property.
     * 
     */
    public void setPaquete(int value) {
        this.paquete = value;
    }

    /**
     * Gets the value of the tiempoDisplay property.
     * 
     */
    public int getTiempoDisplay() {
        return tiempoDisplay;
    }

    /**
     * Sets the value of the tiempoDisplay property.
     * 
     */
    public void setTiempoDisplay(int value) {
        this.tiempoDisplay = value;
    }

    /**
     * Gets the value of the costoEvento property.
     * 
     */
    public int getCostoEvento() {
        return costoEvento;
    }

    /**
     * Sets the value of the costoEvento property.
     * 
     */
    public void setCostoEvento(int value) {
        this.costoEvento = value;
    }

    /**
     * Gets the value of the precioEvento property.
     * 
     */
    public int getPrecioEvento() {
        return precioEvento;
    }

    /**
     * Sets the value of the precioEvento property.
     * 
     */
    public void setPrecioEvento(int value) {
        this.precioEvento = value;
    }

    /**
     * Gets the value of the anyTime property.
     * 
     */
    public int getAnyTime() {
        return anyTime;
    }

    /**
     * Sets the value of the anyTime property.
     * 
     */
    public void setAnyTime(int value) {
        this.anyTime = value;
    }

    /**
     * Gets the value of the tipoPromocion property.
     * 
     */
    public int getTipoPromocion() {
        return tipoPromocion;
    }

    /**
     * Sets the value of the tipoPromocion property.
     * 
     */
    public void setTipoPromocion(int value) {
        this.tipoPromocion = value;
    }

    /**
     * Gets the value of the datoC1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatoC1() {
        return datoC1;
    }

    /**
     * Sets the value of the datoC1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatoC1(String value) {
        this.datoC1 = value;
    }

    /**
     * Gets the value of the datoC2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatoC2() {
        return datoC2;
    }

    /**
     * Sets the value of the datoC2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatoC2(String value) {
        this.datoC2 = value;
    }

}
