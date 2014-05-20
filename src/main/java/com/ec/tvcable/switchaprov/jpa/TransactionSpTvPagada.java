/**
 * 
 */
package com.ec.tvcable.switchaprov.jpa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.ec.tvcable.switchaprov.exception.ConversionException;

/**
 * @author pablo
 * 
 */
@Entity
@Table(name = "transaction_sp")
@NamedQuery(name = "findByDeviceAndProcessTV", query = "select tvp from TransactionSpTvPagada tvp where tvp.deviceId = :deviceId and tvp.processId = :processId")
public class TransactionSpTvPagada {

	@Id
	private Long id;
	
	@Column(name = "DEVICEID")
	private Long deviceId;

	@Column(name = "PROCESSID")
	private Long processId;

	@Column(name = "IDEMPRESA")
	private Long idEmpresa;

	@Column(name = "NEGOCIO")
	private String negocio;

	@Column(name = "SECUENCIA")
	private Long secuencia;

	@Column(name = "IDACCOUNT")
	private Long idAccount;

	@Column(name = "CITEM")
	private Long cItem;

	@Column(name = "UBICACION")
	private Long ubicacion;

	@Column(name = "ACCION")
	private Long accion;

	@Column(name = "CREDITO")
	private Long credito;

	@Column(name = "IDSERVICIO")
	private Long idServicio;

	@Column(name = "IDPAQUETES")
	private String idPaquetes;

	@Column(name = "IDEVENTOS")
	private String idEventos;

	@Column(name = "TIPOA")
	private Long tipoA;

	@Column(name = "ESTADOC")
	private String estadoC;

	@Column(name = "FORMAPAGO")
	private String formaPago;

	@Column(name = "TIPOC")
	private String tipoC;

	@Column(name = "TIPOPROMOCION")
	private String tipoPromocion;

	@Column(name = "DATOC1")
	private String datoC1;

	@Column(name = "DATOC2")
	private String datoC2;

	@Column(name = "CODIGOCANAL")
	private String codigoCanal;

	@Column(name = "DESCEVENTO")
	private String descEvento;

	@Column(name = "COMIENZOEVENTOFECHAINI")
	private Date comienzoEventoFechaIni;

	@Column(name = "COMIENZOEVENTOTIEMPOINI")
	private Date comienzoEventoTiempoIni;

	@Column(name = "FINALEVENTOFECHAFIN")
	private Date finalEventoFechaFin;

	@Column(name = "FINALEVENTOTIEMPOFIN")
	private Date finalEventoTiempoFin;

	@Column(name = "DURACIONEVENTO")
	private Long duracionEvento;

	@Column(name = "INTERSTITIAL")
	private String interstitial;

	@Column(name = "TIEMPOLIBRE")
	private String tiempoLibre;

	@Column(name = "MPAA")
	private String mpaa;

	@Column(name = "CONTENIDOVIOLENTO")
	private String contenidoViolento;

	@Column(name = "CONTENIDOSEXUAL")
	private String contenidoSexual;

	@Column(name = "LENGUAJE")
	private String lenguaje;

	@Column(name = "RATING")
	private String rating;

	@Column(name = "TIEMPOCOMPRA")
	private String tiempoCompra;

	@Column(name = "PAQUETE")
	private String paquete;

	@Column(name = "TIEMPODISPLAY")
	private String tiempoDisplay;

	@Column(name = "COSTOEVENTO")
	private String costoEvento;

	@Column(name = "PRECIOEVENTO")
	private String precioEvento;

	@Column(name = "ANYTIME")
	private String anyTime;

	@Column(name = "ISVALID")
	private String isValid;

	@Column(name = "DFROM")
	private Date dfrom;

	@Column(name = "DTO")
	private Date dto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNegocio() {
		return negocio;
	}

	public void setNegocio(String negocio) {
		this.negocio = negocio;
	}

	public Long getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Long secuencia) {
		this.secuencia = secuencia;
	}

	public Long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	public Long getcItem() {
		return cItem;
	}

	public void setcItem(Long cItem) {
		this.cItem = cItem;
	}

	public Long getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Long ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Long getAccion() {
		return accion;
	}

	public void setAccion(Long accion) {
		this.accion = accion;
	}

	public Long getCredito() {
		return credito;
	}

	public void setCredito(Long credito) {
		this.credito = credito;
	}

	public Long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}

	public String getIdPaquetes() {
		return idPaquetes;
	}

	public void setIdPaquetes(String idPaquetes) {
		this.idPaquetes = idPaquetes;
	}

	public String getIdEventos() {
		return idEventos;
	}

	public void setIdEventos(String idEventos) {
		this.idEventos = idEventos;
	}

	public Long getTipoA() {
		return tipoA;
	}

	public void setTipoA(Long tipoA) {
		this.tipoA = tipoA;
	}

	public String getEstadoC() {
		return estadoC;
	}

	public void setEstadoC(String estadoC) {
		this.estadoC = estadoC;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getTipoC() {
		return tipoC;
	}

	public void setTipoC(String tipoC) {
		this.tipoC = tipoC;
	}

	public String getTipoPromocion() {
		return tipoPromocion;
	}

	public void setTipoPromocion(String tipoPromocion) {
		this.tipoPromocion = tipoPromocion;
	}

	public String getDatoC1() {
		return datoC1;
	}

	public void setDatoC1(String datoC1) {
		this.datoC1 = datoC1;
	}

	public String getDatoC2() {
		return datoC2;
	}

	public void setDatoC2(String datoC2) {
		this.datoC2 = datoC2;
	}

	public String getCodigoCanal() {
		return codigoCanal;
	}

	public void setCodigoCanal(String codigoCanal) {
		this.codigoCanal = codigoCanal;
	}

	public String getDescEvento() {
		return descEvento;
	}

	public void setDescEvento(String descEvento) {
		this.descEvento = descEvento;
	}

	public Date getComienzoEventoFechaIni() {
		return comienzoEventoFechaIni;
	}

	public void setComienzoEventoFechaIni(Date comienzoEventoFechaIni) {
		this.comienzoEventoFechaIni = comienzoEventoFechaIni;
	}

	public Date getFinalEventoFechaFin() {
		return finalEventoFechaFin;
	}

	public void setFinalEventoFechaFin(Date finalEventoFechaFin) {
		this.finalEventoFechaFin = finalEventoFechaFin;
	}

	public Date getComienzoEventoTiempoIni() {
		return comienzoEventoTiempoIni;
	}

	public void setComienzoEventoTiempoIni(Date comienzoEventoTiempoIni) {
		this.comienzoEventoTiempoIni = comienzoEventoTiempoIni;
	}

	public Long getDuracionEvento() {
		return duracionEvento;
	}

	public void setDuracionEvento(Long duracionEvento) {
		this.duracionEvento = duracionEvento;
	}

	public String getInterstitial() {
		return interstitial;
	}

	public void setInterstitial(String interstitial) {
		this.interstitial = interstitial;
	}

	public String getTiempoLibre() {
		return tiempoLibre;
	}

	public void setTiempoLibre(String tiempoLibre) {
		this.tiempoLibre = tiempoLibre;
	}

	public String getMpaa() {
		return mpaa;
	}

	public void setMpaa(String mpaa) {
		this.mpaa = mpaa;
	}

	public String getContenidoViolento() {
		return contenidoViolento;
	}

	public void setContenidoViolento(String contenidoViolento) {
		this.contenidoViolento = contenidoViolento;
	}

	public String getContenidoSexual() {
		return contenidoSexual;
	}

	public void setContenidoSexual(String contenidoSexual) {
		this.contenidoSexual = contenidoSexual;
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getTiempoCompra() {
		return tiempoCompra;
	}

	public void setTiempoCompra(String tiempoCompra) {
		this.tiempoCompra = tiempoCompra;
	}

	public String getPaquete() {
		return paquete;
	}

	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}

	public String getTiempoDisplay() {
		return tiempoDisplay;
	}

	public void setTiempoDisplay(String tiempoDisplay) {
		this.tiempoDisplay = tiempoDisplay;
	}

	public String getCostoEvento() {
		return costoEvento;
	}

	public void setCostoEvento(String costoEvento) {
		this.costoEvento = costoEvento;
	}

	public String getPrecioEvento() {
		return precioEvento;
	}

	public void setPrecioEvento(String precioEvento) {
		this.precioEvento = precioEvento;
	}

	public String getAnyTime() {
		return anyTime;
	}

	public void setAnyTime(String anyTime) {
		this.anyTime = anyTime;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public Date getDfrom() {
		return dfrom;
	}

	public void setDfrom(Date dfrom) {
		this.dfrom = dfrom;
	}

	public Date getDto() {
		return dto;
	}

	public void setDto(Date dto) {
		this.dto = dto;
	}

	public int getValorEnteroDe(String nombreCampo) throws ConversionException {

		Class<? extends TransactionSpTvPagada> clase = TransactionSpTvPagada.class;
		try {

			Method method = clase.getMethod("get" + nombreCampo);

			Object objeto = method.invoke(this);

			return toInt(objeto, nombreCampo);
		} catch (SecurityException e) {
			throw new ConversionException(generaMensaje(e.getMessage(), nombreCampo), e);
		} catch (IllegalArgumentException e) {
			throw new ConversionException(generaMensaje(e.getMessage(), nombreCampo), e);
		} catch (IllegalAccessException e) {
			throw new ConversionException(generaMensaje(e.getMessage(), nombreCampo), e);
		} catch (NoSuchMethodException e) {
			throw new ConversionException(generaMensaje(e.getMessage(), nombreCampo), e);
		} catch (InvocationTargetException e) {
			throw new ConversionException(generaMensaje(e.getMessage(), nombreCampo), e);
		}

	}

	private Integer toInt(Object objeto, String campo) throws ConversionException {
		Integer result = 0;

		if (objeto != null) {
			try {
				return Integer.parseInt(objeto.toString());
			} catch (NumberFormatException nfe) {
				throw new ConversionException(generaMensaje("Error de conversion de datos", campo), nfe);
			}
		}
		return result;
	}

	private String generaMensaje(String mensajeError, String campo) {
		StringBuilder returnValue = new StringBuilder(80);
		returnValue.append(mensajeError);
		returnValue.append(" para el campo [%s]");
		return String.format(returnValue.toString(), campo);
	}

	public Date getFinalEventoTiempoFin() {
		return finalEventoTiempoFin;
	}

	public void setFinalEventoTiempoFin(Date finalEventoTiempoFin) {
		this.finalEventoTiempoFin = finalEventoTiempoFin;
	}

	public boolean isValid() {
		return "Y".equalsIgnoreCase(getIsValid());
	}

	public Long getProcessId() {
		return processId;
	}

	public void setProcessId(Long processId) {
		this.processId = processId;
	}

}