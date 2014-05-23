/**
 * 
 */
package com.ec.tvcable.switchaprov.jpa;

import java.io.Serializable;
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
 * @author Mauricio
 * 
 */
@Entity
@Table(name="TRANSACTION_SP_INTRAWAY")
@NamedQuery(name = "findByDeviceAndProcessIntraway", query = "select iway from TransactionSpIntraway iway where iway.deviceId = :deviceId and iway.processId = :processId")
public class TransactionSpIntraway implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	private Long id;
	
	@Column(name = "PROCESSID")
	private Long processId;
	
	@Column(name = "AUTHKEY")
	private String authKey;
	
	@Column(name = "CLIENTECRM")
	private Long clienteCrm;
	
	@Column(name = "IDPRODUCTO")
	private Long idProducto;
	
	@Column(name = "IDPRODUCTOPADRE")
	private Long idProductoPadre;
	
	@Column(name = "IDSERVICIOPADRE")
	private Long idServicioPadre;
	
	@Column(name = "IDVENTA")
	private Long idVenta;
	
	@Column(name = "IDVENTAPADRE")
	private Long idventaPadre;
	
	@Column(name = "IDPROMOTOR")
	private String idPromotor;
	
	@Column(name = "FECHADIFERIDA")
	private Date fechaDiferida;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "USERNAME")
	private String userName;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "IDTIPOCLIENTE")
	private String idTipoCliente;
	
	@Column(name = "EMAILNOTICIAS")
	private String emailNoticias;
	
	@Column(name = "IDCLICLOFACTCRM")
	private String idClicloFactCRM;
	
	@Column(name = "SERVICTYPECRMID")
	private Long servicTypeCRMId;
	
	@Column(name = "MESSAGECRMID")
	private String messageCRMId;
	
	@Column(name = "CANTIDAD")
	private Long cantidad;
	
	@Column(name = "QUOTAMAX")
	private Long quotaMax;
	
	@Column(name = "SERVIDOREMAILCRMDID")
	private String servidorEmailCRMId;
	
	@Column(name = "DOMINO")
	private String domino;
	
	@Column(name = "DISKQUOTA")
	private Long diskQuota;
	
	@Column(name = "NOTICIAS")
	private Long noticias;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "SERVICEPACKAGECRMID")
	private String servicePackAgeCRMId;
	
	@Column(name = "HUB")
	private String hub;
	
	@Column(name = "NODO")
	private String nodo;
	
	@Column(name = "IDISPCRM")
	private String idIspCRM;
	
	@Column(name = "ACTIVACTIONCODE")
	private String activActionCode;
	
	@Column(name = "ISPMTACRMIDNUMBER")
	private Long isptaCRMIdNumber;
	
	@Column(name = "BUSCARTAGCM")
	private Long buscarTagCM;
	
	@Column(name = "DOCSIS")
	private String docSIS;
	
	@Column(name = "PRODUCTNAME")
	private String productName;
	
	@Column(name = "BANDPACKAGECRMID")
	private String bandPackAgeCRMId;
	
	@Column(name = "PREPAIDPOLICYCRMID")
	private String prepaIdPoliCyCRMId;
	
	@Column(name = "CANTCPE")
	private Long cantcPe;
	
	@Column(name = "USCHANNELID")
	private Long usChannelId;
	
	@Column(name = "STARTINGBALANCE")
	private Long startingBalance;
	
	@Column(name = "DSFREQ")
	private Long dsFreq;
	
	@Column(name = "PERIODICALBASEBALANCE")
	private Long periodicalBaseBalance;
	
	@Column(name = "NOBOOT")
	private String noBoot;
	
	@Column(name = "MACADDRES")
	private String macAddres;
	
	@Column(name = "HOSTNAME")
	private String hostName;
	
	@Column(name = "SNMPGROUPCRMID")
	private String snmpGroupCRMId;
	
	@Column(name = "CMSCRMID")
	private String cmsCRMId;
	
	@Column(name = "PROVISIONING")
	private Long provisioning;
	
	@Column(name = "PROFILECRMID")
	private String profileCRMId;
	
	@Column(name = "ISPMTACRMIDTEXT")
	private String ispmtaCRMIdText;
	
	@Column(name = "SENTOCONTROLLER")
	private String sentoController;
	
	@Column(name = "LINESQTY")
	private Long lineSqty;
	
	@Column(name = "MTAMODELCRMID")
	private String mtaModelCRMId;
	
	@Column(name = "ENDPOINTNUMBER")
	private Long endPointNumber;
	
	@Column(name = "TN")
	private String tn;
	
	@Column(name = "HOMEEXCHANGECRMID")
	private String homeExchangeCRMId;
	
	@Column(name = "FEATURECRMID")
	private String featureCRMId;
	
	@Column(name = "ACTIVE")
	private Long active;
	
	@Column(name = "DATOI1")
	private String datoi1;
	
	@Column(name = "DATOI2")
	private String datoi2;
	
	@Column(name = "CUSTOMER1")
	private String customer1;
	
	@Column(name = "CUSTOMER2")
	private String customer2;
	
	@Column(name = "CUSTOMER3")
	private String customer3;
	
	@Column(name = "CUSTOMER4")
	private String customer4;
	
	@Column(name = "DEVICEID")
	private int deviceId;
	
	@Column(name = "INTERFACE")
	private int idInterface;
	
	@Column(name = "ACTION")
	private Long action;
	
	@Column(name = "IDEMPRESA")
	private Long idEmpresa;
	
	@Column(name = "NEGOCIO")
	private String negocio;
	
	@Column(name = "SECUENCIA")
	private Long secuencia;
	
	@Column(name = "IDESTADO")
	private int idEstado;
	
	@Column(name = "ENABLEACCOUNTING")
	private String enableAccounting;
	
	@Column(name = "IDSERVICIO")
	private Long idServicio;

	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public Long getProcessId(){
		return processId;
	}
	
	public void setProcessId(Long processId){
		this.processId = processId;
	}
	
	public String getAuthKey(){
		return authKey;
	}
	
	public void setAuthKey(String authKey){
		this.authKey = authKey;
	}
	
	public Long getClienteCrm(){
		return clienteCrm;
	}
	
	public void setClienteCrm(Long clienteCrm){
		this.clienteCrm = clienteCrm;
	}
	
	public Long getIdProducto(){
		return idProducto;
	}
	
	public void setIdProducto(Long idProducto){
		this.idProducto = idProducto;
	}
	
	public Long getIdProductoPadre(){
		return idProductoPadre;
	}
	
	public void setIdProductoPadre(Long idProductoPadre){
		this.idProductoPadre = idProductoPadre;
	}
	
	public Long getidServicio(){
		return idServicio;
	}
	
	public void setidServicio(Long idServicio){
		this.idServicio = idServicio;
	}
	
	public Long getidServicioPadre(){
		return idServicioPadre;
	}
	
	public void setidServicioPadre(Long idServicioPadre){
		this.idServicioPadre = idServicioPadre;
	}
	
	public Long getidVenta(){
		return idVenta;
	}
	
	public void setidVenta(Long idVenta){
		this.idVenta = idVenta;
	}
	
	public Long getidventaPadre(){
		return idventaPadre;
	}
	
	public void setidventaPadre(Long idventaPadre){
		this.idventaPadre = idventaPadre;
	}
	
	public String getidPromotor(){
		return idPromotor;
	}
	
	public void setidPromotor(String idPromotor){
		this.idPromotor = idPromotor;
	}
	
	public Date getfechaDiferida(){
		return fechaDiferida;
	}
	
	public int getIdEstado(){
		return idEstado;
	}
	
	public void setIdEstado(int idEstado){
		this.idEstado = idEstado;
	}
	
	public void setfechaDiferida(Date fechaDiferida){
		this.fechaDiferida = fechaDiferida;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getuserName(){
		return userName;
	}
	
	public void setuserName(String userName){
		this.userName = userName;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getidTipoCliente(){
		return idTipoCliente;
	}
	
	public void setidTipoCliente(String idTipoCliente){
		this.idTipoCliente = idTipoCliente;
	}
	
	public String getemailNoticias(){
		return emailNoticias;
	}
	
	public void setemailNoticias(String emailNoticias){
		this.emailNoticias = emailNoticias;
	}
	
	public String getidClicloFactCRM(){
		return idClicloFactCRM;
	}
	
	public void setidClicloFactCRM(String idClicloFactCRM){
		this.idClicloFactCRM = idClicloFactCRM;
	}
	
	public Long getservicTypeCRMId(){
		return servicTypeCRMId;
	}
	
	public void setservicTypeCRMId(Long servicTypeCRMId){
		this.servicTypeCRMId = servicTypeCRMId;
	}
	
	public String getmessageCRMId(){
		return messageCRMId;
	}
	
	public void setmessageCRMId(String messageCRMId){
		this.messageCRMId = messageCRMId;
	}
	
	public Long getCantidad(){
		return cantidad;
	}
	
	public void setCantidad(Long cantidad){
		this.cantidad = cantidad;
	}
	
	public Long getquotaMax(){
		return quotaMax;
	}
	
	public void setquotaMax(Long quotaMax){
		this.quotaMax = quotaMax;
	}
	
	public String getservidorEmailCRMId(){
		return servidorEmailCRMId;
	}
	
	public void setservidorEmailCRMId(String servidorEmailCRMId){
		this.servidorEmailCRMId = servidorEmailCRMId;
	}
	
	public String getDomino(){
		return domino;
	}
	
	public void setDomino(String domino){
		this.domino = domino;
	}
	
	public Long getdiskQuota(){
		return diskQuota;
	}
	
	public void setdiskQuota(Long diskQuota){
		this.diskQuota = diskQuota;
	}
	
	public Long getNoticias(){
		return noticias;
	}
	
	public void setNoticias(Long noticias){
		this.noticias = noticias;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getservicePackAgeCRMId(){
		return servicePackAgeCRMId;
	}
	
	public void setservicePackAgeCRMId(String servicePackAgeCRMId){
		this.servicePackAgeCRMId = servicePackAgeCRMId;
	}
	
	public String getHub(){
		return hub;
	}
	
	public void setHub(String hub){
		this.hub = hub;
	}
	
	public String getNodo(){
		return nodo;
	}
	
	public void setNodo(String nodo){
		this.nodo = nodo;
	}
	
	public String getidIspCRM(){
		return idIspCRM;
	}
	
	public void setidIspCRM(String idIspCRM){
		this.idIspCRM = idIspCRM;
	}
	
	public String getactivActionCode(){
		return activActionCode;
	}
	
	public void setactivActionCode(String activActionCode){
		this.activActionCode = activActionCode;
	}
	
	public Long getisptaCRMIdNumber(){
		return isptaCRMIdNumber;
	}
	
	public void setisptaCRMIdNumber(Long isptaCRMIdNumber){
		this.isptaCRMIdNumber = isptaCRMIdNumber;
	}
	
	public Long getbuscarTagCM(){
		return buscarTagCM;
	}
	
	public void setbuscarTagCM(Long buscarTagCM){
		this.buscarTagCM = buscarTagCM;
	}
	
	public String getdocSIS(){
		return docSIS;
	}
	
	public void setdocSIS(String docSIS){
		this.docSIS = docSIS;
	}
	
	public String getenableAccounting(){
		return enableAccounting;
	}
	
	public void setenableAccounting(String enableAccounting){
		this.enableAccounting = enableAccounting;
	}
	
	public String getproductName(){
		return productName;
	}
	
	public void setproductName(String productName){
		this.productName = productName;
	}
	
	public String getbandPackAgeCRMId(){
		return bandPackAgeCRMId;
	}
	
	public void setbandPackAgeCRMId(String bandPackAgeCRMId){
		this.bandPackAgeCRMId = bandPackAgeCRMId;
	}
	
	public String getprepaIdPoliCyCRMId(){
		return prepaIdPoliCyCRMId;
	}
	
	public void setprepaIdPoliCyCRMId(String prepaIdPoliCyCRMId){
		this.prepaIdPoliCyCRMId = prepaIdPoliCyCRMId;
	}
	
	public Long getcantcPe(){
		return cantcPe;
	}
	
	public void setcantcPe(Long cantcPe){
		this.cantcPe = cantcPe;
	}
	
	public Long getusChannelId(){
		return usChannelId;
	}
	
	public void setusChannelId(Long usChannelId){
		this.usChannelId = usChannelId;
	}
	
	public Long getstartingBalance(){
		return startingBalance;
	}
	
	public void setstartingBalance(Long startingBalance){
		this.startingBalance = startingBalance;
	}
	
	public Long getdsFreq(){
		return dsFreq;
	}
	
	public void setdsFreq(Long dsFreq){
		this.dsFreq = dsFreq;
	}
	
	public Long getperiodicalBaseBalance(){
		return periodicalBaseBalance;
	}
	
	public void setperiodicalBaseBalance(Long periodicalBaseBalance){
		this.periodicalBaseBalance = periodicalBaseBalance;
	}
	
	public boolean getnoBoot(){
		boolean noBootBool = false;
		if (noBoot != null) if (noBoot.equals("T")) noBootBool = true;
		return noBootBool;
	}
	
	public void setnoBoot(String noBoot){
		this.noBoot = noBoot;
	}
	
	public String getmacAddres(){
		return macAddres;
	}
	
	public void setmacAddres(String macAddres){
		this.macAddres = macAddres;
	}
	
	public String gethostName(){
		return hostName;
	}
	
	public void sethostName(String hostName){
		this.hostName = hostName;
	}
	
	public String getcmsCRMId(){
		return cmsCRMId;
	}
	
	public void setcmsCRMId(String cmsCRMId){
		this.cmsCRMId = cmsCRMId;
	}
	
	public Long getprovisioning(){
		return provisioning;
	}
	
	public void setprovisioning(Long provisioning){
		this.provisioning = provisioning;
	}
	
	public String getprofileCRMId(){
		return profileCRMId;
	}
	
	public void setprofileCRMId(String profileCRMId){
		this.profileCRMId = profileCRMId;
	}
	
	public String getispmtaCRMIdText(){
		return ispmtaCRMIdText;
	}
	
	public void setispmtaCRMIdText(String ispmtaCRMIdText){
		this.ispmtaCRMIdText = ispmtaCRMIdText;
	}
	
	public String getsentoController(){
		return sentoController;
	}
	
	public void setsentoController(String sentoController){
		this.sentoController = sentoController;
	}
	
	public Long getlineSqty(){
		return lineSqty;
	}
	
	public void setlineSqty(Long lineSqty){
		this.lineSqty = lineSqty;
	}
	
	public String getmtaModelCRMId(){
		return mtaModelCRMId;
	}
	
	public void setmtaModelCRMId(String mtaModelCRMId){
		this.mtaModelCRMId = mtaModelCRMId;
	}
	
	public Long getendPointNumber(){
		return endPointNumber;
	}
	
	public void setendPointNumber(Long endPointNumber){
		this.endPointNumber = endPointNumber;
	}
	
	public String getTn(){
		return tn;
	}
	
	public void setTn(String tn){
		this.tn = tn;
	}
	
	public String gethomeExchangeCRMId(){
		return homeExchangeCRMId;
	}
	
	public void sethomeExchangeCRMId(String homeExchangeCRMId){
		this.homeExchangeCRMId = homeExchangeCRMId;
	}
	
	public String getfeatureCRMId(){
		return featureCRMId;
	}
	
	public void setfeatureCRMId(String featureCRMId){
		this.featureCRMId = featureCRMId;
	}
	
	public Long getActive(){
		return active;
	}
	
	public void setActive(Long active){
		this.active = active;
	}
	
	public String getDatoi1(){
		return datoi1;
	}
	
	public void setDatoi1(String datoi1){
		this.datoi1 = datoi1;
	}
	
	public String getDatoi2(){
		return datoi2;
	}
	
	public void setDatoi2(String datoi2){
		this.datoi2 = datoi2;
	}
	
	public String getCustomer1(){
		return customer1;
	}
	
	public void setCustomer1(String customer1){
		this.customer1 = customer1;
	}
	
	public String getCustomer2(){
		return customer2;
	}
	
	public void setCustomer2(String customer2){
		this.customer2 = customer2;
	}
	
	public String getCustomer3(){
		return customer3;
	}
	
	public void setCustomer3(String customer3){
		this.customer3 = customer3;
	}
	
	public String getCustomer4(){
		return customer4;
	}
	
	public void setCustomer4(String customer4){
		this.customer4 = customer4;
	}
	
	public int getDeviceId(){
		return deviceId;
	}
	
	public void setDeviceId(int deviceId){
		this.deviceId = deviceId;
	}
	
	public Long getAction(){
		return action;
	}
	
	public void setAction(Long action){
		this.action = action;
	}
	
	public Long getidEmpresa(){
		return idEmpresa;
	}
	
	public void setidEmpresa(Long idEmpresa){
		this.idEmpresa = idEmpresa;
	}
	
   public String getNegocio(){
	   return negocio;
   }
   
   public void setNegocio(String negocio){
	   this.negocio = negocio;
   }
   
   public String getSnmpGroupCRMID(){
	   return snmpGroupCRMId;
   }
   
   public void setSnmpGroupCRMID(String snmpGroupCRMId){
	   this.snmpGroupCRMId = snmpGroupCRMId;
   }
	
   public Long getSecuencia(){
	   return secuencia;
   }
   
   public void setSecuencia(Long secuencia){
	   this.secuencia = secuencia;
   }
   
   public int getInterface(){
		return idInterface;
	}
	
	public void setidInterface(int idInterface){
		this.idInterface = idInterface;
	}
   
   public int getValorEnteroDe(String nombreCampo) throws ConversionException {

		Class<? extends TransactionSpIntraway> clase = TransactionSpIntraway.class;
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

}