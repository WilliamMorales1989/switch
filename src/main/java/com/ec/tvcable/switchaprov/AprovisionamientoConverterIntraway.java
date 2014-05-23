/**
 * 
 */
package com.ec.tvcable.switchaprov;

import com.ec.tvcable.switchaprov.exception.ConversionException;
import com.ec.tvcable.switchaprov.jpa.TransactionSpIntraway;
import com.ec.tvcable.switchaprov.service.intraway.Cabecera;
import com.ec.tvcable.switchaprov.service.intraway.Comando;
import com.ec.tvcable.switchaprov.service.intraway.Detalle;
import com.ec.tvcable.switchaprov.service.intraway.Intraway;
import com.ec.tvcable.switchaprov.service.intraway.Estandar;
import com.ec.tvcable.switchaprov.service.intraway.Interfaz;

/**
 * @author pablo
 *
 */
public class AprovisionamientoConverterIntraway {
	
	private TransactionSpIntraway transactionSp;
	
	public AprovisionamientoConverterIntraway(TransactionSpIntraway transactionSp) {
		super();
		this.transactionSp = transactionSp;
	}

	public Comando toComandoIntraway() throws ConversionException {
		Comando comando = new Comando();
		Detalle detalle = new Detalle();
		comando.setCabecera(createHeader(transactionSp));
		detalle.setIntraway(createIntraway(transactionSp));
		comando.setDetalle(detalle);
		
		return comando;
	}

	private Intraway createIntraway(TransactionSpIntraway transactionSp) throws ConversionException {
		Intraway intraway = new Intraway();
		System.out.println("createIntraway");
		intraway.setEstandar(createEstandar(transactionSp));
		intraway.setInterfaz(createInterfaz(transactionSp));
		
		return intraway;
	}

	private Cabecera createHeader(TransactionSpIntraway transactionSp) throws ConversionException {
		Cabecera cabecera = new Cabecera();
		System.out.println("createHeader");		
		cabecera.setIDEmpresa(transactionSp.getidEmpresa());
		cabecera.setNegocio(transactionSp.getNegocio());
		cabecera.setInterface(transactionSp.getDeviceId());
		cabecera.setSecuencia(transactionSp.getSecuencia());		
		return cabecera;
	}
	
	private Estandar createEstandar(TransactionSpIntraway transactionSp) throws ConversionException {
		Estandar estandar = new Estandar();
		System.out.println("createEstandar");
		estandar.setAuthKey(transactionSp.getAuthKey());
		estandar.setClienteCRM(transactionSp.getClienteCrm());
		estandar.setIdProducto(transactionSp.getIdProducto());
		estandar.setIdProductoPadre(transactionSp.getIdProductoPadre());
		estandar.setIdServicio(transactionSp.getidServicio());
		estandar.setIdServicioPadre(transactionSp.getidServicioPadre());
		estandar.setIdVenta(transactionSp.getidVenta());
		estandar.setIdVentaPadre(transactionSp.getidventaPadre());
		estandar.setIdPromotor(transactionSp.getidPromotor());
		estandar.setFechaDiferida(transactionSp.getfechaDiferida());
		estandar.setIdEstado(transactionSp.getIdEstado());
		return estandar;
	}

	private Interfaz createInterfaz(TransactionSpIntraway transactionSp) throws ConversionException {
		Interfaz interfaz = new Interfaz();
		System.out.println("createInterfaz");
		try{
		interfaz.setNombre(transactionSp.getNombre());
		interfaz.setUsername(transactionSp.getuserName());
		interfaz.setPassword(transactionSp.getPassword());
		interfaz.setIdTipoCliente(transactionSp.getidTipoCliente());
		interfaz.setEmailNoticias(transactionSp.getemailNoticias());
		interfaz.setIdCicloFactCRM(transactionSp.getidClicloFactCRM());
		interfaz.setServicTypeCRMId(transactionSp.getservicTypeCRMId());
		interfaz.setMessageCRMID(transactionSp.getmessageCRMId());
		interfaz.setCantidad(transactionSp.getCantidad());
		interfaz.setQuotamax(transactionSp.getquotaMax());
		interfaz.setServidorEmailCRMId(transactionSp.getservidorEmailCRMId());
		interfaz.setDominio(transactionSp.getDomino());
		interfaz.setDiskQuota(interfaz.getDiskQuota());
		interfaz.setNoticias(transactionSp.getNoticias());
		interfaz.setName(transactionSp.getName());
		interfaz.setServicePackageCRMId(transactionSp.getservicePackAgeCRMId());
		interfaz.setHub(transactionSp.getHub());
		interfaz.setNodo(transactionSp.getNodo());
		interfaz.setIdISPCRM(transactionSp.getidIspCRM());
		interfaz.setActivactionCode(transactionSp.getactivActionCode());
		interfaz.setIspMtaCrmId(transactionSp.getispmtaCRMIdText());
		interfaz.setBuscarTagCRM(transactionSp.getbuscarTagCM());
		interfaz.setDocsis(transactionSp.getdocSIS());
		interfaz.setEnableAccounting(transactionSp.getenableAccounting());
		interfaz.setProductName(transactionSp.getproductName());
		interfaz.setBandPackageCRMId(transactionSp.getbandPackAgeCRMId());
		interfaz.setPrepaidPolicyCRMId(transactionSp.getprepaIdPoliCyCRMId());
		interfaz.setCantCPE(transactionSp.getcantcPe());
		interfaz.setUSChannelID(transactionSp.getusChannelId());
		interfaz.setStartingBalance(transactionSp.getstartingBalance());
		interfaz.setDSFreq(transactionSp.getdsFreq());
		interfaz.setPeriodicalBaseBalance(transactionSp.getperiodicalBaseBalance());
		interfaz.setNoBoot(transactionSp.getnoBoot());
		interfaz.setMACAddress(transactionSp.getmacAddres());
		interfaz.setSnmpGroupCRMID(transactionSp.getSnmpGroupCRMID());
		interfaz.setHostName(transactionSp.gethostName());
		interfaz.setCmsCMDID(transactionSp.getcmsCRMId());
		interfaz.setProvisioning(transactionSp.getprovisioning());
		interfaz.setProfileCRMId(transactionSp.getprofileCRMId());
		interfaz.setSendtoController(transactionSp.getsentoController());
		interfaz.setLinesQTy(transactionSp.getlineSqty());
		interfaz.setMtaModelCRMId(transactionSp.getmtaModelCRMId());
		interfaz.setEndpointNumber(transactionSp.getendPointNumber());
		interfaz.setTn(transactionSp.getTn());
		interfaz.setHomeExchangeCRMId(transactionSp.gethomeExchangeCRMId());
		interfaz.setFeatureCrmId(transactionSp.getfeatureCRMId());
		interfaz.setActive(transactionSp.getActive());
		interfaz.setDatoI1(transactionSp.getDatoi1());
		interfaz.setDatoI2(transactionSp.getDatoi2());
		interfaz.setCustomer1(transactionSp.getCustomer1());
		interfaz.setCustomer2(transactionSp.getCustomer2());
		interfaz.setCustomer3(transactionSp.getCustomer3());
		interfaz.setCustomer4(transactionSp.getCustomer4());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
		}
		return interfaz;
	}

}
