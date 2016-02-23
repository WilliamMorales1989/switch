package com.ec.tvcable.switchaprov.TvPagadaSGR;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import com.ec.tvcable.switchaprov.AprovisionamientoSGR.Aprovisionamiento_Type;
import com.ec.tvcable.switchaprov.service.tvpagada.Respuesta;

public class ValidacionEquipos {
	
	Connection connection;
	/*
	private Context ctx = null;*/
	
	private ErroresSQL ValidaEquipoTRANS(String serie, String empresa,DataSource datasource){
		
		String sqlequipos = "SELECT A.VVALUE,A.CODART,AR.NOMART,A.RESTYPE_ID,A.RESIDENTIFIERS_ID FROM YVLABKARDEX A,ARTICULOS@hiperk AR WHERE (A.COMPCOD=AR.CODEMP AND A.CODCLA = AR.CODCLA AND A.CODART=AR.CODART) AND A.VVALUE = ? AND A.DOCTYPE ='ET' AND A.DATEIN IS NULL AND A.STATUS='N' AND A.COMPCOD= ?";
		ErroresSQL errores = new ErroresSQL();
		
		try {
			
			connection = datasource.getConnection();
			PreparedStatement prepareStatementequiposlab = connection.prepareStatement(sqlequipos);
			prepareStatementequiposlab.setString(1, serie);
			prepareStatementequiposlab.setString(2, empresa);
			
			ResultSet resultSetequipos = prepareStatementequiposlab.executeQuery();
			
			int contador = 0;
			
			while(resultSetequipos.next()){
				contador++;
			}
				
			if (contador > 0){
				errores.setCodError(1);
				errores.setDetailError("ERROR: El equipo ya fue transferido");
			}else{
				errores.setCodError(0);
			}
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return errores;
	}
	
	private ErroresSQL ValidaEquipoLAB(String serie, String empresa, String bodega, DataSource datasource){
		
		String sqlequipos = "SELECT A.VVALUE, A.CODART, AR.NOMART, A.RESTYPE_ID, A.ID FROM YVLABRESOURCE A, ARTICULOS@hiperk AR WHERE (A.COMPCOD =AR.CODEMP AND A.CODCLA = AR.CODCLA AND A.CODART =AR.CODART) AND A.VVALUE = ? AND A.LOCALIZATION= ? AND A.COMPCOD = ? AND A.STATUS IN ('U','N')";
		ErroresSQL errores = new ErroresSQL();
		
		try {
			connection = datasource.getConnection();
			PreparedStatement prepareStatementequiposlab = connection.prepareStatement(sqlequipos);
			prepareStatementequiposlab.setString(1, serie);
			prepareStatementequiposlab.setString(2, bodega);
			prepareStatementequiposlab.setString(3, empresa);
			
			ResultSet resultSetequipos = prepareStatementequiposlab.executeQuery();

			int contador = 0;
			
			while(resultSetequipos.next()){
				contador++;
			}
			
			if (contador > 0){
				errores.setCodError(0);
			}else{
				errores.setCodError(1);
				errores.setDetailError("ERROR: El equipo ya no pertenece a esta bodega"+bodega);
			}
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return errores;
	}
	
	private ErroresSQL ValidaModeloEquipo(String serie, int modeloparam, DataSource datasource){
		
		String sqlequipos = "select B.DEVICEMODEL_ID from yvlabresource A,trmresourceitems B WHERE A.RESOURCEITEM_ID=B.ID AND VVALUE= ?";
		ErroresSQL errores = new ErroresSQL();
		
		try {
			connection = datasource.getConnection();
			PreparedStatement prepareStatementequiposlab = connection.prepareStatement(sqlequipos);
			prepareStatementequiposlab.setString(1, serie);
						
			ResultSet resultSetequipos = prepareStatementequiposlab.executeQuery();

			while (resultSetequipos.next()){
				int modelo = Integer.parseInt(resultSetequipos.getString("DEVICEMODEL_ID"));
				if(modelo == modeloparam){
					errores.setCodError(0);
				}else{
					errores.setCodError(1);
					errores.setDetailError("ERROR: El equipo ingresado no pertenece al modelo seleccionado");
				}
			}
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return errores;
	}
	
	public ErroresSQL verificacionEquipos (Aprovisionamiento_Type parametros, DataSource datasource){
		ErroresSQL error = new ErroresSQL();
		
		error = ValidaEquipoTRANS(parametros.getBodyRequest().getSerie(), parametros.getBodyRequest().getIdEmpresa(), datasource);
		
		if (error.getCodError() == 1){
			return error;
		}else{
			
			error = ValidaEquipoLAB(parametros.getBodyRequest().getSerie(), parametros.getBodyRequest().getIdEmpresa(), parametros.getBodyRequest().getBodega(), datasource);
			if (error.getCodError() == 1){
				return error;
			}else{
				error = ValidaModeloEquipo(parametros.getBodyRequest().getSerie(), parametros.getBodyRequest().getDeviceModel(), datasource);
				if (error.getCodError() == 1){
					return error;
				}else{
					return error;
				}
			}
		}
	}
	
	public int RLBCHECKMISTAKE (int codError, String DetailError, DataSource datasource){
		
		int resultado = 0;
		try {
			connection = datasource.getConnection();
			CallableStatement preparecall = connection.prepareCall("{call YLABPACK.RLBCHECKMISTAKE(?,?,?)}");
			preparecall.setInt(1, codError);
			preparecall.setString(2, DetailError);
			preparecall.registerOutParameter(3, Types.VARCHAR);
			preparecall.executeQuery();
			resultado = preparecall.getInt(3);
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}
	
	public void RLBREGISTROACCIONLAB (Aprovisionamiento_Type parametros, Respuesta respuesta, DataSource datasource){
		try {
			connection = datasource.getConnection();
			CallableStatement preparecall = connection.prepareCall("{call YPKG_SGR.RLBREGISTROACCIONLAB(?,?,?,?,?,?)}");
			preparecall.setString(1, parametros.getBodyRequest().getSerie());
			preparecall.setString(2, parametros.getBodyRequest().getUsuario());
			preparecall.setString(3, parametros.getBodyRequest().getBodega());
			preparecall.setString(4, parametros.getBodyRequest().getTipo());
			preparecall.setInt(5, respuesta.getMensaje().getCodError());
			preparecall.setString(6, respuesta.getMensaje().getDetMensaje());
			preparecall.executeQuery();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String citemEquipo (int tipoEquipo, DataSource datasource){
	
		String sqlCitemEquipos = "SELECT BVALUE FROM TREPVALUELISTITEMS WHERE VALUELISTSYMBOL = 'TVC_SGRWEB_TIPOEQUIPO_SP' and name = ?";
		String result = null;		
		try {
			connection = datasource.getConnection();
			PreparedStatement prepareStatementequiposlab = connection.prepareStatement(sqlCitemEquipos);
			prepareStatementequiposlab.setInt(1, tipoEquipo);
			ResultSet resultSetequipos = prepareStatementequiposlab.executeQuery();
						
			while(resultSetequipos.next()){
				result = resultSetequipos.getString("BVALUE");
			}
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
}
