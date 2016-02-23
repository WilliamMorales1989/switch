package com.ec.tvcable.switchaprov.TvPagadaSGR;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import com.ec.tvcable.switchaprov.AprovisionamientoSGR.Aprovisionamiento_Type;
import com.ec.tvcable.switchaprov.DatosTvpadaSGR.DatoDeviceModel;
import com.ec.tvcable.switchaprov.DatosTvpadaSGR.DatosAprov;
import com.ec.tvcable.switchaprov.DatosTvpadaSGR.DatosTvpadaSGR;
import com.ec.tvcable.switchaprov.DatosTvpadaSGR.TipoComando;
import com.ec.tvcable.switchaprov.DatosTvpadaSGR.Validacion;
import com.ec.tvcable.switchaprov.conax.CreacionConax;
import com.ec.tvcable.switchaprov.service.tvpagada.Cabecera;
import com.ec.tvcable.switchaprov.service.tvpagada.Comando;
import com.ec.tvcable.switchaprov.service.tvpagada.Comienzo;
import com.ec.tvcable.switchaprov.service.tvpagada.Detalle;
import com.ec.tvcable.switchaprov.service.tvpagada.Final;
import com.ec.tvcable.switchaprov.service.tvpagada.IdEventos;
import com.ec.tvcable.switchaprov.service.tvpagada.IdPaquetes;
import com.ec.tvcable.switchaprov.service.tvpagada.Mensaje;
import com.ec.tvcable.switchaprov.service.tvpagada.Respuesta;
import com.ec.tvcable.switchaprov.service.tvpagada.TVpagada;
import com.ec.tvcable.switchaprov.service.tvpagada.WsdlTvPagada;

@Service(TvPagadaSGR.class)
public class TvPagadaSGRBean implements TvPagadaSGR {

	@Reference
	@Inject
	private DatosTvpadaSGR datostvpagada;
	
	@Reference
	@Inject
	private WsdlTvPagada wsdltvpada;
	
	@Reference
	@Inject
	private CreacionConax creacionconax;
	
	private Respuesta respuesta;
	
	String dblink = "@BSDESA";
	
	//private static final Logger logger = Logger.getLogger(TvInterfazServiceBean.class);
	
	private String InternalCode;
	
	@Resource(mappedName = "java:/jdbc/DesaAppDS")
	private DataSource datasource;
	
	@Override
	public Respuesta resp(Aprovisionamiento_Type param) {
		
		/**0 = creacion de equipos = IN**/
		/**1 = eliminacion de equipos = OUT**/
		/**2 = activacion de equipos = ACTIVAR**/
		/**3 = activacion de equipos = CORTAR**/
		/**4 = activacion de equipos = INICIALIZAR**/
		/**5 = activacion de equipos = REFRESCAR**/
		/**6 = activacion de equipos = RECOLECTAR DIGITAL**/
		/**7 = activacion de equipos = RECOLECTAR**/
		
		if(param.getBodyRequest().getTipo().equals("IN")){
			if(param.getHeaderRequest().getController().equals("DAC") || param.getHeaderRequest().getController().equals("DAC_MEDIAGATEWAY")){
				respuesta = creacion(param, 0);
			}else{
				respuesta = creacionconax.resp(param);
			}
			return respuesta;
		}else if(param.getBodyRequest().getTipo().equals("OUT")){
			respuesta = eliminacion(param, 1);
			return respuesta;
		}else if(param.getBodyRequest().getTipo().equals("ACTIVAR")){
			
			ValidacionEquipos validacion = new ValidacionEquipos();
			ErroresSQL error = new ErroresSQL();
			
			error = validacion.verificacionEquipos(param, datasource);
				
			if(error.getCodError() == 1){
				
				respuesta = new Respuesta();
				
				Mensaje mensaje = new Mensaje();
				
				mensaje.setCodError(error.getCodError());
				mensaje.setDetMensaje(error.getDetailError());
				mensaje.setDatosExtrasTVP(null);
				
				respuesta.setMensaje(mensaje);
							
				return respuesta;
			}else{
				
				DatoDeviceModel devicemodel = new DatoDeviceModel();
				devicemodel.setDeviceModel(param.getBodyRequest().getDeviceModel());
				
				InternalCode = datostvpagada.InternalCode(devicemodel);
				
				TipoComando tipocomando = new TipoComando();
				tipocomando.setTcomando(2);
				
				DatosAprov datosaprov = datostvpagada.datosaprov(tipocomando);
				
				datosaprov.setIdServicio(param.getBodyRequest().getIdPlan());
				
				String citem = validacion.citemEquipo(Integer.parseInt(param.getBodyRequest().getIdRestype()), datasource);
				
				datosaprov.setCitem(citem);
				Comando comando = coman(param, datosaprov);
				
				respuesta = invoke(comando);
				
				int result = validacion.RLBCHECKMISTAKE(respuesta.getMensaje().getCodError(), respuesta.getMensaje().getDetMensaje(), datasource);
				validacion.RLBREGISTROACCIONLAB(param, respuesta, datasource);
				respuesta.getMensaje().setCodError(result);
			}
			return respuesta;
		}else if(param.getBodyRequest().getTipo().equals("CORTAR")){
			
			ValidacionEquipos activacion = new ValidacionEquipos();
			ErroresSQL error = new ErroresSQL();
			
			error = activacion.verificacionEquipos(param, datasource);
				
			if(error.getCodError() == 1){
				
				respuesta = new Respuesta();
				
				Mensaje mensaje = new Mensaje();
				
				mensaje.setCodError(error.getCodError());
				mensaje.setDetMensaje(error.getDetailError());
				mensaje.setDatosExtrasTVP(null);
				
				respuesta.setMensaje(mensaje);
							
				return respuesta;
			}else{
				
				DatoDeviceModel devicemodel = new DatoDeviceModel();
				devicemodel.setDeviceModel(param.getBodyRequest().getDeviceModel());
				
				InternalCode = datostvpagada.InternalCode(devicemodel);
				
				TipoComando tipocomando = new TipoComando();
				tipocomando.setTcomando(3);
				
				DatosAprov datosaprov = datostvpagada.datosaprov(tipocomando);
				
				//datosaprov.setIdServicio(param.getBodyRequest().getIdPlan());
				
				String citem = activacion.citemEquipo(Integer.parseInt(param.getBodyRequest().getIdRestype()), datasource);
				
				datosaprov.setCitem(citem);
				Comando comando = coman(param, datosaprov);
				
				respuesta = invoke(comando);
				
				int result = activacion.RLBCHECKMISTAKE(respuesta.getMensaje().getCodError(), respuesta.getMensaje().getDetMensaje(), datasource);
				activacion.RLBREGISTROACCIONLAB(param, respuesta, datasource);
				respuesta.getMensaje().setCodError(result);
			}
			return respuesta;
		}else if(param.getBodyRequest().getTipo().equals("INICIALIZAR")){
			
			ValidacionEquipos activacion = new ValidacionEquipos();
			ErroresSQL error = new ErroresSQL();
			
			error = activacion.verificacionEquipos(param, datasource);
				
			if(error.getCodError() == 1){
				
				respuesta = new Respuesta();
				
				Mensaje mensaje = new Mensaje();
				
				mensaje.setCodError(error.getCodError());
				mensaje.setDetMensaje(error.getDetailError());
				mensaje.setDatosExtrasTVP(null);
				
				respuesta.setMensaje(mensaje);
							
				return respuesta;
			}else{
				
				DatoDeviceModel devicemodel = new DatoDeviceModel();
				devicemodel.setDeviceModel(param.getBodyRequest().getDeviceModel());
				
				InternalCode = datostvpagada.InternalCode(devicemodel);
				
				TipoComando tipocomando = new TipoComando();
				tipocomando.setTcomando(4);
				
				DatosAprov datosaprov = datostvpagada.datosaprov(tipocomando);
				
				datosaprov.setIdServicio(param.getBodyRequest().getIdPlan());
				
				String citem = activacion.citemEquipo(Integer.parseInt(param.getBodyRequest().getIdRestype()), datasource);
				
				datosaprov.setCitem(citem);
				Comando comando = coman(param, datosaprov);
				
				respuesta = invoke(comando);
				
				int result = activacion.RLBCHECKMISTAKE(respuesta.getMensaje().getCodError(), respuesta.getMensaje().getDetMensaje(), datasource);
				activacion.RLBREGISTROACCIONLAB(param, respuesta, datasource);
				respuesta.getMensaje().setCodError(result);
			}
			return respuesta;
			
		}else if(param.getBodyRequest().getTipo().equals("REFRESCAR")){
			
			ValidacionEquipos activacion = new ValidacionEquipos();
			ErroresSQL error = new ErroresSQL();
			
			error = activacion.verificacionEquipos(param, datasource);
				
			if(error.getCodError() == 1){
				
				respuesta = new Respuesta();
				
				Mensaje mensaje = new Mensaje();
				
				mensaje.setCodError(error.getCodError());
				mensaje.setDetMensaje(error.getDetailError());
				mensaje.setDatosExtrasTVP(null);
				
				respuesta.setMensaje(mensaje);
							
				return respuesta;
			}else{
				
				DatoDeviceModel devicemodel = new DatoDeviceModel();
				devicemodel.setDeviceModel(param.getBodyRequest().getDeviceModel());
				
				InternalCode = datostvpagada.InternalCode(devicemodel);
				
				TipoComando tipocomando = new TipoComando();
				tipocomando.setTcomando(5);
				
				DatosAprov datosaprov = datostvpagada.datosaprov(tipocomando);
				
				datosaprov.setIdServicio(param.getBodyRequest().getIdPlan());
				
				String citem = activacion.citemEquipo(Integer.parseInt(param.getBodyRequest().getIdRestype()), datasource);
				
				datosaprov.setCitem(citem);
				Comando comando = coman(param, datosaprov);
				
				respuesta = invoke(comando);
				
				int result = activacion.RLBCHECKMISTAKE(respuesta.getMensaje().getCodError(), respuesta.getMensaje().getDetMensaje(), datasource);
				activacion.RLBREGISTROACCIONLAB(param, respuesta, datasource);
				respuesta.getMensaje().setCodError(result);
			}
			return respuesta;
			
		}else if(param.getBodyRequest().getTipo().equals("RECOLECTAR")){
			
			ValidacionEquipos activacion = new ValidacionEquipos();
			ErroresSQL error = new ErroresSQL();
			
			error = activacion.verificacionEquipos(param, datasource);
				
			if(error.getCodError() == 1){
				
				respuesta = new Respuesta();
				
				Mensaje mensaje = new Mensaje();
				
				mensaje.setCodError(error.getCodError());
				mensaje.setDetMensaje(error.getDetailError());
				mensaje.setDatosExtrasTVP(null);
				
				respuesta.setMensaje(mensaje);
							
				return respuesta;
			}else{
				
				DatoDeviceModel devicemodel = new DatoDeviceModel();
				devicemodel.setDeviceModel(param.getBodyRequest().getDeviceModel());
				
				InternalCode = datostvpagada.InternalCode(devicemodel);
				
				TipoComando tipocomando = new TipoComando();
				tipocomando.setTcomando(6);
				
				DatosAprov datosaprov = datostvpagada.datosaprov(tipocomando);
				
				//datosaprov.setIdServicio(param.getBodyRequest().getIdPlan());
				
				String citem = activacion.citemEquipo(Integer.parseInt(param.getBodyRequest().getIdRestype()), datasource);
				
				datosaprov.setCitem(citem);
				Comando comando = coman(param, datosaprov);
				
				respuesta = invoke(comando);
				
				if (respuesta.getMensaje().getCodError() == 1){
					
					DatoDeviceModel devicemodel2 = new DatoDeviceModel();
					devicemodel2.setDeviceModel(param.getBodyRequest().getDeviceModel());
					
					InternalCode = datostvpagada.InternalCode(devicemodel);
					
					TipoComando tipocomando2 = new TipoComando();
					tipocomando2.setTcomando(7);
					
					DatosAprov datosaprov2 = datostvpagada.datosaprov(tipocomando2);
					
					//datosaprov2.setIdServicio(param.getBodyRequest().getIdPlan());
					
					String citem2 = activacion.citemEquipo(Integer.parseInt(param.getBodyRequest().getIdRestype()), datasource);
					
					datosaprov2.setCitem(citem2);
					Comando comando2 = coman(param, datosaprov2);
					
					respuesta = invoke(comando2);
					
					int result = activacion.RLBCHECKMISTAKE(respuesta.getMensaje().getCodError(), respuesta.getMensaje().getDetMensaje(), datasource);
					activacion.RLBREGISTROACCIONLAB(param, respuesta, datasource);
					respuesta.getMensaje().setCodError(result);
					
				}else{
					return respuesta;
				}
			}
			return respuesta;
			
		}else if(param.getBodyRequest().getTipo().equals("COLD INIT")){
			
			ValidacionEquipos activacion = new ValidacionEquipos();
			ErroresSQL error = new ErroresSQL();
			
			error = activacion.verificacionEquipos(param, datasource);
				
			if(error.getCodError() == 1){
				
				respuesta = new Respuesta();
				
				Mensaje mensaje = new Mensaje();
				
				mensaje.setCodError(error.getCodError());
				mensaje.setDetMensaje(error.getDetailError());
				mensaje.setDatosExtrasTVP(null);
				
				respuesta.setMensaje(mensaje);
							
				return respuesta;
			}else{
				
				DatoDeviceModel devicemodel = new DatoDeviceModel();
				devicemodel.setDeviceModel(param.getBodyRequest().getDeviceModel());
				
				InternalCode = datostvpagada.InternalCode(devicemodel);
				
				TipoComando tipocomando = new TipoComando();
				tipocomando.setTcomando(8);
				
				DatosAprov datosaprov = datostvpagada.datosaprov(tipocomando);
				
				//datosaprov.setIdServicio(param.getBodyRequest().getIdPlan());
				
				String citem = activacion.citemEquipo(Integer.parseInt(param.getBodyRequest().getIdRestype()), datasource);
				
				datosaprov.setCitem(citem);
				Comando comando = coman(param, datosaprov);
				
				respuesta = invoke(comando);
				
				int result = activacion.RLBCHECKMISTAKE(respuesta.getMensaje().getCodError(), respuesta.getMensaje().getDetMensaje(), datasource);
				activacion.RLBREGISTROACCIONLAB(param, respuesta, datasource);
				respuesta.getMensaje().setCodError(result);
			}
			return respuesta;
			
		}
		
				
		return respuesta;
		
	}
	/********************************************************CREACION*************************************************************/
	private Respuesta creacion(Aprovisionamiento_Type parametros, int accion){
		
		String equipoexiste = RLBCHECKRESOURCEVALUE(parametros);
		
		if (equipoexiste.equals("OK")){
			/*DatoDeviceModel devicemodel = new DatoDeviceModel();
			devicemodel.setDeviceModel(parametros.getBodyRequest().getDeviceModel());
			
			InternalCode = datostvpagada.InternalCode(devicemodel);*/
			
			TipoComando tipocomando = new TipoComando();
			tipocomando.setTcomando(accion);
			
			DatosAprov datosaprov = datostvpagada.datosaprov(tipocomando);
			
			Comando comando = coman(parametros, datosaprov);
			
			respuesta = invoke(comando);
			
			if (parametros.getHeaderRequest().getController().equals("DAC")){
				
				CreacionEquiposDAC(parametros,respuesta,comando.getDetalle().getTVpagada().getIdAccount());
				
			}else{
				
				CreacionEquiposMultiroom(parametros,respuesta,comando.getDetalle().getTVpagada().getIdAccount());
				
			}
			
			Respuesta respuesta = new Respuesta();
			
			Mensaje mensaje = new Mensaje();
			mensaje.setCodError(0);
			mensaje.setDetMensaje("Proceso Realizado con Exito");
			mensaje.setDatosExtrasTVP(null);
			respuesta.setMensaje(mensaje);
			
			return respuesta;
		}else{
			Respuesta respuesta = new Respuesta();
					
			Mensaje mensaje = new Mensaje();
			mensaje.setCodError(1);
			mensaje.setDetMensaje("ERROR: El equipo ya existe");
			mensaje.setDatosExtrasTVP(null);
			respuesta.setMensaje(mensaje);
			
			return respuesta;
		}
		
	}
	Connection connection;
	private String RLBCHECKRESOURCEVALUE(Aprovisionamiento_Type parametros){
		
		String resultado = null;
		
		try {
			connection = datasource.getConnection();
			CallableStatement preparecall = connection.prepareCall("{call YLABPACK.RLBCHECKRESOURCEVALUE(?,?,?,?,?,?)}");
			preparecall.setString(1, parametros.getBodyRequest().getBodega());
			preparecall.setString(2, parametros.getBodyRequest().getIdEmpresa());
			preparecall.setString(3, parametros.getBodyRequest().getCodigoArticulo());
			preparecall.setInt(4, parametros.getBodyRequest().getDeviceModel());
			preparecall.setString(5, parametros.getBodyRequest().getSerie());
			preparecall.registerOutParameter(6, Types.VARCHAR);
			preparecall.executeQuery();
			resultado = preparecall.getString(6);
			System.out.println("resultado: "+ resultado);
			connection.close();
			
			return resultado;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return resultado;
	}
	
	private void CreacionEquiposDAC (Aprovisionamiento_Type parametros, Respuesta respuesta, int idcontroller){
		
		try {
			connection = datasource.getConnection();
			CallableStatement prepareCall = connection.prepareCall("{call YPKG_SGR.YPRD_CREACION_EQUIPOS(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			prepareCall.setString(1, parametros.getBodyRequest().getNombreCiudad());
			prepareCall.setString(2, parametros.getBodyRequest().getBodega());
			prepareCall.setString(3, parametros.getBodyRequest().getIdEmpresa());
			prepareCall.setString(4, parametros.getBodyRequest().getCodigoArticulo());
			prepareCall.setInt(5, parametros.getBodyRequest().getDeviceModel());
			prepareCall.setString(6, parametros.getBodyRequest().getSerie());
			prepareCall.setString(7, parametros.getBodyRequest().getMacAddress1());
			prepareCall.setString(8, parametros.getBodyRequest().getMacAddress2());
			prepareCall.setString(9, parametros.getBodyRequest().getUsuario());
			prepareCall.setInt(10, Integer.parseInt(parametros.getBodyRequest().getIdRestype()));
			prepareCall.setString(11, parametros.getBodyRequest().getTipo());
			prepareCall.setInt(12, respuesta.getMensaje().getCodError());
			prepareCall.setString(13, respuesta.getMensaje().getDetMensaje());
			prepareCall.setInt(14, idcontroller);
			prepareCall.execute();

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private void CreacionEquiposMultiroom (Aprovisionamiento_Type parametros, Respuesta respuesta, int idcontroller){
		
		try {
			connection = datasource.getConnection();
			CallableStatement prepareCall = connection.prepareCall("{call YPKG_SGR.YPRD_CREACION_EQUIPOS_MULTI(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			prepareCall.setString(1, parametros.getBodyRequest().getNombreCiudad());
			prepareCall.setString(2, parametros.getBodyRequest().getBodega());
			prepareCall.setString(3, parametros.getBodyRequest().getIdEmpresa());
			prepareCall.setString(4, parametros.getBodyRequest().getCodigoArticulo());
			prepareCall.setInt(5, parametros.getBodyRequest().getDeviceModel());
			prepareCall.setString(6, parametros.getBodyRequest().getSerie());
			prepareCall.setString(7, parametros.getBodyRequest().getMacAddress1());
			prepareCall.setString(8, parametros.getBodyRequest().getMacAddress2());
			prepareCall.setString(9, parametros.getBodyRequest().getUsuario());
			prepareCall.setInt(10, Integer.parseInt(parametros.getBodyRequest().getIdRestype()));
			prepareCall.setString(11, parametros.getBodyRequest().getTipo());
			prepareCall.setInt(12, respuesta.getMensaje().getCodError());
			prepareCall.setString(13, respuesta.getMensaje().getDetMensaje());
			prepareCall.setInt(14, idcontroller);
			prepareCall.execute();

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
	public Comando coman (Aprovisionamiento_Type param, DatosAprov datos){
		
		Comando com = new Comando();
		com.setCabecera(cabecera(param, datos));
		
		Detalle detalle = new Detalle();
		detalle.setTVpagada(tocomando(param, datos));
		
		com.setDetalle(detalle);
		
		return com;
		
	}
	
	public Cabecera cabecera(Aprovisionamiento_Type param, DatosAprov datos){
		
		Cabecera cabecera = new Cabecera();
		int ciudaddac = CiudadDAC(param.getBodyRequest().getNombreCiudad());
		cabecera.setIDEmpresa(ciudaddac);
		cabecera.setInterface(Integer.parseInt(datos.getInterface()));
		cabecera.setNegocio(Integer.parseInt(datos.getNegocio()));
		cabecera.setSecuencia(Integer.parseInt(datos.getSecuencia()));
		
		return cabecera;
	}
	
	public TVpagada tocomando(Aprovisionamiento_Type param, DatosAprov datos){
		
		Validacion nvl = new Validacion();
		
		TVpagada tvpagada = new TVpagada();
		
		tvpagada.setAccion(nvl.val(datos.getAccion(),0));
		tvpagada.setAnyTime(nvl.val(datos.getAnyTime(),0));
		tvpagada.setCItem(nvl.val(datos.getCitem(),0));
		tvpagada.setCodigoCanal(nvl.val(datos.getCodigoCanal(),0));
		
		Comienzo comienzo = new Comienzo();
		comienzo.setFechaIni(datos.getFechaIni());
		comienzo.setTiempoIni(datos.getTiempoIni());
		tvpagada.setComienzo(comienzo);
		
		tvpagada.setContenidoSexual(nvl.val(datos.getContenidoSexual(),0));
		tvpagada.setContenidoViolento(nvl.val(datos.getContenidoViolento(),0));
		tvpagada.setCostoEvento(nvl.val(datos.getCostoEvento(),0));
		tvpagada.setCredito(nvl.val(datos.getCredito(),0));
		tvpagada.setDatoC1(datos.getDatoC1());
		tvpagada.setDatoC2(datos.getDatoC2());
		tvpagada.setDescEvento(datos.getDescEvento());
		tvpagada.setDuracionEvento(nvl.val(datos.getDuracionEvento(),0));
		tvpagada.setEstadoC(datos.getEstadoC());

		Final Ffinal = new Final();
		Ffinal.setFechaFin(datos.getFechaFin());
		Ffinal.setTiempoFin(datos.getTiempoFin());
		tvpagada.setFinal(Ffinal);
		
		tvpagada.setFormaPago(datos.getFormadePago());
		
		if(param.getBodyRequest().getTipo().equals("ACTIVAR") 
				|| param.getBodyRequest().getTipo().equals("INICIALIZAR") 
				|| param.getBodyRequest().getTipo().equals("REFRESCAR")){
			
			tvpagada.setIdAccount(nvl.val(Integer.parseInt(datos.getIdAccount()),0));
			
		}else if(param.getBodyRequest().getTipo().equals("RECOLECTAR")
				||param.getBodyRequest().getTipo().equals("CORTAR")
				|| param.getBodyRequest().getTipo().equals("COLD INIT")){
			tvpagada.setIdAccount(0);
		}else{
			tvpagada.setIdAccount(IdController(param));
		}
		
		//(nvl.val(datos.getIdAccount(),0));
		
		IdEventos ideventos = new IdEventos();
		ideventos.setCantE(0);//----------------------revisar
		tvpagada.setIdEventos(ideventos);
		
		IdPaquetes idpaquetes = new IdPaquetes();
		idpaquetes.setCantP(0);
		tvpagada.setIdPaquetes(idpaquetes);
		
		tvpagada.setIdServicio(nvl.val(datos.getIdServicio(),0));
		tvpagada.setInterstitial(nvl.val(datos.getIterstitial(),0));
		tvpagada.setLenguaje(nvl.val(datos.getLenguaje(),0));
		tvpagada.setMpaa(nvl.val(datos.getMpaa(),0));
		tvpagada.setPaquete(nvl.val(datos.getPaquete(),0));
		tvpagada.setPrecioEvento(nvl.val(datos.getPrecioEvento(),0));
		tvpagada.setRating(nvl.val(datos.getRating(),0));
		
		if (param.getHeaderRequest().getController().equals("DAC")){
			
			tvpagada.setSerie(param.getBodyRequest().getSerie());
			tvpagada.setIdConvertidor(param.getBodyRequest().getMacAddress1());
			
		}else{
			
			tvpagada.setSerie(param.getBodyRequest().getMacAddress3());
			tvpagada.setIdConvertidor(param.getBodyRequest().getMacAddress4());			
		}	
		
		tvpagada.setTiempoCompra(nvl.val(datos.getTiempoCompra(),0));
		tvpagada.setTiempoDisplay(nvl.val(datos.getTiempoDisplay(),0));
		tvpagada.setTiempoLibre(nvl.val(datos.getTiempoLibre(),0));
		tvpagada.setTipoA(nvl.val(datos.getTipoA(),0));//(param.getBodyRequest().getIdUsuario());
		tvpagada.setTipoC(nvl.val(datos.getTipoC(),0));
		tvpagada.setTipoD(Integer.parseInt(InternalCode));
		tvpagada.setTipoPromocion(nvl.val(datos.getTipoPromocion(),0));
		tvpagada.setUbicacion(nvl.val(datos.getUbicacion(),0));
	
		
		return tvpagada;
	}

	private int CiudadDAC (String ciudad){
		
		
		EntityManagerFactory enfactory = Persistence.createEntityManagerFactory("switch-aprovisionamiento");
		EntityManager enmanager = enfactory.createEntityManager();
		
		Query query1 = enmanager.createNativeQuery("SELECT idciudad FROM YTLABCIUDADDAC"+dblink+" WHERE upper(nombre) =upper(?)")
				.setParameter(1, ciudad);
		
		String code = query1.getResultList().get(0).toString();
		
		int resul = 0;
		resul = Integer.parseInt(code);
		
		System.out.println("code = "+code);
		
		enmanager.close();
		enfactory.close();
		return resul;
		
	}
	
	private int IdController(Aprovisionamiento_Type parametros){
		
		int resultado = 0;
		try {
			connection = datasource.getConnection();
			CallableStatement preparecall = connection.prepareCall("{call YLABPACK.RLBGETIDCONTROLER(?,?,?,?,?,?,?)}");
			preparecall.setString(1, parametros.getBodyRequest().getSerie());
			preparecall.setString(2, parametros.getBodyRequest().getIdEmpresa());
			preparecall.setString(3, parametros.getBodyRequest().getBodega());
			preparecall.setString(4, parametros.getBodyRequest().getUsuario());
			preparecall.setString(5, parametros.getBodyRequest().getIdRestype());
			preparecall.setInt(6, parametros.getBodyRequest().getDeviceModel());
			preparecall.registerOutParameter(7, Types.VARCHAR);
			preparecall.execute();
			
			resultado = preparecall.getInt(7);
			connection.close();
			return resultado;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return resultado;
				
	}
	
	public Respuesta invoke(Comando comando){
		
		return wsdltvpada.AprovTvPagada(comando);
	}
	
	/********************************************************ELIMINACION*************************************************************/
	
	private String RLBCHECKRESOURCEFORDELETE(Aprovisionamiento_Type parametros){
		
		String resultado = null;
		
		try {
			connection = datasource.getConnection();
			CallableStatement preparecall = connection.prepareCall("{call YLABPACK.RLBCHECKRESOURCEFORDELETE(?,?,?,?,?)}");
			preparecall.setString(1, parametros.getBodyRequest().getBodega());
			preparecall.setString(2, parametros.getBodyRequest().getIdEmpresa());
			preparecall.setInt(3, parametros.getBodyRequest().getDeviceModel());
			preparecall.setString(4, parametros.getBodyRequest().getSerie());
			preparecall.registerOutParameter(5, Types.VARCHAR);
			preparecall.executeQuery();
			resultado = preparecall.getString(5);
			System.out.println("resultado: "+ resultado);
			connection.close();
			
			return resultado;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return resultado;
	}
	
	private Respuesta eliminacion(Aprovisionamiento_Type parametros, int accion){
		
		String equipoexiste = RLBCHECKRESOURCEFORDELETE(parametros);
		
		if (equipoexiste.equals("OK")){
			DatoDeviceModel devicemodel = new DatoDeviceModel();
			devicemodel.setDeviceModel(parametros.getBodyRequest().getDeviceModel());
			
			Comando comando = null;
			
			if (parametros.getHeaderRequest().getController().equals("DAC") || parametros.getHeaderRequest().getController().equals("DAC_MEDIAGATEWAY")){
				
				/**************Aprovicionamiento eliminacion************/
						InternalCode = datostvpagada.InternalCode(devicemodel);
						
						TipoComando tipocomando = new TipoComando();
						tipocomando.setTcomando(accion);
						
						DatosAprov datosaprov = datostvpagada.datosaprov(tipocomando);
						
						comando = coman(parametros, datosaprov);
						
						respuesta = invoke(comando);
				/***************Aprovicionamiento eliminacion************/
				
				EliminacionEquipos(parametros,respuesta,comando.getDetalle().getTVpagada().getIdAccount());
				
			}else{
				
				Mensaje mens = new Mensaje();
				mens.setCodError(0);
				mens.setDetMensaje("OK");
				
				respuesta.setMensaje(mens);
				
				int idcontroller = IdController(parametros);
				EliminacionEquipos(parametros,respuesta,idcontroller);
			}
			
			return respuesta;
			
		}else{
			Respuesta respuesta = new Respuesta();
					
			Mensaje mensaje = new Mensaje();
			mensaje.setCodError(1);
			mensaje.setDetMensaje("ERROR: El equipo NO existe");
			mensaje.setDatosExtrasTVP(null);
			respuesta.setMensaje(mensaje);
			
			return respuesta;
		}	
	}
	
	private void EliminacionEquipos (Aprovisionamiento_Type parametros, Respuesta respuesta, int idcontroller){
		
		try {
			connection = datasource.getConnection();
			CallableStatement prepareCall = connection.prepareCall("{call YPKG_SGR.YPRD_ELIMINACION_EQUIPOS(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			prepareCall.setString(1, parametros.getBodyRequest().getNombreCiudad());
			prepareCall.setString(2, parametros.getBodyRequest().getBodega());
			prepareCall.setString(3, parametros.getBodyRequest().getIdEmpresa());
			prepareCall.setString(4, parametros.getBodyRequest().getCodigoArticulo());
			prepareCall.setInt(5, parametros.getBodyRequest().getDeviceModel());
			prepareCall.setString(6, parametros.getBodyRequest().getSerie());
			prepareCall.setString(7, parametros.getBodyRequest().getMacAddress1());
			prepareCall.setString(8, parametros.getBodyRequest().getMacAddress2());
			prepareCall.setString(9, parametros.getBodyRequest().getUsuario());
			prepareCall.setInt(10, Integer.parseInt(parametros.getBodyRequest().getIdRestype()));
			prepareCall.setString(11, parametros.getBodyRequest().getTipo());
			prepareCall.setInt(12, respuesta.getMensaje().getCodError());
			prepareCall.setString(13, respuesta.getMensaje().getDetMensaje());
			prepareCall.setInt(14, idcontroller);
			prepareCall.execute();

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}
