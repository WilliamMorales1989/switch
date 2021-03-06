package com.ec.tvcable.switchaprov.conax;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.switchyard.component.bean.Service;

import com.ec.tvcable.switchaprov.AprovisionamientoSGR.Aprovisionamiento_Type;
import com.ec.tvcable.switchaprov.service.tvpagada.Mensaje;
import com.ec.tvcable.switchaprov.service.tvpagada.Respuesta;

@Service(CreacionConax.class)
public class CreacionConaxBean implements CreacionConax {

	@Resource(mappedName = "java:/jdbc/DesaAppDS")
	private DataSource datasource;
	
	Connection connection;
	
	private Respuesta respuesta;
	
	@Override
	public Respuesta resp(Aprovisionamiento_Type parametros) {
		respuesta = creacion(parametros);
		return respuesta;
	}
	
	private Respuesta creacion (Aprovisionamiento_Type parametros){
		
		String equipoexistente = RLBCHECKRESOURCEVALUE(parametros);
		if (equipoexistente.equals("OK")){
			int idcontroller = IdController(parametros);
			
			Respuesta resp = new Respuesta();
			Mensaje mens = new Mensaje();
				mens.setCodError(0);
				mens.setDetMensaje("OK");
				mens.setDatosExtrasTVP(null);
			resp.setMensaje(mens);
			
			respuesta = CreacionEquiposConax(parametros, resp, idcontroller);
		
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

	private String RLBCHECKRESOURCEVALUE(Aprovisionamiento_Type parametros){
		
		String resultado = null;
		
		try {
			connection = datasource.getConnection();
			CallableStatement preparecall = connection.prepareCall("{call YLABPACK.RLBCHECKRESOURCEVALUE(?,?,?,?,?,?)}");
			preparecall.setString(1, parametros.getBodyRequest().getBodega());
			preparecall.setInt(2, parametros.getBodyRequest().getIdEmpresa());
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
	
	private int IdController(Aprovisionamiento_Type parametros){
		
		int resultado = 0;
		try {
			connection = datasource.getConnection();
			CallableStatement preparecall = connection.prepareCall("{call YLABPACK.RLBGETIDCONTROLER(?,?,?,?,?,?,?)}");
			preparecall.setString(1, parametros.getBodyRequest().getSerie());
			preparecall.setInt(2, parametros.getBodyRequest().getIdEmpresa());
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
	
	private Respuesta CreacionEquiposConax (Aprovisionamiento_Type parametros, Respuesta respuesta, int idcontroller){
		
		Respuesta resp = new Respuesta();
		
		try {
			connection = datasource.getConnection();
			CallableStatement prepareCall = connection.prepareCall("{call YPKG_SGR.YPRD_CREACION_EQUIPOS_CONAX(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			prepareCall.setString(1, parametros.getBodyRequest().getNombreCiudad());
			prepareCall.setString(2, parametros.getBodyRequest().getBodega());
			prepareCall.setInt(3, parametros.getBodyRequest().getIdEmpresa());
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
			
			Mensaje mens = new Mensaje();
				mens.setCodError(0);
				mens.setDetMensaje("OK");
				mens.setDatosExtrasTVP(null);
			resp.setMensaje(mens);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			Mensaje mens = new Mensaje();
				mens.setCodError(1);
				mens.setDetMensaje("ERROR: En la creacion del equipo");
				mens.setDatosExtrasTVP(null);
			resp.setMensaje(mens);
			
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return resp;
	}
}
