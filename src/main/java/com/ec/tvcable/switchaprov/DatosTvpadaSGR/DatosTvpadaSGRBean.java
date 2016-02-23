package com.ec.tvcable.switchaprov.DatosTvpadaSGR;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.switchyard.component.bean.Service;

@Service(DatosTvpadaSGR.class)
public class DatosTvpadaSGRBean implements DatosTvpadaSGR {

	private String code;
	
	String dblink = "@RAC";
	@Override
	public String InternalCode(DatoDeviceModel datodevicemodel) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory enfactory = Persistence.createEntityManagerFactory("switch-aprovisionamiento");
		EntityManager enmanager = enfactory.createEntityManager();
		
		Query query1 = enmanager.createNativeQuery("select internalcode from ytdevicemodel_hiperk"+dblink+" where devicemodel_id= ?")
				.setParameter(1, datodevicemodel.getDeviceModel());
		
		code = query1.getResultList().get(0).toString();
		
		System.out.println("code = "+code);
		
		enmanager.close();
		enfactory.close();
		
		return code;
	}

	@Override
	public DatosAprov datosaprov(TipoComando tipocomando) {


		EntityManagerFactory enfactory = Persistence.createEntityManagerFactory("switch-aprovisionamiento");
		EntityManager enmanager = enfactory.createEntityManager();
		
		Query query1 = enmanager.createNativeQuery("select t.* from YTBL_SGR_COMANDOS"+dblink+" t where t.tipocomando = ?")
				.setParameter(1, tipocomando.getTcomando());
		
		List<Object[]> results = query1.getResultList();
		
		Date date = new Date();
		
		Validacion validacion = new Validacion();
		
		DatosAprov datos = new DatosAprov();
		
		datos.setIdEmpresa(validacion.val(results.get(0)[2], null));
		datos.setNegocio(validacion.val(results.get(0)[3],null));
		datos.setInterface(validacion.val(results.get(0)[4],null));
		datos.setSecuencia(validacion.val(results.get(0)[5],null));
		datos.setSerie(validacion.val(results.get(0)[6],null));
		datos.setTipoD(validacion.val(results.get(0)[7],null));
		datos.setIdConvertidor(validacion.val(results.get(0)[8],null));
		datos.setIdAccount(validacion.val(results.get(0)[9],null));
		datos.setCitem(validacion.val(results.get(0)[10],null));
		datos.setUbicacion(validacion.val(results.get(0)[11],null));
		datos.setAccion(validacion.val(results.get(0)[12],null));
		datos.setCredito(validacion.val(results.get(0)[13],null));
		datos.setIdServicio(validacion.val(results.get(0)[14],0));
		datos.setIdPaquetes(validacion.val(results.get(0)[15],null));
		datos.setIdPaquete(validacion.val(results.get(0)[16],null));
		datos.setIdEventos(validacion.val(results.get(0)[17],null));
		datos.setIdEvento(validacion.val(results.get(0)[18],null));
		datos.setTipoA(validacion.val(results.get(0)[19],null));
		datos.setEstadoC(validacion.val(results.get(0)[20],null));
		datos.setFormadePago(validacion.val(results.get(0)[21],null));
		datos.setTipoC(validacion.val(results.get(0)[22],null));
		datos.setCodigoCanal(validacion.val(results.get(0)[23],null));
		datos.setDescEvento(validacion.val(results.get(0)[24],null));
		datos.setFechaIni(date);
		datos.setTiempoIni(date);
		datos.setFechaFin(date);
		datos.setTiempoFin(date);
		datos.setDuracionEvento(validacion.val(results.get(0)[29],null));
		datos.setIterstitial(validacion.val(results.get(0)[30],null));
		datos.setTiempoLibre(validacion.val(results.get(0)[31],null));
		datos.setMpaa(validacion.val(results.get(0)[32],null));
		datos.setContenidoViolento(validacion.val(results.get(0)[33],null));
		datos.setContenidoSexual(validacion.val(results.get(0)[34],null));
		datos.setLenguaje(validacion.val(results.get(0)[35],null));
		datos.setRating(validacion.val(results.get(0)[36],null));
		datos.setTiempoCompra(validacion.val(results.get(0)[37],null));
		datos.setPaquete(validacion.val(results.get(0)[38],null));
		datos.setTiempoDisplay(validacion.val(results.get(0)[39],null));
		datos.setCostoEvento(validacion.val(results.get(0)[40],null));
		datos.setPrecioEvento(validacion.val(results.get(0)[41],null));
		datos.setAnyTime(validacion.val(results.get(0)[42],null));
		datos.setTipoPromocion(validacion.val(results.get(0)[43],null));
		datos.setDatoC1(validacion.val(results.get(0)[44],null));
		datos.setDatoC2(validacion.val(results.get(0)[45],null));
		
		
		
		enmanager.close();
		enfactory.close();
				
					
		return datos;
	}
}
